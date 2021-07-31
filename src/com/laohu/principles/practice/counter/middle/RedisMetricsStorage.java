package com.laohu.principles.practice.counter.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: designmodel
 * @description: redis存储介质
 * @author: Holland
 * @create: 2021-07-31 17:13
 **/
public class RedisMetricsStorage implements MetricsStorage {

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        //...省略实现
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        //...省略实现
        return new ArrayList<>();
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        //...省略实现
        return new HashMap<>();
    }
}
