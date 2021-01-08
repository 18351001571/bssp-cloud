package com.cloud.bssp.designpatterns.bridge.withoutdesign;

import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.builder.usedesign.builder.CarBuilder;
import com.cloud.bssp.designpatterns.builder.usedesign.builder.ManualBuilder;
import com.cloud.bssp.designpatterns.builder.usedesign.director.Director;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.Car;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.Manual;
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
        Pay pay = new Pay();
        //支付宝扫脸支付
        pay.pay(PayMethodEnum.FACE.getCode(),PayWaysEnum.ZHIFUBAO.getCode());
        System.out.println("--------------------------------------");
        //微信扫脸支付
        pay.pay(PayMethodEnum.FACE.getCode(),PayWaysEnum.WEIXIN.getCode());
        System.out.println("--------------------------------------");
        //支付宝指纹支付
        pay.pay(PayMethodEnum.FINGER.getCode(),PayWaysEnum.ZHIFUBAO.getCode());
        System.out.println("--------------------------------------");
        //微信指纹支付
        pay.pay(PayMethodEnum.FINGER.getCode(),PayWaysEnum.WEIXIN.getCode());
        System.out.println("--------------------------------------");
    }

}
