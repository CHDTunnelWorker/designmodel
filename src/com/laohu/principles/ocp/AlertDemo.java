package com.laohu.principles.ocp;

/**
 * @program: designmodel
 * @description: 告警demo
 * @author: Holland
 * @create: 2021-07-27 14:30
 **/
public class AlertDemo {

    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        //...省略设置apiStatInfo的属性
        AlertApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }

}
