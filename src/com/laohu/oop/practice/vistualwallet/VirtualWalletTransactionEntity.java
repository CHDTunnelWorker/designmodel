package com.laohu.oop.practice.vistualwallet;

import java.math.BigDecimal;

/**
 * @program: designmodel
 * @description: 虚拟钱包交易流水实体类
 * @author: Holland
 * @create: 2021-07-23 17:48
 **/
public class VirtualWalletTransactionEntity {
    /**
     * 交易流水号
     */
    private String transactionCode;
    /**
     * 创建时间戳
     */
    private Long createTimestamp;
    /**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 交易类型
     */
    private String typeCode;
    /**
     * 入账户id
     */
    private Long fromWalletId;
    /**
     * 出账户id
     */
    private Long toWalletId;

    public String getTransactionCode() {
        return transactionCode;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public Long getFromWalletId() {
        return fromWalletId;
    }

    public Long getToWalletId() {
        return toWalletId;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setFromWalletId(Long fromWalletId) {
        this.fromWalletId = fromWalletId;
    }

    public void setToWalletId(Long toWalletId) {
        this.toWalletId = toWalletId;
    }
}
