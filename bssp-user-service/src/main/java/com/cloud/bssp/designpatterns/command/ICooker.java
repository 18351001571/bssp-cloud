package com.cloud.bssp.designpatterns.command;

/**
 * 厨师接口
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public interface ICooker {

    /**
     * 烹饪
     */
    void doCooking();

    /**
     * 停止烹饪
     */
    void stopCooking();
}
