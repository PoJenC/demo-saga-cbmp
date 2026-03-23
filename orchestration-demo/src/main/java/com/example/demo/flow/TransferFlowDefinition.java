package com.example.demo.flow;

import com.example.demo.model.*;
import com.example.demo.service.CreditService;
import com.example.demo.service.DebitService;
import com.ibm.cbmp.fabric.collab.orchestration.*;
import com.ibm.cbmp.fabric.collab.orchestration.camel.FlowToCamelConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.saga.InMemorySagaService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 轉帳流程定義
 *
 * 展示 cbmp-collab-orchestration 框架的正確使用方式：
 * 1. 使用 FlowDefinition DSL 定義流程
 * 2. 使用 FlowToCamelConverter 轉換為 Camel Route
 * 3. 透過 ProducerTemplate 執行流程
 *
 * 流程：
 *   Step 1: 驗證（SimpleStep - 無補償）
 *   Step 2: 扣款（SagaStep - 有補償）
 *   Step 3: 入帳（SagaStep - 有補償）
 *   Step 4: 組裝回應（SimpleStep - 無補償）
 *
 * 補償情境（Step 3 失敗時）：
 *   Step1 ✅ → Step2 ✅ → Step3 ❌
 *                 ↓
 *              Comp2（回沖扣款）
 */
@Slf4j
@Component
public class TransferFlowDefinition {

    private static final String FLOW_NAME = "TransferFlow";

    private final DebitService debitService;
    private final CreditService creditService;
    private final CamelContext camelContext;

    private ProducerTemplate template;
    private boolean routeRegistered = false;

    public TransferFlowDefinition(DebitService debitService,
                                  CreditService creditService,
                                  CamelContext camelContext) {
        this.debitService = debitService;
        this.creditService = creditService;
        this.camelContext = camelContext;
    }

    /**
     * 執行轉帳流程
     */
    @SuppressWarnings("unchecked")
    public TransferResponse execute(TransferRequest request) throws Exception {
        ensureRouteRegistered();
        return (TransferResponse) template.requestBody("direct:" + FLOW_NAME, request);
    }

    /**
     * 確保 Camel Route 已註冊（僅首次呼叫時執行）
     */
    private synchronized void ensureRouteRegistered() throws Exception {
        if (routeRegistered) {
            return;
        }

        // 1. 使用 DSL 建構 FlowModel
        FlowModel<TransferRequest, TransferRequest, TransferResponse> flowModel = buildFlowModel();

        // 2. 註冊 Saga Service（補償機制需要）
        InMemorySagaService sagaService = new InMemorySagaService();
        sagaService.setCamelContext(camelContext);
        camelContext.addService(sagaService);
        camelContext.getRegistry().bind("sagaService", sagaService);

        // 3. 轉換為 Camel Route 並註冊
        RouteBuilder routeBuilder = FlowToCamelConverter.convert(flowModel);
        camelContext.addRoutes(routeBuilder);

        // 4. 建立 ProducerTemplate
        template = camelContext.createProducerTemplate();

        routeRegistered = true;
        log.info("Flow [{}] 已註冊到 CamelContext", FLOW_NAME);
    }

    /**
     * 使用 DSL 定義流程模型
     *
     * 注意事項：
     * - 使用 FlowDefinition.start() 作為進入點
     * - SimpleStep: 無補償的步驟（查詢、驗證）
     * - SagaStep: 有補償的步驟（扣款、入帳等有副作用的操作）
     * - SharedContext + ContextKey: 跨步驟共享狀態
     * - compensation 函數只有 3 個參數: (root, input, shared)，沒有 output
     *   → 如果補償需要正向執行的結果，請存入 SharedContext
     */
    private FlowModel<TransferRequest, TransferRequest, TransferResponse> buildFlowModel() {

        // ==================== Step 1: 驗證（SimpleStep） ====================
        SimpleStep<TransferRequest, TransferRequest, TransferRequest> validateStep =
            new SimpleStepBuilder<TransferRequest, TransferRequest, TransferRequest>()
                .name("validate")
                .executor((root, input, shared) -> {
                    log.info("[validate] 驗證轉帳: {} → {}, 金額: {}",
                        root.getFromAccount(), root.getToAccount(), root.getAmount());

                    if (root.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                        throw new IllegalArgumentException("金額必須大於 0");
                    }
                    return root;
                })
                .build();

        // ==================== Step 2: 扣款（SagaStep + 補償） ====================
        SagaStep<TransferRequest, TransferRequest, DebitResult> debitStep =
            new SagaStepBuilder<TransferRequest, TransferRequest, DebitResult>()
                .name("debit")

                // 正向執行
                .executor((root, input, shared) -> {
                    DebitResult result = debitService.debit(root.getFromAccount(), root.getAmount());

                    // ⭐ 將結果存入 SharedContext，供補償時使用
                    shared.put(TransferContextKey.DEBIT_RECORD_ID, result.getTransactionId());
                    shared.put(TransferContextKey.DEBIT_STATUS, "DEBITED");

                    return result;
                })

                // 反向補償（注意：只有 3 個參數 root, input, shared）
                .compensation((root, input, shared) -> {
                    String recordId = (String) shared.get(TransferContextKey.DEBIT_RECORD_ID);
                    log.info("[debit-compensation] 回沖扣款: recordId={}", recordId);

                    debitService.revert(recordId, root.getFromAccount(), root.getAmount());
                    shared.put(TransferContextKey.DEBIT_STATUS, "COMPENSATED");
                })

                .build();

        // ==================== Step 3: 入帳（SagaStep + 補償） ====================
        SagaStep<TransferRequest, DebitResult, CreditResult> creditStep =
            new SagaStepBuilder<TransferRequest, DebitResult, CreditResult>()
                .name("credit")

                .executor((root, input, shared) -> {
                    CreditResult result = creditService.credit(root.getToAccount(), root.getAmount());
                    shared.put(TransferContextKey.CREDIT_RECORD_ID, result.getTransactionId());
                    return result;
                })

                .compensation((root, input, shared) -> {
                    String recordId = (String) shared.get(TransferContextKey.CREDIT_RECORD_ID);
                    log.info("[credit-compensation] 回沖入帳: recordId={}", recordId);

                    creditService.revert(recordId, root.getToAccount(), root.getAmount());
                })

                .build();

        // ==================== Step 4: 組裝回應（SimpleStep） ====================
        SimpleStep<TransferRequest, CreditResult, TransferResponse> responseStep =
            new SimpleStepBuilder<TransferRequest, CreditResult, TransferResponse>()
                .name("buildResponse")
                .executor((root, input, shared) -> {
                    String debitId = (String) shared.get(TransferContextKey.DEBIT_RECORD_ID);
                    String creditId = (String) shared.get(TransferContextKey.CREDIT_RECORD_ID);

                    return new TransferResponse(
                        true,
                        "轉帳成功",
                        debitId + "/" + creditId
                    );
                })
                .build();

        // ==================== 組裝流程 ====================
        return FlowDefinition.start(FLOW_NAME, TransferRequest.class)
            .then("validate", validateStep)
            .then("debit", debitStep)
            .then("credit", creditStep)
            .then("buildResponse", responseStep)
            .build();
    }
}
