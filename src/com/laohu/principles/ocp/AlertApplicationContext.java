package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 提供告警功能的对外暴露接口, 单例类, 负责alert创建, 组装(alertRule和Notification的依赖注入), 初始化(添加handler)工作
 * @author: Holland
 * @create: 2021-07-27 12:10
 **/
public class AlertApplicationContext {

    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initBeans() {
        //创建告警规则和通知对象
        alertRule = new AlertRule();
        notification = new Notification();

        //创建对应的处理器以及alert对象
        AlertHandler tpsHandler = new TpsAlertHandler(alertRule, notification);
        AlertHandler errorHandler = new ErrorAlertHandler(alertRule, notification);
        AlertHandler timeoutHandler = new TimeoutAlertHandler(alertRule, notification);
        alert = new Alert();
        alert.addAlertHandler(tpsHandler);
        alert.addAlertHandler(errorHandler);
        alert.addAlertHandler(timeoutHandler);
    }

    public Alert getAlert() {
        return alert;
    }

    //饿汉式单例
    private static final AlertApplicationContext INSTANCE = new AlertApplicationContext();

    private AlertApplicationContext() {
        initBeans();
    }

    public static AlertApplicationContext getInstance() {
        return INSTANCE;
    }
}

