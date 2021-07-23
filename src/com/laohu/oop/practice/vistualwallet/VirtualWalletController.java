package com.laohu.oop.practice.vistualwallet;

import java.math.BigDecimal;

/**
 * @program: designmodel
 * @description: 虚拟钱包controller类, 公用
 * @author: Holland
 * @create: 2021-07-23 17:36
 **/
public class VirtualWalletController {

    //通过ioc框架或者构造函数进行注入
    private VirtualWalletService virtualWalletService;

    //查询余额
    private BigDecimal getBalance(Long walletId) {
        return virtualWalletService.getBalance(walletId);
    }

    //出账
    private void debit(Long walletId, BigDecimal amount) {
        virtualWalletService.debit(walletId, amount);
    }

    //入账
    private void credit(Long walletId, BigDecimal amount) {
        virtualWalletService.credit(walletId, amount);
    }

    //转账
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        virtualWalletService.transfer(fromWalletId, toWalletId, amount);
    }
}
