package com.cloud.bssp.designpatterns.abstractfactory.entity;

/**
 * TODO
 * @date: 2020/12/30
 * @author weirx
 * @version 3.0
 */
public class LowCar implements Car {
    @Override
    public void run() {
        System.out.println("this low car is running");
    }
}
