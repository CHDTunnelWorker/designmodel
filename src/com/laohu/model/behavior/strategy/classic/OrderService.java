package com.laohu.model.behavior.strategy.classic;

/**
 * @program: designmodel
 * @description: 案例运行
 * @author: Holland
 * @create: 2021-09-05 16:58
 **/
public class OrderService {
    public double discount(Double oriPrice, String orderType) {
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(orderType);
        return discountStrategy.calDiscount(oriPrice);
    }
}
