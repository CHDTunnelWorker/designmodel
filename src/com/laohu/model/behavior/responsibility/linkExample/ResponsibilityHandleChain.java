package com.laohu.model.behavior.responsibility.linkExample;

/**
 * @program: designmodel
 * @description: 责任链类（链表实现）
 * @author: Holland
 * @create: 2021-12-05 20:30
 **/
public class ResponsibilityHandleChain {

    /**
     * 处理器首节点
     */
    private ResponsibilityHandler head = null;
    /**
     * 尾结点
     */
    private ResponsibilityHandler tail = null;

    /**
     * 添加处理器节点
     *
     * @param handler
     */
    public void addHandler(ResponsibilityHandler handler) {

        handler.setSuccessor(null);

        //如果为空链
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }

        //非空链
        tail.setSuccessor(handler);
        tail = handler;
    }

    /**
     * 开始处理请求
     */
    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
