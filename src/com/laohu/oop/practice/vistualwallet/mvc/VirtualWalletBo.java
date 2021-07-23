package com.laohu.oop.practice.vistualwallet.mvc;

import java.math.BigDecimal;

/**
 * @program: designmodel
 * @description: 虚拟钱包bo, 用于业务数据处理
 * @author: Holland
 * @create: 2021-07-23 17:34
 **/
public class VirtualWalletBo {
    /**
     * 钱包id
     */
    private Long id;
    /**
     * 钱包创建时间
     */
    private Long createTimestamp;
    /**
     * 钱包余额
     */
    private BigDecimal balance;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
