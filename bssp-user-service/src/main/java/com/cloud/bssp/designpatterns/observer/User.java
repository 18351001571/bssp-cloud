package com.cloud.bssp.designpatterns.observer;

/**
 * 订阅者
 * @date: 2021/1/22
 * @author weirx
 * @version 3.0
 */
public class User implements ISubscriber{

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void look() {
        System.out.println("检测姓名：" + name);
    }
}
