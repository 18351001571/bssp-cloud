package com.cloud.bssp.designpatterns.bridge.usedesign;

import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.bridge.usedesign.method.FacePay;
import com.cloud.bssp.designpatterns.bridge.usedesign.method.FingerPay;
import com.cloud.bssp.designpatterns.bridge.usedesign.way.WXPayWay;
import com.cloud.bssp.designpatterns.bridge.usedesign.way.ZFBPayWay;
import com.cloud.bssp.designpatterns.bridge.withoutdesign.PayMethodEnum;
import com.cloud.bssp.designpatterns.bridge.withoutdesign.PayWaysEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 客户端
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BsspUserApplication.class)
public class TestDemo {

    @Test
    public void test() {
        FacePay facePay = new FacePay();
        FingerPay fingerPay = new FingerPay();
        ZFBPayWay zfbPayFace = new ZFBPayWay(facePay);
        WXPayWay wxPayWayFace = new WXPayWay(facePay);
        ZFBPayWay zfbPayFinger = new ZFBPayWay(fingerPay);
        WXPayWay wxPayWayFinger = new WXPayWay(fingerPay);
        //支付宝扫脸支付
        zfbPayFace.pay();
        System.out.println("--------------------------------------");
        //微信扫脸支付
        wxPayWayFace.pay();
        System.out.println("--------------------------------------");
        //支付宝指纹支付
        zfbPayFinger.pay();
        System.out.println("--------------------------------------");
        //微信指纹支付
        wxPayWayFinger.pay();
        System.out.println("--------------------------------------");
    }

}
