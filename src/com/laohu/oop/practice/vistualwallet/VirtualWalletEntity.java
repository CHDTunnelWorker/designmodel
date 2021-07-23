package com.laohu.oop.practice.vistualwallet;

import java.math.BigDecimal;

/**
 * @program: designmodel
 * @description: 虚拟钱包实体类, 用于数据的存取
 * @author: Holland
 * @create: 2021-07-23 17:31
 **/
public class VirtualWalletEntity {
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
