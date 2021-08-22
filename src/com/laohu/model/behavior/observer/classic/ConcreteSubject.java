package com.laohu.model.behavior.observer.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: designmodel
 * @description: 主题类实现(经典观察者模式实现)
 * @author: Holland
 * @create: 2021-08-22 18:19
 **/
public class ConcreteSubject implements Subject{

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
