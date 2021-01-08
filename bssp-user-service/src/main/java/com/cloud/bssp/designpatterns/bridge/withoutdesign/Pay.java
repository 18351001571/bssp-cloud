package com.cloud.bssp.designpatterns.bridge.withoutdesign;

/**
 * TODO
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class Pay {

    public void pay(int payMethod, int payWay) {
        if (PayMethodEnum.FACE.getCode() == payMethod) {
            System.out.println("当前支付方式是：" + PayMethodEnum.FACE.getName(payMethod));
        } else {
            System.out.println("当前支付方式是：" + PayMethodEnum.FINGER.getName(payMethod));
        }
        if (PayWaysEnum.ZHIFUBAO.getCode() == payWay) {
            System.out.println("当前支付途径是：" + PayWaysEnum.ZHIFUBAO.getName(payWay));
        } else {
            System.out.println("当前支付途径是：" + PayWaysEnum.WEIXIN.getName(payWay));
        }
    }
}
