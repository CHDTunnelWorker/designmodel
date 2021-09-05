package com.laohu.model.behavior.strategy.classic;

/**
 * @author Holland
 * @title: TransactionTypeEnum
 * @projectName designmodel
 * @description: 交易流水的交易类型枚举
 * @date 2021/7/235:52 下午
 */
public enum OrderType {

    NORMAL("000001", "正常"),
    GROUP("000002", "组"),
    PROMOTION("000003", "优先");

    private String code;

    private String name;

    OrderType(String code, String name) {
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
