package com.laohu.principles.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: designmodel
 * @description: 告警类
 * @author: Holland
 * @create: 2021-07-27 10:56
 **/
public class Alert {
    /**
     * 告警处理器集合
     */
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    /**
     * @Description: 增加告警处理器至集合属性中
     * @param: AlertHandler alertHandler
     * @auther: Holland
     * @date: 2021/7/27 11:26 上午
     */
    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    /**
     * @Description: 对api请求信息进行告警判断
     * @param: ApiStatInfo apiStatInfo
     * @auther: Holland
     * @date: 2021/7/27 11:27 上午
     */
    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }
}
