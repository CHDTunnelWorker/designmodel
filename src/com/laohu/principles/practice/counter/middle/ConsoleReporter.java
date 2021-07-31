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
public class ConsoleReporter {

    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
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
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

                Map<String, RequestSta> stats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    //统计计算请求数据
                    RequestSta requestSta = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                    stats.put(apiName, requestSta);
                }

                //将统计数据显示到终端
                Gson gson = new Gson();
                System.out.println(gson.toJson(stats));
            }
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
