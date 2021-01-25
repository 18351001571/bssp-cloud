package com.cloud.bssp.designpatterns.strategy;

/**
 * 测试类
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        IPayStrategy wx = PayStrategyEnum.newInstance(PayStrategyEnum.getEnum("weixin"));
        wx.pay();

        IPayStrategy zfb = PayStrategyEnum.newInstance(PayStrategyEnum.getEnum("zhifubao"));
        zfb.pay();
    }
}
