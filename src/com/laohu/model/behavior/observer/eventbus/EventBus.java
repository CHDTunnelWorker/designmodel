package com.laohu.model.behavior.observer.eventbus;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @program: designmodel
 * @description: 事件总线类
 * @author: Holland
 * @create: 2021-09-05 14:27
 **/
public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    /**
     * MoreExecutors.directExecutor() 是 Google Guava 提供的工具类，看似是多线程，实际上是单线程
     * 主要还是为了跟 AsyncEventBus 统一代码逻辑，做到代码复用
     */
    public EventBus() {
        //this(MoreExecutors.directExecutor());
    }

    protected EventBus(java.util.concurrent.Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        registry.register(object);
    }

    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
