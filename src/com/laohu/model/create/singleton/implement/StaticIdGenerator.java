package com.laohu.model.create.singleton.implement;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designmodel
 * @description: 静态内部类单例, 做到了懒加载 和 提供并发
 * @author: Holland
 * @create: 2021-08-12 14:35
 **/
public class StaticIdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private StaticIdGenerator() {
    }

    public static class SingletonHolder {
        private static final StaticIdGenerator INSTANCE = new StaticIdGenerator();
    }

    /**
     * @Description: 外部类被加载时, 并不创建SingletonHolder实例对象, 只有当调用getInstance方法, SingletonHolder类才会被加载, 才会创建instance
     * instance的唯一性,线程安全性,都由JVM来保证
     * <p>
     * StaticIdGenerator类加载时,并不会加载SingletonHolder静态类;当显示调用SingletonHolder的时候,则会加载该静态类
     * JVM在加载类时,能保证全局只会执行一次代码
     * @return: StaticIdGenerator
     * @auther: Holland
     * @date: 2021/8/12 2:37 下午
     */
    public static StaticIdGenerator getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
