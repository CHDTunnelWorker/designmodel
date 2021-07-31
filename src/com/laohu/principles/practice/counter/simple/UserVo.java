package com.laohu.principles.practice.counter.simple;

/**
 * @program: designmodel
 * @description: 用户vo类
 * @author: Holland
 * @create: 2021-07-31 16:11
 **/
public class UserVo {
    /**
     * 用户名姓名
     */
    public String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 联系电话
     */
    private String telphone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
