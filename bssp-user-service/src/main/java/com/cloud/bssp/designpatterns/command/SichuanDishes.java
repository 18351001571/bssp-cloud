package com.cloud.bssp.designpatterns.command;

/**
 * 四川菜
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class SichuanDishes implements IDishes{
    private ICooker cooker;

    public SichuanDishes(ICooker cooker) {
        this.cooker = cooker;
    }
    @Override
    public void order() {
        System.out.println("顾客下单四川菜");
        cooker.doCooking();
    }

    @Override
    public void back() {
        System.out.println("顾客取消四川菜订单了");
        cooker.stopCooking();
    }
}
