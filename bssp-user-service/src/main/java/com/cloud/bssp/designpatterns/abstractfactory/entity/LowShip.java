package com.cloud.bssp.designpatterns.abstractfactory.entity;

/**
 * TODO
 * @date: 2020/12/30
 * @author weirx
 * @version 3.0
 */
public class LowShip implements Ship {
    @Override
    public void run() {
        System.out.println("this low ship is running");
    }
}
