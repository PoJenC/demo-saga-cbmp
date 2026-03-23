package com.example.demo.service;

import com.example.demo.model.CreditResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 入帳服務（模擬）
 */
@Slf4j
@Service
public class CreditService {

    public CreditResult credit(String account, BigDecimal amount) {
        log.info("入帳: 帳號={}, 金額={}", account, amount);
        String txId = "CREDIT-" + System.currentTimeMillis();
        return new CreditResult(true, txId, amount);
    }

    public void revert(String transactionId, String account, BigDecimal amount) {
        log.info("回沖入帳: txId={}, 帳號={}, 金額={}", transactionId, account, amount);
    }
}
