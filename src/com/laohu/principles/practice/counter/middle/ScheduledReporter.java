package com.laohu.principles.practice.counter.middle;

import java.util.List;
import java.util.Map;

/**
 * @program: designmodel
 * @description: console和email显示类的相同逻辑抽取出的父类
 * @author: Holland
 * @create: 2021-08-11 11:15
 **/
public abstract class ScheduledReporter {

    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StaViewer staViewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StaViewer staViewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.staViewer = staViewer;
    }

    protected ScheduledReporter() {
    }

    /**
     * @Description: console和email显示类的相同统计逻辑,抽取成该父类方法
     * @auther: Holland
     * @date: 2021/8/11 11:19 上午
     */
    public void doStaAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

        //统计
        Map<String, RequestSta> requestStaMap = aggregator.aggregateOpti(requestInfos, durationInMillis);

        //显示输出
        staViewer.output(requestStaMap, startTimeInMillis, endTimeInMillis);
    }
}
