package com.laohu.principles.practice.counter.middle;

/**
 * @program: designmodel
 * @description: 执行入口
 * @author: Holland
 * @create: 2021-07-31 20:40
 **/

public class Demo {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(60, 60);

        EmailReporter emailReporter = new EmailReporter(storage);
        emailReporter.addToAddress("laohu@qq.com");
        emailReporter.startDailyReport();

        MetricsController collector = new MetricsController(storage);
        collector.recordRequestInfo(new RequestInfo("register", 123, 10234));
        collector.recordRequestInfo(new RequestInfo("register", 223, 11234));
        collector.recordRequestInfo(new RequestInfo("register", 323, 12334));
        collector.recordRequestInfo(new RequestInfo("login", 23, 12434));
        collector.recordRequestInfo(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
