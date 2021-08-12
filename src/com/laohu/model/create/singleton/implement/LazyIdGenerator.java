package com.laohu.model.create.singleton.implement;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designmodel
 * @description: 饱汉式单例
 * @author: Holland
 * @create: 2021-08-12 12:08
 **/
public class LazyIdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static LazyIdGenerator instance;

    private LazyIdGenerator() {
    }

    /**
     * @Description: 支持延迟加载, 在调用getInstance()时, 才会创建单例对象;
     * 缺点很明显: 并发度很低,因为是静态函数,加了synchronized,相当于类锁;
     * @return: FullIdGenerator
     * @auther: Holland
     * @date: 2021/8/12 12:17 下午
     */
    public synchronized static LazyIdGenerator getInstance() {
        if (instance == null) {
            instance = new LazyIdGenerator();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
