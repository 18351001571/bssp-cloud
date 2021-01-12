package com.cloud.bssp.designpatterns.proxy;

/**
 * 送礼物接口
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public interface ISendGifts {

    /**
     * 送花
     */
    void sendFlower();

    /**
     * 送巧克力
     */
    void sendChocolate();

    /**
     * 送娃娃
     */
    void sendDolls();
}
