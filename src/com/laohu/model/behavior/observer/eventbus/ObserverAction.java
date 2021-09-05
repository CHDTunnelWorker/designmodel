package com.laohu.model.behavior.observer.eventbus;

import com.sun.crypto.provider.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: designmodel
 * @description: 用于反射调用被Subscribe标注的观察者类的函数
 * @author: Holland
 * @create: 2021-09-05 14:34
 **/
public class ObserverAction {
    /**
     * 观察者对象
     */
    private Object target;
    /**
     * 观察者对象的方法类
     */
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    /**
     * @Description: 反射调用执行观察者方法
     * @param: Object event 事件参数对象
     * @auther: Holland
     * @date: 2021/9/5 14:49
     */
    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
