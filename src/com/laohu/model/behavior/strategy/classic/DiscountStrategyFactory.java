package com.laohu.model.behavior.strategy.classic;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: designmodel
 * @description: 打折策略工厂类
 * @author: Holland
 * @create: 2021-09-05 16:55
 **/
public class DiscountStrategyFactory {
    private static final Map<String, DiscountStrategy> strategies = new HashMap<>();

    static {
        strategies.put(OrderType.NORMAL.getCode(), new NormalDiscountStrategy());
        strategies.put(OrderType.GROUP.getCode(), new GrouponDiscountStrategy());
        strategies.put(OrderType.PROMOTION.getCode(), new PromotionDiscountStrategy());
    }

    public static DiscountStrategy getDiscountStrategy(String type) {
        return strategies.get(type);
    }
}
