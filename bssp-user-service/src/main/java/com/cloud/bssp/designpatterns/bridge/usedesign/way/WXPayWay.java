package com.cloud.bssp.designpatterns.bridge.usedesign.way;

import com.cloud.bssp.designpatterns.bridge.usedesign.IPayMethod;
import com.cloud.bssp.designpatterns.bridge.usedesign.IPayWay;
import com.cloud.bssp.designpatterns.bridge.usedesign.enums.PayWaysEnum;


/**
 * 微信
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class WXPayWay implements IPayWay {

    private IPayMethod payMethod;

    public WXPayWay(IPayMethod payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public void pay() {
        System.out.println("当前支付方式是：" + PayWaysEnum.WEIXIN.getName());
        payMethod.pay();
    }
}
