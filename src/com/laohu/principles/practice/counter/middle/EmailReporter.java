package com.laohu.principles.practice.counter.middle;

import com.laohu.principles.practice.counter.simple.Gson;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: designmodel
 * @description: 数据邮件通知类(用于组合统计逻辑, 定时触发)
 * @author: Holland
 * @create: 2021-07-31 17:28
 **/
public class EmailReporter extends ScheduledReporter {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StaViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }

    /**
     * 为了使框架更易用,提供默认依赖的构造函数
     */
    public EmailReporter(List<String> emailToAddresses) {
        this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer(emailToAddresses));
    }

    public void startDailyReport() {
        //该函数为了方便写单元测试,规避掉因系统时间导致的不可测试性
        Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                //调用父类方法,执行逻辑
                doStaAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    /**
     * @Description: 获取下一日的初始时间(抽取出该函数, 方便进行单元测试)
     * @param: 指定date
     * @return: Date 获取下一日的初始时间
     * @auther: Holland
     * @date: 2021/8/11 11:23 上午
     */
    protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        //这里可以获取当前时间
        calendar.setTime(date);
        //重新设置时间
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
