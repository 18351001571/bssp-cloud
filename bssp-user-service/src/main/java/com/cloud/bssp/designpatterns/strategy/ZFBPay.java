package com.cloud.bssp.designpatterns.strategy;

/**
 * 支付宝
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class ZFBPay implements IPayStrategy{

    @Override
    public void pay() {
        System.out.println("使用支付宝支付");
    }
}
