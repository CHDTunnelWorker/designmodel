package com.laohu.model.behavior.observer.classic;

/**
 * @program: designmodel
 * @description: 观察者模式经典实现demo
 * @author: Holland
 * @create: 2021-08-22 18:23
 **/
public class Demo {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(new ConcreteObserverOne());
        concreteSubject.registerObserver(new ConcreteObserverTwo());
        concreteSubject.notifyObservers(new Message());
    }

}
