package com.laohu.model.behavior.responsibility.linkExample;

/**
 * @program: designmodel
 * @description: 责任链处理器A
 * @author: Holland
 * @create: 2021-12-05 20:28
 **/
public class ResponsibilityHandlerA extends ResponsibilityHandler {

    @Override
    protected boolean doHandle() {
        boolean handled = false;

        //业务处理。。。

        return handled;
    }

}
