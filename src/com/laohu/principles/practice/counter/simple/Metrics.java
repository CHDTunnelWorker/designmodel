package com.laohu.principles.practice.counter.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: designmodel
 * @description: 统计 (简单原型)
 * @author: Holland
 * @create: 2021-07-31 16:16
 **/
public class Metrics {
    /**
     * key为apiname,value为对应请求接口的响应时间戳
     */
    private Map<String, List<Double>> responseTimes = new HashMap<>();
    /**
     * key为apiname,value为对应请求接口的时间戳
     */
    private Map<String, List<Double>> timestamps = new HashMap<>();
    /**
     * 定时线程池
     */
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     * @Description: 记录接口的响应时间戳
     * @param: String apiName 接口名称
     * @param: double responseTime 响应时间戳
     * @auther: Holland
     * @date: 2021/7/31 16:43
     */
    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    /**
     * @Description: 记录接口的请求时间戳
     * @param: String apiName 接口名称
     * @param: double timestamp 请求时间戳
     * @auther: Holland
     * @date: 2021/7/31 16:43
     */
    public void recordTimestamp(String apiName, double timestamp) {
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    /**
     * @Description: 定时统计数据, 并在控制台输出
     * @param: long period 时长
     * @param: TimeUnit unit 时间单位
     * @auther: Holland
     * @date: 2021/7/31 16:42
     */
    public void startRepeatedReport(long period, TimeUnit unit) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Map<String, Map<String, Double>> stats = new HashMap<>();
                for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                    String apiName = entry.getKey();
                    List apiRespTimes = entry.getValue();
                    stats.putIfAbsent(apiName, new HashMap<>());
                    stats.get(apiName).put("max", max(apiRespTimes));
                    stats.get(apiName).put("avg", avg(apiRespTimes));
                }
                for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                    String apiName = entry.getKey();
                    List apiTimestamps = entry.getValue();
                    stats.putIfAbsent(apiName, new HashMap<>());
                    stats.get(apiName).put("count", (double) apiTimestamps.size());
                }
                System.out.println(gson.toJson(stats));
            }
        }, 0, period, unit);
    }

    private double max(List dataset) {
        //省略代码实现
        return 1d;
    }

    private double avg(List dataset) {
        //省略代码实现
        return 1d;
    }
}
