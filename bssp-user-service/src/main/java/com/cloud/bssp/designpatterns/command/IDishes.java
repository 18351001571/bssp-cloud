package com.cloud.bssp.designpatterns.command;

/**
 * 菜品接口
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public interface IDishes {

    /**
     * 下单
     */
    void order();

    /**
     * 退单
     */
    void back();
}
