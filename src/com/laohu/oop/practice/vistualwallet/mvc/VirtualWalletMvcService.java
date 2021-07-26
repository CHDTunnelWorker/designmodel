package com.laohu.oop.practice.vistualwallet.mvc;

import com.laohu.oop.practice.vistualwallet.*;

import java.math.BigDecimal;

/**
 * @program: designmodel
 * @description: 基于贫血模型的mvc实现
 * @author: Holland
 * @create: 2021-07-26 15:19
 **/
public class VirtualWalletMvcService implements VirtualWalletService {

    //通过构造函数/IOC框架注入
    private VirtualWalletRepository walletRepo;
    private VirtualWalletTransactionRepository transactionRepo;

    /**
     * @Description: 根据id获取钱包bo信息
     * @param: Long walletId
     * @return: VirtualWalletEntity
     * @auther: Holland
     * @date: 2021/7/26 3:26 下午
     */
    public VirtualWalletBo getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletBo walletBo = convert(walletEntity);
        return walletBo;
    }

    /**
     * @Description: 将虚拟钱包实体类转换至对应的BO类
     * @param: VirtualWalletEntity walletEntity
     * @return: VirtualWalletBo
     * @auther: Holland
     * @date: 2021/7/26 3:27 下午
     */
    private VirtualWalletBo convert(VirtualWalletEntity walletEntity) {
        VirtualWalletBo walletBo = new VirtualWalletBo();
        walletBo.setId(walletEntity.getId());
        walletBo.setCreateTimestamp(walletEntity.getCreateTimestamp());
        walletBo.setBalance(walletEntity.getBalance());
        return walletBo;
    }

    @Override
    public BigDecimal getBalance(Long walletId) {
        return walletRepo.getBalance(walletId);
    }

    /**
     * @Description: 扣钱并记录交易流水
     * @param: Long walletId, BigDecimal amount
     * @auther: Holland
     * @date: 2021/7/26 3:30 下午
     */
    @Override
    public void debit(Long walletId, BigDecimal amount) {
        //查询并判断余额
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("...");
        }

        //创建并保存交易流水
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTimestamp(System.currentTimeMillis());
        transactionEntity.setTypeCode(TransactionTypeEnum.DEBIT.getCode());
        transactionEntity.setFromWalletId(walletId);
        transactionRepo.saveTransaction(transactionEntity);
        walletRepo.updateBalance(walletId, balance.subtract(amount));
    }

    /**
     * @Description: 入账
     * @param: Long walletId, BigDecimal amount
     * @auther: Holland
     * @date: 2021/7/26 4:36 下午
     */
    @Override
    public void credit(Long walletId, BigDecimal amount) {
        //创建并保存交易流水
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTimestamp(System.currentTimeMillis());
        transactionEntity.setTypeCode(TransactionTypeEnum.CREDIT.getCode());
        transactionEntity.setFromWalletId(walletId);
        transactionRepo.saveTransaction(transactionEntity);

        //查询余额
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        walletRepo.updateBalance(walletId, balance.add(amount));
    }

    @Override
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        //创建并保存交易流水
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTimestamp(System.currentTimeMillis());
        transactionEntity.setTypeCode(TransactionTypeEnum.TRANSFER.getCode());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionRepo.saveTransaction(transactionEntity);

        //账户出账与入账
        debit(fromWalletId, amount);
        credit(toWalletId, amount);
    }
}
