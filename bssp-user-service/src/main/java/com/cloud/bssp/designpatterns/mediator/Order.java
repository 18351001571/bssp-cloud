package com.cloud.bssp.designpatterns.mediator;

/**
 * 订单
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class Order implements IShop {

    public void order(){
        System.out.println("下单成功");
    }

}
