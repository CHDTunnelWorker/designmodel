package com.laohu.oop.practice.vistualwallet.ddd;

import com.laohu.oop.practice.vistualwallet.*;
import com.laohu.oop.practice.vistualwallet.mvc.VirtualWalletBo;

import java.math.BigDecimal;

/**
 * @program: designmodel
 * @description: 虚拟钱包充血模型实现类
 * @author: Holland
 * @create: 2021-07-26 17:06
 **/
public class VirtualWalletDddService implements VirtualWalletService {
    //通过构造函数/IOC框架注入
    private VirtualWalletRepository walletRepo;
    private VirtualWalletTransactionRepository transactionRepo;

    /**
     * @Description: 根据id获取钱包bo信息
     * @param: Long walletId
     * @return: VirtualWalletDomain
     * @auther: Holland
     * @date: 2021/7/26 3:26 下午
     */
    public VirtualWalletDomain getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletDomain walletDomain = convert(walletEntity);
        return walletDomain;
    }

    private VirtualWalletDomain convert(VirtualWalletEntity walletEntity) {
        return new VirtualWalletDomain(walletEntity.getId(), walletEntity.getBalance());
    }

    @Override
    public BigDecimal getBalance(Long walletId) {
        return walletRepo.getBalance(walletId);
    }

    @Override
    public void debit(Long walletId, BigDecimal amount) {
        //充血模型操作模式
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletDomain walletDomain = convert(walletEntity);
        walletDomain.debit(amount);
        walletRepo.updateBalance(walletId, walletDomain.balance());

        //创建并保存交易流水
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTimestamp(System.currentTimeMillis());
        transactionEntity.setTypeCode(TransactionTypeEnum.DEBIT.getCode());
        transactionEntity.setFromWalletId(walletId);
        transactionRepo.saveTransaction(transactionEntity);
    }

    @Override
    public void credit(Long walletId, BigDecimal amount) {
        //创建并保存交易流水
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTimestamp(System.currentTimeMillis());
        transactionEntity.setTypeCode(TransactionTypeEnum.CREDIT.getCode());
        transactionEntity.setFromWalletId(walletId);
        transactionRepo.saveTransaction(transactionEntity);

        //充血模型操作模式
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletDomain walletDomain = convert(walletEntity);
        walletDomain.credit(amount);
        walletRepo.updateBalance(walletId, walletDomain.balance());
    }

    @Override
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        //...与贫血模型传统开发模式代码一样...
    }

}
