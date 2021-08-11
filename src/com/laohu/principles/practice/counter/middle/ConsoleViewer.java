package com.laohu.principles.practice.counter.middle;

import com.laohu.principles.practice.counter.simple.Gson;

import java.util.Map;

/**
 * @program: designmodel
 * @description: 控制台显示类
 * @author: Holland
 * @create: 2021-08-11 10:46
 **/
public class ConsoleViewer implements StaViewer {
    @Override
    public void output(Map<String, RequestSta> requestStaMap, long startTimeInMillis, long endTimeInMills) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStaMap));
    }
}
