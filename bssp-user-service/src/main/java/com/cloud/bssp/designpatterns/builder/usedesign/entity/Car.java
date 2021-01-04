package com.cloud.bssp.designpatterns.builder.usedesign.entity;

import lombok.Data;

/**
 * TODO
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
@Data
public class Car {

    private CarType type;

    private int seats;

    private Engine engine;

    private GPS GPS;

    public Car(CarType type, int seats, Engine engine, GPS GPS) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.GPS = GPS;
    }

    public void detail() {
        System.out.println("this is " + type + " car");
        System.out.println("the seats is :" + seats);
        System.out.println("the engine is :" + engine);
        System.out.println("this GPS is :" + GPS);
    }

}
