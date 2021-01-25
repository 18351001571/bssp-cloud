package com.cloud.bssp.designpatterns.mediator;

/**
 * 库存
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class Inventory implements IShop {

    public void getInventory() {
        System.out.println("查询库存信息成功");
    }
}
