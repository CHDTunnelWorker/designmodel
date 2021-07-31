package com.laohu.principles.practice.counter.middle;

import java.util.List;
import java.util.Map;

/**
 * @program: designmodel
 * @description: 统计数据存储接口, 可扩展存储介质
 * @author: Holland
 * @create: 2021-07-31 17:07
 **/
public interface MetricsStorage {
    /**
     * @Description: 存储原始数据接口
     * @param: RequestInfo requestInfo 原始统计数据类
     * @auther: Holland
     * @date: 2021/7/31 17:10
     */
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * @Description: 查询指定接口指定时间范围内的原始数据
     * @param: String apiName 接口名称
     * @param: long startTimeInMillis 统计起始时间戳
     * @param: long endTimeInMillis 统计结束时间戳
     * @return: List<RequestInfo> 指定接口的原始数据集合
     * @auther: Holland
     * @date: 2021/7/31 17:10
     */
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    /**
     * @Description: 查询指定时间范围内的所有接口原始数据
     * @param: long startTimeInMillis 统计起始时间戳
     * @param: long endTimeInMillis 统计结束时间戳
     * @return: List<RequestInfo> 所有接口的原始数据集合
     * @auther: Holland
     * @date: 2021/7/31 17:10
     */
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
