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
}
