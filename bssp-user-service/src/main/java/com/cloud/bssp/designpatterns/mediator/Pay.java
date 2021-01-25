package com.cloud.bssp.designpatterns.mediator;

/**
 * 支付
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class Pay implements IShop {

    public void pay() {
        System.out.println("支付成功");
    }
}
