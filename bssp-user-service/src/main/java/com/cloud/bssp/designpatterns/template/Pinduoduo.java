package com.cloud.bssp.designpatterns.template;

/**
 * 淘宝
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public class Pinduoduo extends Mall{

    @Override
    public void login() {
        System.out.println("登录拼多多商城");
    }

    @Override
    public void logout() {
        System.out.println("退出拼多多商城");
    }

    @Override
    public void query() {
        System.out.println("查询拼多多商城商品");
    }

    @Override
    public void order() {
        System.out.println("拼多多商城下单");
    }
}
