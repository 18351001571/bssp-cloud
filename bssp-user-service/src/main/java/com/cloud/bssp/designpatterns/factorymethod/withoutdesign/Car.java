package com.cloud.bssp.designpatterns.factorymethod.withoutdesign;

import lombok.Data;

/**
 * Car
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
@Data
public class Car {

    private String name;

    private String price;

    public void run() {
        System.out.println("the car is running");
    }
}
