package com.laohu.model.behavior.observer.classic;

/**
 * @program: designmodel
 * @description: 观察者实现2(经典观察者模式实现)
 * @author: Holland
 * @create: 2021-08-22 18:21
 **/
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        //获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo is notified.");
    }
}
