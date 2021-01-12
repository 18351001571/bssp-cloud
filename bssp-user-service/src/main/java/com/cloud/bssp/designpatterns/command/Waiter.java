package com.cloud.bssp.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务员
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class Waiter {

    /**
     * 菜单
     */
    private List<IDishes> list = new ArrayList<>();

    /**
     * 顾客下单
     * @param dishes
     */
    public void order(IDishes dishes) {
        list.add(dishes);
    }

    /**
     * 顾客退单
     * @param dishes
     */
    public void back(IDishes dishes) {
        for (IDishes d : list) {
            if (d.getClass().getName().equals(d.getClass().getName())) {
                list.remove(dishes);
            }
        }
    }

    /**
     * 通知厨师下单
     */
    public void doCooking() {
        for (IDishes d : list) {
            d.order();
        }
    }

    /**
     * 通知厨师退单
     * @param dishes
     */
    public void stopCooking(IDishes dishes) {
        dishes.back();
    }

    /**
     * 查看菜单
     */
    public void searchDishesList(){
        System.out.println("当前菜单：");
        for (IDishes d : list) {
            System.out.println(d.getClass().getName());
        }
    }
}
