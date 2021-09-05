package com.laohu.model.behavior.strategy.classic;

/**
 * @program: designmodel
 * @description: 折扣策略接口
 * @author: Holland
 * @create: 2021-09-05 15:44
 **/
public interface DiscountStrategy {
    double calDiscount(Double oriPrice);
}
