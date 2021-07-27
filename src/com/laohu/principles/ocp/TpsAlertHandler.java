package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 每秒请求数告警处理器
 * @author: Holland
 * @create: 2021-07-27 11:37
 **/
public class TpsAlertHandler extends AlertHandler{

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    /**
     * @Description: 实现抽象方法,提供对TPS的告警检查
     * @param: ApiStatInfo apiStatInfo
     * @auther: Holland
     * @date: 2021/7/27 11:40 上午
     */
    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if(tps > rule.getMatchedRule(apiStatInfo.getApi())){
            notification.notifyStaff(NotificationEmergencyLevel.URGENCY.getCode(), "...");
        }
    }
}
