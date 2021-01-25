package com.cloud.bssp.designpatterns.mediator;

/**
 * 中介者
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public interface Mediator {

    /**
     * 下单
     */
    void order();

    /**
     * 查询商品
     */
    void getGoods();

    /**
     * 查询库存
     */
    void getInventory();

    /**
     * 支付
     */
    void pay();

    /**
     * 添加购物车
     */
    void addShoppingCar();
}
