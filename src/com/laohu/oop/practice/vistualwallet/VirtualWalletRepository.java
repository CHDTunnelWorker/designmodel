package com.laohu.oop.practice.vistualwallet;

import java.math.BigDecimal;

/**
 * @program: designmodel
 * @description: 虚拟钱包数据层--公用
 * @author: Holland
 * @create: 2021-07-23 17:45
 **/
public class VirtualWalletRepository {

    public VirtualWalletEntity getWalletEntity(Long walletId) {
        //模拟根据walletId查询到的钱包数据
        return new VirtualWalletEntity();
    }

    public BigDecimal getBalance(Long walletId) {
        //模拟根据id从数据库查询对应的钱包余额
        return new BigDecimal("10.00");
    }

    public void updateBalance(Long walletId, BigDecimal amount) {
        //模拟更新对应钱包的余额数据
    }
}
