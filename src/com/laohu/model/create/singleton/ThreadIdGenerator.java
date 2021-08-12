package com.laohu.model.create.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designmodel
 * @description: 线程唯一的单例实现
 * @author: Holland
 * @create: 2021-08-12 15:36
 **/
public class ThreadIdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long, ThreadIdGenerator> instanceMap = new ConcurrentHashMap<>();

    private ThreadIdGenerator() {
    }

    /**
     * @Description: 通过ConcurrentHashMap,key为线程id,value为ThreadIdGenerator对象,就实现了不同线程不同对象,同一个线程同一个对象
     * @return: ThreadIdGenerator
     * @auther: Holland
     * @date: 2021/8/12 3:40 下午
     */
    public static ThreadIdGenerator getInstance() {
        long threadId = Thread.currentThread().getId();
        instanceMap.putIfAbsent(threadId, new ThreadIdGenerator());
        return instanceMap.get(threadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
