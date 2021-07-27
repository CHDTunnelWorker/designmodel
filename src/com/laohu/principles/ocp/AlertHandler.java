package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 告警处理器--抽象类,设计告警处理器抽象类,通过多态可以扩展多个类型告警处理器
 * @author: Holland
 * @create: 2021-07-27 10:59
 **/
public abstract class AlertHandler {
    /**
     * 告警规则类
     */
    protected AlertRule rule;
    /**
     * 通知类
     */
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    /**
     * @Description: 告警处理器的检查方法, 抽象处理, 可扩展更多的检查规则
     * @param: ApiStatInfo apiStatInfo
     * @auther: Holland
     * @date: 2021/7/27 11:29 上午
     */
    public abstract void check(ApiStatInfo apiStatInfo);
}
