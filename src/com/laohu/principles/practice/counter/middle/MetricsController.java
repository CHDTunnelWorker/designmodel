package com.laohu.principles.practice.counter.middle;

/**
 * @program: designmodel
 * @description: 统计接口
 * @author: Holland
 * @create: 2021-07-31 17:07
 **/
public class MetricsController {
    /**
     * 基于接口实现,提供随时可替换的扩展性
     */
    private MetricsStorage metricsStorage;

    /**
     * 依赖注入
     */
    public MetricsController(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    /**
     * 为了使框架更易用,提供默认依赖的构造函数
     */
    public MetricsController(){
        this(new RedisMetricsStorage());
    }

    //保存原始数据,相对于最小原型,将两个函数合为一个
    public void recordRequestInfo(RequestInfo requestInfo) {
        if (requestInfo == null) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
