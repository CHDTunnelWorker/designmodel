package com.laohu.principles.ocp;

/**
 * @author Holland
 * @title: NotificationEmergencyLevel
 * @projectName designmodel
 * @description: 告警级别枚举
 * @date 2021/7/2712:03 下午
 */
public enum NotificationEmergencyLevel {
    TRIVIAL("000001", "无关紧要"),
    NORMAL("000002", "普通"),
    URGENCY("000003", "紧急"),
    SEVERE("000004", "严重");

    private String code;

    private String name;

    NotificationEmergencyLevel(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
