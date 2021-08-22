package com.laohu.model.behavior.observer.classic;

/**
 * @Description: 主题类(经典观察者模式实现)
 * @auther: Holland
 * @date: 2021/8/22 18:13
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);
}
