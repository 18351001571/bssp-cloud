package com.cloud.bssp.designpatterns.strategy;

/**
 * 微信
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class WXPay implements IPayStrategy{

    @Override
    public void pay() {
        System.out.println("使用微信支付");
    }
}
