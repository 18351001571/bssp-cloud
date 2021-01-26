package com.cloud.bssp.designpatterns.template;

/**
 * 淘宝
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public class Jingdong extends Mall{

    @Override
    public void login() {
        System.out.println("登录京东商城");
    }

    @Override
    public void logout() {
        System.out.println("退出京东商城");
    }

    @Override
    public void query() {
        System.out.println("查询京东商城商品");
    }

    @Override
    public void order() {
        System.out.println("京东商城下单");
    }
}
