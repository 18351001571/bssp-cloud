package com.cloud.bssp.designpatterns.bridge.usedesign.method;

import com.cloud.bssp.designpatterns.bridge.usedesign.IPayMethod;
import com.cloud.bssp.designpatterns.bridge.usedesign.IPayWay;
import com.cloud.bssp.designpatterns.bridge.withoutdesign.PayMethodEnum;

/**
 * 扫脸
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class FacePay implements IPayMethod {

    @Override
    public void pay() {
        System.out.println("当前支付方式是：" + PayMethodEnum.FACE.name());
    }
}
