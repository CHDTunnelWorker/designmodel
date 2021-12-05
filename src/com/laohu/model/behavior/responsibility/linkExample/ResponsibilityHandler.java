package com.laohu.model.behavior.responsibility.linkExample;

/**
 * @program: designmodel
 * @description: 责任链处理器抽象类
 * @author: Holland
 * @create: 2021-12-05 20:20
 **/
public abstract class ResponsibilityHandler {

    /**
     * 目的是关联下一个处理器
     */
    protected ResponsibilityHandler successor = null;

    public void setSuccessor(ResponsibilityHandler handle) {
        this.successor = handle;
    }

    public final void handle() {
        //将业务实现与框架逻辑分隔，doHandle专门实现业务逻辑
        boolean handleFlag = doHandle();
        //如果本处理器业务逻辑未命中，则交给下一个处理器处理
        if (!handleFlag && successor != null) {
            successor.handle();
        }
    }

    //抽象方法，用于实现类实现业务逻辑
    protected abstract boolean doHandle();
}
