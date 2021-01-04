package com.cloud.bssp.designpatterns.factorymethod.usedesign;

import lombok.Data;

/**
 * Ship
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
@Data
public class Ship implements Product{

    private String name;

    private String price;

    @Override
    public void run() {
        System.out.println("the Ship is running");
    }
}
