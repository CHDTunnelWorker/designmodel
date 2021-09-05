package com.laohu.model.behavior.observer.eventbus;

import com.laohu.model.create.factory.simple.XmlRuleConfigParser;
import com.sun.crypto.provider.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: designmodel
 * @description: observer注册表逻辑类, 是实现eventbus框架最重要的类
 * @author: Holland
 * @create: 2021-09-05 14:44
 **/
public class ObserverRegistry {

    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    /**
     * @Description: 将观察者中的观察函数注册到事件参数为key, 观察者集合为value的注册表中
     * @param: Object observer
     * @auther: Holland
     * @date: 2021/9/5 15:00
     */
    public void register(Object observer) {
        //获取当前观察者类全部的被Subscribe注解修饰的方法
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        //遍历事件参数,将对应的事件参数的函数集合放在一个集合中
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if (registeredEventActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();

        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> eventActions = entry.getValue();
            //当传输的参数是事件参数的子类时,则加入到匹配的观察者方法集合
            if (postedEventType.isAssignableFrom(eventType)) {
                matchedObservers.addAll(eventActions);
            }
        }

        return matchedObservers;
    }

    /**
     * @Description:
     * @param: Object observer 观察者对象
     * @return: Map<Class < ?>, Collection<ObserverAction>>
     * @auther: Holland
     * @date: 2021/9/5 15:04
     */
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();

        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }

        return observerActions;
    }

    /**
     * @Description: 获取观察者类被被Subscribe注解标记的观察者函数集合
     * @param: Class<?> clazz 观察者类对象
     * @return: List<Method> 被Subscribe注解标记的观察者函数集合
     * @auther: Holland
     * @date: 2021/9/5 15:06
     */
    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    annotatedMethods.add(method);
                }
            }
        }
        return annotatedMethods;
    }
}
