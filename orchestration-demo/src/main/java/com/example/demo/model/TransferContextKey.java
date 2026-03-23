package com.example.demo.model;

import com.ibm.cbmp.fabric.collab.orchestration.ContextKey;

/**
 * 轉帳流程的 ContextKey（型別安全的共享狀態 key）
 *
 * 使用 enum 實作 ContextKey 介面：
 * - 集中管理所有 key
 * - 編譯期型別檢查
 * - IDE 自動完成
 */
public enum TransferContextKey implements ContextKey<Object> {

    DEBIT_RECORD_ID(String.class),
    CREDIT_RECORD_ID(String.class),
    DEBIT_STATUS(String.class);

    private final Class<?> valueType;

    TransferContextKey(Class<?> type) {
        this.valueType = type;
    }

    @Override
    public String key() {
        return this.name();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Object> type() {
        return (Class<Object>) valueType;
    }
}
