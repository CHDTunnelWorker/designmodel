package com.laohu.model.behavior.template.classic;

/**
 * @program: designmodel
 * @description: 抽象模板类
 * @author: Holland
 * @create: 2021-09-05 15:44
 **/
public abstract class AbstractClass {
    /**
     * 定义为final,避免子类继承重写该方法
     */
    final void template() {
        method1();
        method2();
    }

    protected abstract void method2();

    protected abstract void method1();
}
