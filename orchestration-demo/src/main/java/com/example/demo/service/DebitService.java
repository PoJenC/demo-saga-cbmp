package com.example.demo.service;

import com.example.demo.model.DebitResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 扣款服務（模擬）
 */
@Slf4j
@Service
public class DebitService {

    public DebitResult debit(String account, BigDecimal amount) {
        log.info("扣款: 帳號={}, 金額={}", account, amount);
        String txId = "DEBIT-" + System.currentTimeMillis();
        return new DebitResult(true, txId, amount);
    }

    public void revert(String transactionId, String account, BigDecimal amount) {
        log.info("回沖扣款: txId={}, 帳號={}, 金額={}", transactionId, account, amount);
    }
}
