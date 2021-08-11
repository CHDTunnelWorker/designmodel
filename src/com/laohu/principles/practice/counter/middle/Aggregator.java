package com.laohu.principles.practice.counter.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: designmodel
 * @description: 统计类, 该类目前统计功能较多, 未来统计增加时, 可能出现该类职责不单一, 且难以维护等问题
 * @author: Holland
 * @create: 2021-07-31 17:19
 **/
public class Aggregator {

    /**
     * @Description: 统计接口响应相关数据
     * 该函数缺点:
     * 1.大而全,扩展性差,越往后扩展统计功能,越难维护
     * @param: List<RequestInfo> requestInfos 原始数据集合
     * @param: long durationInMillis 统计间隔
     * @return: RequestSta 统计结果对象
     * @auther: Holland
     * @date: 2021/7/31 17:23
     */
    public static RequestSta aggregate(List<RequestInfo> requestInfos, long durationInMillis) {

        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }

        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }

        long tps = (long) (count / durationInMillis * 1000);
        Collections.sort(requestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                double diff = o1.getResponseTime() - o2.getResponseTime();
                if (diff < 0.0) {
                    return -1;
                } else if (diff > 0.0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }

        RequestSta requestStat = new RequestSta();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        return requestStat;
    }

    /**
     * @Description: 统计接口响应相关数据代码优化函数
     * @param: Map<String, List < RequestInfo>> requestInfos 接口名称为key,统计数据集合为value
     * @param: long durationInMillis 统计时间区间(ms)
     * @return: Map<String, RequestSta> 接口名称为key,统计结果为value
     * @auther: Holland
     * @date: 2021/8/11 10:25 上午
     */
    public Map<String, RequestSta> aggregateOpti(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestSta> requestStaMap = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            //新增统计函数
            RequestSta requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStaMap.put(apiName, requestStat);
        }
        return requestStaMap;
    }

    /**
     * @Description: 统计原始数据逻辑
     * @param: List<RequestInfo> requestInfos 统计原始数据集合
     * @param: long durationInMillis 统计时间区间(ms)
     * @return: RequestSta 统计结果对象
     * @auther: Holland
     * @date: 2021/8/11 10:26 上午
     */
    private RequestSta doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        //每次请求时长的集合
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }

        RequestSta requestSta = new RequestSta();
        requestSta.setMaxResponseTime(max(respTimes));
        requestSta.setMinResponseTime(min(respTimes));
        requestSta.setAvgResponseTime(avg(respTimes));
        requestSta.setP999ResponseTime(percentile999(respTimes));
        requestSta.setP99ResponseTime(percentile99(respTimes));
        requestSta.setCount(respTimes.size());
        requestSta.setTps(tps(respTimes.size(), durationInMillis / 1000));
        return requestSta;
    }

    private long tps(int count, double durationInMillis) {
        long tps = (long) (count / durationInMillis * 1000);
        return tps;
    }

    private double percentile99(List<Double> dataList) {
        List<Double> sortList = dataList.stream().sorted().collect(Collectors.toList());
        int size = sortList.size();
        int index = (int) (size * 0.99);
        return sortList.get(index);
    }

    private double percentile999(List<Double> dataList) {
        List<Double> sortList = dataList.stream().sorted().collect(Collectors.toList());
        int size = sortList.size();
        int index = (int) (size * 0.999);
        return sortList.get(index);
    }

    private double avg(List<Double> dataList) {
        return dataList.stream().mapToDouble(data -> data).average().getAsDouble();
    }

    private double min(List<Double> dataList) {
        List<Double> sortList = dataList.stream().sorted().collect(Collectors.toList());
        return sortList.get(0);
    }

    private double max(List<Double> dataList) {
        int size = dataList.size();
        List<Double> sortList = dataList.stream().sorted().collect(Collectors.toList());
        return sortList.get(size - 1);
    }

}
