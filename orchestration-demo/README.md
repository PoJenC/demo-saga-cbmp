# Orchestration Framework Demo

展示 `cbmp-collab-orchestration` 框架的**正確使用方式**。

## 專案結構

```
orchestration-demo/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── flow/
│   │   └── TransferFlowDefinition.java    ← 流程定義（核心）
│   ├── model/
│   │   ├── TransferRequest.java           ← 輸入
│   │   ├── TransferResponse.java          ← 輸出
│   │   ├── TransferContextKey.java        ← 共享狀態 Key
│   │   ├── DebitResult.java               ← 步驟結果
│   │   └── CreditResult.java             ← 步驟結果
│   └── service/
│       ├── DebitService.java              ← 模擬扣款服務
│       └── CreditService.java            ← 模擬入帳服務
└── src/test/java/com/example/demo/
    ├── TransferFlowTest.java              ← Spring Boot 整合測試
    └── StandaloneDslTest.java             ← 純 DSL 測試（4 個情境）
```

## 執行方式

```bash
# 先確保 cbmp-fabric-2.0 已 install 到本地 Maven
cd ../cbmp-fabric-2.0
mvn install -DskipTests

# 執行測試
cd ../orchestration-demo
mvn test
```

## 文件 vs 實際程式碼的落差

| # | 文件描述 | 實際程式碼 | 本專案的修正 |
|---|---------|-----------|-------------|
| 1 | Package: `collab.neworchestration` | 實際: `collab.orchestration` | 使用正確 package |
| 2 | Compensation 4 參數 `(root, input, output, shared)` | 實際只有 3 參數 `(root, input, shared)` | 使用 3 參數，需要 output 時存入 SharedContext |
| 3 | 文件直接呼叫 `FlowDefinition.start()` | Spring Boot 整合時框架傳入 `FlowBuilder` | 展示兩種方式 |
| 4 | 未提到如何執行流程 | 需透過 `FlowToCamelConverter` + `ProducerTemplate` | 完整展示執行流程 |
| 5 | 未提到 Saga Service 註冊 | 必須註冊 `InMemorySagaService` 才能觸發補償 | 明確展示 |
| 6 | README 列「FlowExecutor 待實作」 | 已透過 Camel 實現，README 過時 | N/A |

## 核心使用模式

### 完整執行 4 步驟

```java
// 1. 用 DSL 定義流程
FlowModel flow = FlowDefinition.start("MyFlow", Input.class)
    .then("step1", simpleStep)
    .then("step2", sagaStep)     // 有補償
    .build();

// 2. 註冊 Saga Service
InMemorySagaService sagaService = new InMemorySagaService();
sagaService.setCamelContext(camelContext);
camelContext.addService(sagaService);
camelContext.getRegistry().bind("sagaService", sagaService);

// 3. 轉換為 Camel Route
RouteBuilder routes = FlowToCamelConverter.convert(flow);
camelContext.addRoutes(routes);

// 4. 執行
ProducerTemplate template = camelContext.createProducerTemplate();
Output result = (Output) template.requestBody("direct:MyFlow", input);
```

### 補償函數：只有 3 個參數

```java
// ❌ 文件描述（錯誤）
.compensation((root, input, output, shared) -> { ... })

// ✅ 實際用法
.compensation((root, input, shared) -> {
    // 需要正向結果時，從 SharedContext 取
    String recordId = (String) shared.get(MyContextKey.RECORD_ID);
    service.revert(recordId);
})
```
