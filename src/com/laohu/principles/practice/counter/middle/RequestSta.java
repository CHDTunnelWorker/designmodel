package com.laohu.principles.practice.counter.middle;

/**
 * @program: designmodel
 * @description: 统计请求的状态结果类
 * @author: Holland
 * @create: 2021-07-31 17:20
 **/
public class RequestSta {
    /**
     * 最大响应时长
     */
    private double maxResponseTime;
    /**
     * 最小响应时长
     */
    private double minResponseTime;
    /**
     * 平均响应时长
     */
    private double avgResponseTime;
    /**
     * 99.9分位时长
     */
    private double p999ResponseTime;
    /**
     * 99分位时长
     */
    private double p99ResponseTime;
    /**
     * 调用次数
     */
    private long count;
    /**
     * tps
     */
    private long tps;

    public double getMaxResponseTime() {
        return maxResponseTime;
    }

    public void setMaxResponseTime(double maxResponseTime) {
        this.maxResponseTime = maxResponseTime;
    }

    public double getMinResponseTime() {
        return minResponseTime;
    }

    public void setMinResponseTime(double minResponseTime) {
        this.minResponseTime = minResponseTime;
    }

    public double getAvgResponseTime() {
        return avgResponseTime;
    }

    public void setAvgResponseTime(double avgResponseTime) {
        this.avgResponseTime = avgResponseTime;
    }

    public double getP999ResponseTime() {
        return p999ResponseTime;
    }

    public void setP999ResponseTime(double p999ResponseTime) {
        this.p999ResponseTime = p999ResponseTime;
    }

    public double getP99ResponseTime() {
        return p99ResponseTime;
    }

    public void setP99ResponseTime(double p99ResponseTime) {
        this.p99ResponseTime = p99ResponseTime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getTps() {
        return tps;
    }

    public void setTps(long tps) {
        this.tps = tps;
    }
}
