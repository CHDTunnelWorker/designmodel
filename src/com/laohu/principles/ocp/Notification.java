package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 通知类
 * @author: Holland
 * @create: 2021-07-27 11:14
 **/
public class Notification {

    /**
     * @Description: 告警
     * @param:
     * @return:
     * @auther: Holland
     * @date: 2021/7/27 12:05 下午
     */
    public void notifyStaff(String alertLevelCode, String msg) {
        System.out.println("alertLevelCode: " + alertLevelCode + ", " + "msg: " + msg);
    }
}
