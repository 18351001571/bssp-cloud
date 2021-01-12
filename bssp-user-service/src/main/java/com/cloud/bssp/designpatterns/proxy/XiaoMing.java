package com.cloud.bssp.designpatterns.proxy;

/**
 * 小明
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class XiaoMing implements ISendGifts {

    private XiaoWang xiaoWang;

    public XiaoMing(XiaoXue xiaoxue) {
        this.xiaoWang = new XiaoWang(xiaoxue);
    }

    @Override
    public void sendFlower() {
        xiaoWang.sendFlower();
    }

    @Override
    public void sendChocolate() {
        xiaoWang.sendChocolate();
    }

    @Override
    public void sendDolls() {
        xiaoWang.sendDolls();
    }
}
