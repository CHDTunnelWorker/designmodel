package com.laohu.model.structure.adaptor.objimpl;

import com.laohu.model.structure.adaptor.Adaptee;
import com.laohu.model.structure.adaptor.ITarget;

/**
 * @program: designmodel
 * @description: 适配器模式--类适配器实现
 * @author: Holland
 * @create: 2021-08-22 10:31
 **/
public class ObjectAdaptor implements ITarget {

    private Adaptee adaptee;

    public ObjectAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        //委托adaptee实现
        adaptee.fa();
    }

    @Override
    public void f2() {
        //...自己重写实现
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
