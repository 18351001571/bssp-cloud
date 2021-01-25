package com.cloud.bssp.designpatterns.mediator;

/**
 * 商品
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class Goods implements IShop {

    public void getGoods() {
        System.out.println("查询商品信息");
    }
}
