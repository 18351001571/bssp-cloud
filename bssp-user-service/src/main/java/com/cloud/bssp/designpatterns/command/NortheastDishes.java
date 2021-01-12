package com.cloud.bssp.designpatterns.command;

/**
 * 东北菜
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class NortheastDishes implements IDishes {
    private ICooker cooker;

    public NortheastDishes(ICooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void order() {
        System.out.println("顾客下单东北菜");
        cooker.doCooking();
    }

    @Override
    public void back() {
        System.out.println("顾客取消东北菜订单了");
        cooker.stopCooking();
    }
}
