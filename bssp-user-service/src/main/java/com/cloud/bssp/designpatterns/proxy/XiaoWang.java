package com.cloud.bssp.designpatterns.proxy;

/**
 * 小王
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class XiaoWang implements ISendGifts{

    private XiaoXue xiaoXue;

    public XiaoWang(XiaoXue xiaoXue) {
        this.xiaoXue = xiaoXue;
    }

    @Override
    public void sendFlower() {
        System.out.println(xiaoXue.getName() + "，我是小王，送你一朵小红花");
    }

    @Override
    public void sendChocolate() {
        System.out.println(xiaoXue.getName() + "，我是小王，送你一块巧克力");
    }

    @Override
    public void sendDolls() {
        System.out.println(xiaoXue.getName() + "，我是小王，送你一个洋娃娃");
    }
}
