package com.cloud.bssp.designpatterns.proxy;

/**
 * 测试类
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        XiaoXue xiaoXue = new XiaoXue("小雪");
        XiaoMing xiaoMing = new XiaoMing(xiaoXue);
        xiaoMing.sendFlower();
        xiaoMing.sendChocolate();
        xiaoMing.sendDolls();
    }
}
