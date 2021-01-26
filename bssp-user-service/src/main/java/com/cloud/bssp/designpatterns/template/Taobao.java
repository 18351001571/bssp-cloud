package com.cloud.bssp.designpatterns.template;

/**
 * 淘宝
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public class Taobao extends Mall{

    @Override
    public void login() {
        System.out.println("登录淘宝商城");
    }

    @Override
    public void logout() {
        System.out.println("退出淘宝商城");
    }

    @Override
    public void query() {
        System.out.println("查询淘宝商城商品");
    }

    @Override
    public void order() {
        System.out.println("淘宝商城下单");
    }
}
