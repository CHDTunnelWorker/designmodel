package com.laohu.model.create.singleton.implement;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designmodel
 * @description: 双重检测单例
 * @author: Holland
 * @create: 2021-08-12 12:26
 **/
public class DoubleIdGenerator {

    private AtomicLong id = new AtomicLong(0);

    /**
     * volatile 防止指令重排序 (new对象三步走,开辟空间,赋值,返回地址,重排序可能使返回地址在赋值之前发生)
     */
    private static volatile DoubleIdGenerator instance;

    private DoubleIdGenerator(){}

    /**
     * @Description: 支持延迟加载,也支持并发
     * @return: DoubleIdGenerator
     * @auther: Holland
     * @date: 2021/8/12 2:25 下午
     */
    public static DoubleIdGenerator getInstance() {

        if(instance == null){
            //使用类锁,同一时刻保证只有一个线程进入
            synchronized (DoubleIdGenerator.class) {
                //对instance再进行校验,防止重复创建实例
                if(instance == null){
                    instance = new DoubleIdGenerator();
                }
            }
        }

        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
