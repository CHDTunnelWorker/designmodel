package com.laohu.model.structure.proxy.dynamic;

import com.laohu.principles.practice.counter.middle.MetricsController;
import com.laohu.principles.practice.counter.middle.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: designmodel
 * @description: 统计计数器代理类, 用于创建各个业务控制类的动态代理对象
 * 1.动态代理:不通过手动编写代码方式编写静态代理类,而是通过在运行时,动态地创建原始类对应的代理类,然后在系统应用中,替换掉原始类
 * @author: Holland
 * @create: 2021-08-16 10:59
 **/
public class MetricsCollectorProxy {

    private MetricsController metricsController;

    public MetricsCollectorProxy(MetricsController metricsController) {
        this.metricsController = metricsController;
    }

    /**
     * @Description: 创建业务类的附加统计功能的代理对象
     * @param: Object proxiedObject 可以是任何业务类
     * @return: Object 经过添加附加功能后的业务代理类,除了实现业务功能,还能实现附加功能
     * @auther: Holland
     * @date: 2021/8/16 11:19 上午
     */
    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    /**
     * 动态代理附加功能实现类,继承InvocationHandler方法,实现invoke方法,添加附加功能
     */
    public class DynamicProxyHandler implements InvocationHandler {

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimestamp = System.currentTimeMillis();
            long responseTime = endTimestamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricsController.recordRequestInfo(requestInfo);
            return result;
        }
    }

    //MetricsCollectorProxy使用举例
    //MetricsCollectorProxy proxy = new MetricsCollectorProxy();
    //IUserController userController = (IUserController) proxy.createProxy(new UserController());
}
