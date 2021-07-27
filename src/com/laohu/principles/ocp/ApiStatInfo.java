package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 发送告警信息所需的参数类
 * @author: Holland
 * @create: 2021-07-27 11:16
 **/
public class ApiStatInfo {
    /**
     * 访问的api接口
     */
    private String api;
    /**
     * 请求次数
     */
    private Long requestCount;
    /**
     * 请求报错次数
     */
    private Long errorCount;
    /**
     * 统计窗口时间(秒)
     */
    private Long durationOfSeconds;
    /**
     * 接口超时次数
     */
    private Long timeoutCount;

    public String getApi() {
        return api;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public Long getErrorCount() {
        return errorCount;
    }

    public Long getDurationOfSeconds() {
        return durationOfSeconds;
    }

    public Long getTimeoutCount() {
        return timeoutCount;
    }
}
