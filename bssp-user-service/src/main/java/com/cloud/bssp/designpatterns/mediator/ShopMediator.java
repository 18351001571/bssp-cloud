package com.cloud.bssp.designpatterns.mediator;

/**
 * 具体商品中介者
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class ShopMediator implements Mediator {

    private Order order;
    private Goods goods;
    private Inventory inventory;
    private Pay pay;
    private ShoppingCar shoppingCar;


    @Override
    public void order() {
        order.order();
    }

    @Override
    public void getGoods() {
        goods.getGoods();
    }

    @Override
    public void getInventory() {
        inventory.getInventory();
    }

    @Override
    public void pay() {
        pay.pay();
    }

    @Override
    public void addShoppingCar() {
        shoppingCar.addShoppingCar();
    }

    public void register(IShop shop){
        if (shop.getClass().getName() == Order.class.getName()){
            order = new Order();
        }
        if (shop.getClass().getName() == Pay.class.getName()){
            pay = new Pay();
        }
        if (shop.getClass().getName() == Goods.class.getName()){
            goods = new Goods();
        }
        if (shop.getClass().getName() == Inventory.class.getName()){
            inventory = new Inventory();
        }
        if (shop.getClass().getName() == ShoppingCar.class.getName()){
            shoppingCar = new ShoppingCar();
        }
    }
}
