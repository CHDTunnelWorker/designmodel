package com.laohu.oop.practice.vistualwallet;

/**
 * @author Holland
 * @title: TransactionTypeEnum
 * @projectName designmodel
 * @description: 交易流水的交易类型枚举
 * @date 2021/7/235:52 下午
 */
public enum TransactionTypeEnum {

    DEBIT("000001", "出账"),
    CREDIT("000002", "入账"),
    TRANSFER("000003", "转账");

    private String code;

    private String name;

    TransactionTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
