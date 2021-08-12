package com.laohu.model.create.singleton.implement;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designmodel
 * @description: 饿汉式单例
 * @author: Holland
 * @create: 2021-08-12 12:00
 **/
public class HungryIdGenerator {

    private AtomicLong id = new AtomicLong(0);
    /**
     * 类加载的时候,将静态变量INSTANCE加载,就已经创建好了实例
     */
    private static final HungryIdGenerator INSTANCE = new HungryIdGenerator();

    private HungryIdGenerator() {
    }

    public static HungryIdGenerator getInstance() {
        return INSTANCE;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
