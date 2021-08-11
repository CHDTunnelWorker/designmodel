package com.laohu.principles.practice.counter.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: designmodel
 * @description: 执行入口
 * @author: Holland
 * @create: 2021-07-31 20:40
 **/

public class Demo {
    public static void main(String[] args) {
        //定时触发统计,并将结果显示到终端
        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatedReport(60, 60);

        //定时触发统计并将结果输出到邮件
        List<String> emailToAddresses = new ArrayList<>();
        emailToAddresses.add("laohu@qq.com");
        EmailReporter emailReporter = new EmailReporter(emailToAddresses);
        emailReporter.startDailyReport();

        //收集接口访问数据
        MetricsController collector = new MetricsController();
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
