package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 新增请求超时次数告警处理器
 * @author: Holland
 * @create: 2021-07-27 14:36
 **/
public class TimeoutAlertHandler extends AlertHandler {

    public TimeoutAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        //...省略代码...
    }
}
