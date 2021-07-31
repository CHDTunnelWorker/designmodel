package com.laohu.principles.practice.counter.middle;

/**
 * @program: designmodel
 * @description: 原始数据请求类, 替换掉原来的多个参数传参
 * @author: Holland
 * @create: 2021-07-31 17:05
 **/
public class RequestInfo {
    /**
     * 接口名称
     */
    private String apiName;
    /**
     * 响应时间
     */
    private double responseTime;
    /**
     * 请求时间戳
     */
    private long timestamp;

    public RequestInfo() {

    }

    public RequestInfo(String apiName, double responseTime, long timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
