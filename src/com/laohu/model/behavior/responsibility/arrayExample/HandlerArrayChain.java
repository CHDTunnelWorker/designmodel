package com.laohu.model.behavior.responsibility.arrayExample;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: designmodel
 * @description: 数组责任链处理器(实现更简单)
 * @author: Holland
 * @create: 2021-12-05 20:44
 **/
public class HandlerArrayChain {

    private List<IResponsibilityHandler> handlers = new ArrayList<>();

    public void addHandler(IResponsibilityHandler handler) {
        if (handler != null) {
            handlers.add(handler);
        }
    }

    public void handle() {
        for (IResponsibilityHandler handler : handlers) {
            boolean handle = handler.handle();
            if (handle) {
                break;
            }
        }
    }
}
