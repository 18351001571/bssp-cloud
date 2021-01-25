package com.cloud.bssp.designpatterns.mediator;

/**
 * 测试类
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        //创建一个商城中介者
        ShopMediator shopMediator  = new ShopMediator();
        //注册商城内的元素
        shopMediator.register(new Goods());
        shopMediator.register(new ShoppingCar());
        shopMediator.register(new Order());
        shopMediator.register(new Pay());
        shopMediator.register(new Inventory());
        //调用方法
        shopMediator.getGoods();
        shopMediator.getInventory();
        shopMediator.addShoppingCar();
        shopMediator.order();
        shopMediator.pay();
    }
}
