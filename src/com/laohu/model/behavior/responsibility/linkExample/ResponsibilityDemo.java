package com.laohu.model.behavior.responsibility.linkExample;

/**
 * @program: designmodel
 * @description: 责任链使用demo
 * @author: Holland
 * @create: 2021-12-05 20:40
 **/
public class ResponsibilityDemo {

    public static void main(String[] args) {
        ResponsibilityHandleChain chain = new ResponsibilityHandleChain();
        chain.addHandler(new ResponsibilityHandlerA());
        chain.addHandler(new ResponsibilityHandlerB());
        chain.handle();
    }

}
