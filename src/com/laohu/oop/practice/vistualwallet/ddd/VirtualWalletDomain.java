package com.laohu.oop.practice.vistualwallet.ddd;

import java.math.BigDecimal;

/**
 * @program: designmodel
 * @description: 虚拟钱包domain充血模型, 能够支持丰富的扩展, 且可以方便的在一个类中替换对应的业务实现
 * @author: Holland
 * @create: 2021-07-26 16:46
 **/
public class VirtualWalletDomain {

    private Long id;
    private Long createTimestamp = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;
    /**
     * 是否支持透支
     */
    private boolean isAllowedOverdraft = true;
    /**
     * 透支额度
     */
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    /**
     * 冻结额度
     */
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    public VirtualWalletDomain(Long preAllocatedId, BigDecimal balance) {
        this.id = preAllocatedId;
        this.balance = balance;
    }

    public BigDecimal balance() {
        return this.balance;
    }

    public void freeze(BigDecimal amount) {
        //冻结额度
    }

    public void unfreeze(BigDecimal amount) {
        //解冻额度
    }

    public void increaseOverdraftAmount(BigDecimal amount) {
        //增加透支额度
    }

    public void decreaseOverdraftAmount(BigDecimal amount) {
        //减少透支额度
    }

    public void closeOverdraft() {
        //关闭透支功能
    }

    public void openOverdraft() {
        //打开透支功能
    }

    /**
     * @Description: 计算可用余额
     * @return: BigDecimal
     * @auther: Holland
     * @date: 2021/7/26 5:34 下午
     */
    public BigDecimal getAvaliableBalance() {
        BigDecimal totalAvaliableBalance = this.balance.subtract(this.frozenAmount);
        if (isAllowedOverdraft) {
            totalAvaliableBalance = totalAvaliableBalance.add(this.overdraftAmount);
        }
        return totalAvaliableBalance;
    }

    /**
     * @Description: 充血模型封装对balance的入账操作
     * @param: BigDecimal amount
     * @auther: Holland
     * @date: 2021/7/26 5:02 下午
     */
    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("...");
        }
        this.balance = this.balance.add(amount);
    }

    /**
     * @Description: 充血模型封装对balance的出账操作
     * @param: BigDecimal amount
     * @auther: Holland
     * @date: 2021/7/26 5:02 下午
     */
    public void debit(BigDecimal amount) {
        BigDecimal avaliableBalance = getAvaliableBalance();
        if (avaliableBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("...");
        }
        this.balance = this.balance.subtract(amount);
    }
}
