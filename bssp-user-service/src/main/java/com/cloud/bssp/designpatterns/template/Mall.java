package com.cloud.bssp.designpatterns.template;

/**
 * 商城顶层抽象
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
abstract class Mall {

    /**
     * 登录
     */
    public abstract void login();

    /**
     * 登出
     */
    public abstract void logout();

    /**
     * 查询商品
     */
    public abstract void query();

    /**
     * 下单
     */
    public abstract void order();
}
