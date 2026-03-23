package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 轉帳回應
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponse {
    private boolean success;
    private String message;
    private String transactionId;
}
