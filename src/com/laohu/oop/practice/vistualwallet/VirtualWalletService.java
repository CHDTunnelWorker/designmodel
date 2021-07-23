package com.laohu.oop.practice.vistualwallet;

import java.math.BigDecimal;

/**
 * @author Holland
 * @title: VirtualWalletService
 * @projectName designmodel
 * @description: 虚拟钱包实现接口--公用
 * @date 2021/7/235:37 下午
 */
public interface VirtualWalletService {

    //查询余额
    BigDecimal getBalance(Long walletId);

    //出账
    void debit(Long walletId, BigDecimal amount);

    //入账
    void credit(Long walletId, BigDecimal amount);

    //转账
    void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount);

}
