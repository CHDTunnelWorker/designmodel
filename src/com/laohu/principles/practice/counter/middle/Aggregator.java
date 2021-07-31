package com.laohu.principles.practice.counter.middle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: designmodel
 * @description: 统计类,该类目前统计功能较多,未来统计增加时,可能出现该类职责不单一,且难以维护等问题
 * @author: Holland
 * @create: 2021-07-31 17:19
 **/

public class Aggregator {

    /**
     * @Description: 统计接口响应相关数据
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

}
