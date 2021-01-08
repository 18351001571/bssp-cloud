package com.cloud.bssp.designpatterns.bridge.usedesign.method;

import com.cloud.bssp.designpatterns.bridge.usedesign.IPayMethod;
import com.cloud.bssp.designpatterns.bridge.withoutdesign.PayMethodEnum;

/**
 * 指纹
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class FingerPay implements IPayMethod {

    @Override
    public void pay() {
        System.out.println("当前支付方式是：" + PayMethodEnum.FINGER.name());
    }
}
