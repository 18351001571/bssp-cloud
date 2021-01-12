package com.cloud.bssp.designpatterns.command;

/**
 * 四川厨师
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class SichuanCooker implements ICooker{
    @Override
    public void doCooking() {
        System.out.println("四川厨师正在烹饪");
    }

    @Override
    public void stopCooking() {
        System.out.println("四川厨师停止烹饪了");
    }
}
