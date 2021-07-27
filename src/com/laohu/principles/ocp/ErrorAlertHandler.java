package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 错误次数告警处理器
 * @author: Holland
 * @create: 2021-07-27 12:07
 **/
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    /**
     * @Description: 实现抽象方法, 提供对请求错误次数的告警检查
     * @param: ApiStatInfo apiStatInfo
     * @auther: Holland
     * @date: 2021/7/27 11:40 上午
     */
    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi())) {
            notification.notifyStaff(NotificationEmergencyLevel.SEVERE.getCode(), "...");
        }
    }
}
