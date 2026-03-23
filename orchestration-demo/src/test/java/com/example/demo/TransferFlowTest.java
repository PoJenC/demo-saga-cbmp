package com.example.demo;

import com.example.demo.flow.TransferFlowDefinition;
import com.example.demo.model.TransferRequest;
import com.example.demo.model.TransferResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 轉帳流程整合測試
 *
 * 驗證：
 * 1. 正常流程：所有步驟執行成功
 * 2. 驗證失敗：Step 1 拋出異常
 */
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransferFlowTest {

    @Autowired
    private TransferFlowDefinition transferFlow;

    @Test
    @Order(1)
    @DisplayName("成功流程: 驗證 → 扣款 → 入帳 → 回應")
    void testSuccessfulTransfer() throws Exception {
        TransferRequest request = new TransferRequest("ACC-001", "ACC-002", new BigDecimal("1000.00"));

        TransferResponse response = transferFlow.execute(request);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals("轉帳成功", response.getMessage());
        assertNotNull(response.getTransactionId());

        log.info("轉帳結果: {}", response);
    }

    @Test
    @Order(2)
    @DisplayName("驗證失敗: 金額為 0 時拋出異常")
    void testValidationFailure() {
        TransferRequest request = new TransferRequest("ACC-001", "ACC-002", BigDecimal.ZERO);

        assertThrows(Exception.class, () -> transferFlow.execute(request));
    }
}
