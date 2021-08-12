package com.laohu.model.create.singleton.implement;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: designmodel
 * @description: 枚举单例, 通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性,这个是最简单实现单例的
 * @author: Holland
 * @create: 2021-08-12 14:40
 **/
public enum EnumIdGenerator {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

    /**
     * 枚举单例保证线程安全性和实例的唯一性的原理
     *
     * 枚举在反编译后,每个枚举实例都是一个static类,由此可知,jvm在加载(同一个类加载器)时,能保证实例创建的线程安全且只执行一次
     * 每一个枚举类型极其定义的枚举变量在JVM中都是唯一的，因此在枚举类型的序列化和反序列化上，Java做了特殊的规定
     *
     * 注意! 对于 Java 语言来说，单例类对象的唯一性的作用范围并非进程，而是类加载器（Class Loader)
     * 不同类加载器加载同一个类,产生的单例对象是不同的
     */
}
