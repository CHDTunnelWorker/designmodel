package com.laohu.principles.practice.counter.middle;

import com.laohu.principles.practice.counter.simple.Gson;
import sun.awt.geom.AreaOp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: designmodel
 * @description: 数据控制台输出类(用于组合统计逻辑, 定时触发)
 * 该类的查询数据库以及统计功能与emailreport类的同个逻辑相同,可以将这部分代码抽出复用;
 * 同时该类还负责了显示的展示,职责不单一,强耦合,后续待修改
 * @author: Holland
 * @create: 2021-07-31 17:27
 **/
public class ConsoleReporter extends ScheduledReporter {

    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StaViewer staViewer) {
        super(metricsStorage, aggregator, staViewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * 为了使框架更易用,提供默认依赖的构造函数
     */
    public ConsoleReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    }

    /**
     * @Description: 开始统计
     * @param: long periodInSeconds 定时间隔
     * @param: long durationInSeconds 统计时间区间
     * @auther: Holland
     * @date: 2021/7/31 17:32
     */
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                //从数据库拉取数据逻辑
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                //复用统计并展示的逻辑
                doStaAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
