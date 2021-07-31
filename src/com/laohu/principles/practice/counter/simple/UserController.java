package com.laohu.principles.practice.counter.simple;

import java.util.concurrent.TimeUnit;

/**
 * @program: designmodel
 * @description: 性能计数器简易应用场景:用户登录注册接口统计(简单原型)
 * @author: Holland
 * @create: 2021-07-31 16:09
 **/
public class UserController {

    private Metrics metrics = new Metrics();

    public UserController() {
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);
    }

    public void register(UserVo userVo) {
        //埋点统计
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("register", startTimestamp);
        //...省略逻辑实现
        long respTime = System.currentTimeMillis();
        metrics.recordResponseTime("register", respTime);
    }

    public UserVo login(String telphone, String password) {
        //埋点统计
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        //...省略逻辑实现
        long respTime = System.currentTimeMillis();
        metrics.recordResponseTime("login", respTime);
        return new UserVo();
    }
}
