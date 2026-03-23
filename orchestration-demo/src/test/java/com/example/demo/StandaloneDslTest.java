package com.example.demo;

import com.example.demo.model.*;
import com.ibm.cbmp.fabric.collab.orchestration.*;
import com.ibm.cbmp.fabric.collab.orchestration.camel.FlowToCamelConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.saga.InMemorySagaService;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 純 DSL 測試（不依賴 Spring Boot）
 *
 * 展示框架底層實際運作方式：
 * 1. FlowDefinition DSL 建構 FlowModel
 * 2. FlowToCamelConverter.convert() 轉換為 Camel Route
 * 3. CamelContext 執行 Route
 * 4. Saga 補償機制驗證
 */
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StandaloneDslTest {

    private CamelContext camelContext;
    private ProducerTemplate template;

    @AfterEach
    void tearDown() throws Exception {
        if (template != null) template.stop();
        if (camelContext != null) camelContext.stop();
    }

    /**
     * 輔助方法：設定 CamelContext 並註冊 FlowModel
     */
    private void setupCamelContext(FlowModel<?, ?, ?> flowModel) throws Exception {
        camelContext = new DefaultCamelContext();

        // 註冊 Saga Service（補償機制必須）
        InMemorySagaService sagaService = new InMemorySagaService();
        sagaService.setCamelContext(camelContext);
        camelContext.addService(sagaService);
        camelContext.getRegistry().bind("sagaService", sagaService);

        // 轉換 FlowModel → Camel Route
        RouteBuilder routeBuilder = FlowToCamelConverter.convert(flowModel);
        camelContext.addRoutes(routeBuilder);
        camelContext.start();
        template = camelContext.createProducerTemplate();
    }

    // ==================== 測試 1: 成功流程 ====================

    @Test
    @Order(1)
    @DisplayName("成功流程: 驗證 → 扣款 → 入帳 → 組裝回應")
    void testSuccessFlow() throws Exception {
        FlowModel<TransferRequest, TransferRequest, TransferResponse> flow = buildSuccessFlow();
        setupCamelContext(flow);

        TransferRequest request = new TransferRequest("ACC-A", "ACC-B", new BigDecimal("500.00"));

        TransferResponse response = template.requestBody(
            "direct:SuccessFlow", request, TransferResponse.class
        );

        assertNotNull(response);
        assertTrue(response.isSuccess());
        log.info("成功結果: {}", response);
    }

    // ==================== 測試 2: 入帳失敗 → 觸發扣款補償 ====================

    @Test
    @Order(2)
    @DisplayName("入帳失敗: 觸發扣款補償")
    void testCreditFailure_TriggersDebitCompensation() throws Exception {
        // 用一個 boolean 陣列追蹤補償是否執行
        boolean[] compensated = {false};

        FlowModel<TransferRequest, TransferRequest, CreditResult> flow =
            buildFlowWithCreditFailure(compensated);
        setupCamelContext(flow);

        TransferRequest request = new TransferRequest("ACC-C", "ACC-D", new BigDecimal("1000.00"));

        // 預期拋出異常
        assertThrows(CamelExecutionException.class, () ->
            template.requestBody("direct:CreditFailFlow", request, CreditResult.class)
        );

        // 等待 Saga 非同步補償完成
        Thread.sleep(500);

        assertTrue(compensated[0], "扣款補償應該被觸發");
        log.info("補償已執行");
    }

    // ==================== 測試 3: Condition 條件分支 ====================

    @Test
    @Order(3)
    @DisplayName("Condition: 根據金額選擇不同處理分支")
    void testConditionBranching() throws Exception {
        FlowModel<TransferRequest, TransferRequest, TransferResponse> flow = buildConditionFlow();
        setupCamelContext(flow);

        // 大額轉帳
        TransferRequest largeRequest = new TransferRequest("ACC-E", "ACC-F", new BigDecimal("500000.00"));
        TransferResponse largeResponse = template.requestBody(
            "direct:ConditionFlow", largeRequest, TransferResponse.class
        );
        assertEquals("大額轉帳處理", largeResponse.getMessage());

        // 一般轉帳
        TransferRequest normalRequest = new TransferRequest("ACC-G", "ACC-H", new BigDecimal("100.00"));
        TransferResponse normalResponse = template.requestBody(
            "direct:ConditionFlow", normalRequest, TransferResponse.class
        );
        assertEquals("一般轉帳處理", normalResponse.getMessage());

        log.info("條件分支測試通過");
    }

    // ==================== 測試 4: StepPolicy 重試 ====================

    @Test
    @Order(4)
    @DisplayName("StepPolicy: 步驟失敗後重試成功")
    void testRetryPolicy() throws Exception {
        int[] attempts = {0};

        SimpleStep<TransferRequest, TransferRequest, TransferRequest> retryStep =
            new SimpleStepBuilder<TransferRequest, TransferRequest, TransferRequest>()
                .name("retryStep")
                .executor((root, input, shared) -> {
                    attempts[0]++;
                    log.info("嘗試第 {} 次", attempts[0]);
                    if (attempts[0] < 3) {
                        throw new RuntimeException("模擬暫時性錯誤");
                    }
                    return root;
                })
                .policy(StepPolicy.builder()
                    .maxRetries(3)
                    .retryDelayMillis(100)
                    .build())
                .build();

        SimpleStep<TransferRequest, TransferRequest, TransferResponse> responseStep =
            new SimpleStepBuilder<TransferRequest, TransferRequest, TransferResponse>()
                .name("response")
                .executor((root, input, shared) ->
                    new TransferResponse(true, "重試後成功", "TX-RETRY"))
                .build();

        FlowModel<TransferRequest, TransferRequest, TransferResponse> flow =
            FlowDefinition.start("RetryFlow", TransferRequest.class)
                .then("retryStep", retryStep)
                .then("response", responseStep)
                .build();

        setupCamelContext(flow);

        TransferRequest request = new TransferRequest("ACC-I", "ACC-J", new BigDecimal("100.00"));
        TransferResponse response = template.requestBody(
            "direct:RetryFlow", request, TransferResponse.class
        );

        assertTrue(response.isSuccess());
        assertEquals(3, attempts[0], "應該嘗試 3 次");
        log.info("重試測試通過，嘗試次數: {}", attempts[0]);
    }

    // ==================== Flow 建構方法 ====================

    private FlowModel<TransferRequest, TransferRequest, TransferResponse> buildSuccessFlow() {
        return FlowDefinition.start("SuccessFlow", TransferRequest.class)
            .then("validate", (root, input, shared) -> {
                log.info("[validate] {} → {}, ${}", root.getFromAccount(), root.getToAccount(), root.getAmount());
                return root;
            })
            .thenSaga("debit",
                (root, input, shared) -> {
                    log.info("[debit] 扣款 ${}", root.getAmount());
                    String txId = "DEBIT-" + System.currentTimeMillis();
                    shared.put(TransferContextKey.DEBIT_RECORD_ID, txId);
                    return new DebitResult(true, txId, root.getAmount());
                },
                (root, input, shared) -> {
                    log.info("[debit-comp] 回沖扣款");
                })
            .thenSaga("credit",
                (root, input, shared) -> {
                    log.info("[credit] 入帳 ${}", root.getAmount());
                    String txId = "CREDIT-" + System.currentTimeMillis();
                    shared.put(TransferContextKey.CREDIT_RECORD_ID, txId);
                    return new CreditResult(true, txId, root.getAmount());
                },
                (root, input, shared) -> {
                    log.info("[credit-comp] 回沖入帳");
                })
            .then("buildResponse", (root, input, shared) -> {
                String debitId = (String) shared.get(TransferContextKey.DEBIT_RECORD_ID);
                String creditId = (String) shared.get(TransferContextKey.CREDIT_RECORD_ID);
                return new TransferResponse(true, "轉帳成功", debitId + "/" + creditId);
            })
            .build();
    }

    private FlowModel<TransferRequest, TransferRequest, CreditResult> buildFlowWithCreditFailure(
            boolean[] compensated) {
        return FlowDefinition.start("CreditFailFlow", TransferRequest.class)
            .thenSaga("debit",
                (root, input, shared) -> {
                    log.info("[debit] 扣款成功");
                    shared.put(TransferContextKey.DEBIT_RECORD_ID, "DEBIT-123");
                    return new DebitResult(true, "DEBIT-123", root.getAmount());
                },
                (root, input, shared) -> {
                    log.info("[debit-comp] 補償：回沖扣款");
                    compensated[0] = true;
                })
            .then("credit", (root, input, shared) -> {
                log.info("[credit] 入帳失敗！");
                throw new RuntimeException("入帳服務不可用");
            })
            .build();
    }

    private FlowModel<TransferRequest, TransferRequest, TransferResponse> buildConditionFlow() {
        return FlowDefinition.start("ConditionFlow", TransferRequest.class)
            .then("checkAmount",
                FlowDSL.<TransferRequest, TransferRequest, TransferResponse>condition()
                    .when(
                        (root, current, shared) ->
                            root.getAmount().compareTo(new BigDecimal("100000")) > 0,
                        branch -> branch.then("largeTransfer", (root, input, shared) -> {
                            log.info("[大額] 金額 {} 走大額處理", root.getAmount());
                            return new TransferResponse(true, "大額轉帳處理", "TX-LARGE");
                        })
                    )
                    .otherwise(
                        branch -> branch.then("normalTransfer", (root, input, shared) -> {
                            log.info("[一般] 金額 {} 走一般處理", root.getAmount());
                            return new TransferResponse(true, "一般轉帳處理", "TX-NORMAL");
                        })
                    )
            )
            .build();
    }
}
