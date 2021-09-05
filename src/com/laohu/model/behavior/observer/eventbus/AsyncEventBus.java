package com.laohu.model.behavior.observer.eventbus;

import java.util.concurrent.Executor;

/**
 * @program: designmodel
 * @description: 异步非阻塞事件总线类
 * @author: Holland
 * @create: 2021-09-05 14:28
 **/
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
