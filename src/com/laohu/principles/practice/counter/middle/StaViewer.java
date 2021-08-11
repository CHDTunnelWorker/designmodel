package com.laohu.principles.practice.counter.middle;

import java.util.Map;

/**
 * @program: designmodel
 * @description: 结果显示接口
 * @author: Holland
 * @create: 2021-08-11 10:43
 **/
public interface StaViewer {
    /**
     * @Description: 定义显示接口,供实现类扩展
     * @param: Map<String, RequestSta> requestStaMap 结果map
     * @param: long startTimeInMillis 起始时间戳(ms)
     * @param: long endTimeInMills 截止时间戳(ms)
     * @auther: Holland
     * @date: 2021/8/11 10:45 上午
     */
    void output(Map<String, RequestSta> requestStaMap, long startTimeInMillis, long endTimeInMills);
}
