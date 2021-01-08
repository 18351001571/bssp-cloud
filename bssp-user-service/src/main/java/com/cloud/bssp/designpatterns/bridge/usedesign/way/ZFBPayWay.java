package com.cloud.bssp.designpatterns.bridge.usedesign.way;

import com.cloud.bssp.designpatterns.bridge.usedesign.IPayMethod;
import com.cloud.bssp.designpatterns.bridge.usedesign.IPayWay;
import com.cloud.bssp.designpatterns.bridge.usedesign.enums.PayWaysEnum;


/**
 * 支付宝
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class ZFBPayWay implements IPayWay {

    private IPayMethod payMethod;

    public ZFBPayWay(IPayMethod payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public void pay() {
        System.out.println("当前支付方式是：" + PayWaysEnum.ZHIFUBAO.getName());
        payMethod.pay();
    }
}
