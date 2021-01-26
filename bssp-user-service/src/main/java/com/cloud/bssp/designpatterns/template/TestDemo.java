package com.cloud.bssp.designpatterns.template;

/**
 * 测试类
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        System.out.println("--------------------");
        Mall jd = new Jingdong();
        jd.login();
        jd.query();
        jd.order();
        jd.logout();
        System.out.println("--------------------");
        Mall tb = new Taobao();
        tb.login();
        tb.query();
        tb.order();
        tb.logout();
        System.out.println("--------------------");
        Mall pdd = new Pinduoduo();
        pdd.login();
        pdd.query();
        pdd.order();
        pdd.logout();
    }
}
