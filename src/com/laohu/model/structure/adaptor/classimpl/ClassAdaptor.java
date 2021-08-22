package com.laohu.model.structure.adaptor.classimpl;

import com.laohu.model.structure.adaptor.Adaptee;
import com.laohu.model.structure.adaptor.ITarget;

/**
 * @program: designmodel
 * @description: 适配器模式--类适配器实现
 * @author: Holland
 * @create: 2021-08-22 10:25
 **/
public class ClassAdaptor extends Adaptee implements ITarget {

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        //...自己重新实现
    }

    //这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点
}
