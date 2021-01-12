package com.cloud.bssp.designpatterns.command;

/**
 * 测试类
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        SichuanDishes sichuanDishes = new SichuanDishes(new SichuanCooker());
        NortheastDishes northeastDishes = new NortheastDishes(new NortheastCooker());
        System.out.println("--------------顾客点单----------------");
        //顾客点单
        waiter.order(sichuanDishes);
        waiter.order(northeastDishes);
        waiter.searchDishesList();
        System.out.println("---------------小二下单---------------");
        //小二下单
        waiter.doCooking();
        System.out.println("---------------顾客退单四川菜---------------");
        //顾客退单四川菜
        waiter.back(sichuanDishes);
        waiter.stopCooking(sichuanDishes);
        waiter.searchDishesList();
        System.out.println("------------------------------");
    }
}
