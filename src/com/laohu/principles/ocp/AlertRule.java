package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 告警规则对象
 * @author: Holland
 * @create: 2021-07-27 11:01
 **/
public class AlertRule {

    /**
     * @Description: 根据api获取对应的tps告警规则
     * @param: String api
     * @return: LONG
     * @auther: Holland
     * @date: 2021/7/27 12:02 下午
     */
    public Long getMatchedRule(String api) {
        return 10L;
    }
}
