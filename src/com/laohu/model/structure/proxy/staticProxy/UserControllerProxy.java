package com.laohu.model.structure.proxy.staticProxy;

import com.laohu.principles.practice.counter.middle.MetricsController;
import com.laohu.principles.practice.counter.middle.RequestInfo;
import com.laohu.principles.practice.counter.simple.UserController;
import com.laohu.principles.practice.counter.simple.UserVo;

/**
 * @program: designmodel
 * @description: usercontroller的静态业务附加代理类
 * 1.缺点很明显:每个业务类都需要手动创建一个对应的代理类,并对每个接口都要实现重复的代码
 * @author: Holland
 * @create: 2021-08-16 11:22
 **/
public class UserControllerProxy extends UserController {

    private MetricsController metricsController;

    public UserControllerProxy(MetricsController metricsController) {
        this.metricsController = metricsController;
    }

    public void register(UserVo userVo) {
        //埋点统计
        long startTimestamp = System.currentTimeMillis();

        //仅执行业务逻辑
        super.register(userVo);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;

        //统计
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsController.recordRequestInfo(requestInfo);
    }

    public UserVo login(String telphone, String password) {
        //埋点统计
        long startTimestamp = System.currentTimeMillis();

        //仅执行业务逻辑
        UserVo userVo = super.login(telphone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;

        //统计
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsController.recordRequestInfo(requestInfo);

        return userVo;
    }
}
