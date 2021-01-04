package com.cloud.bssp.designpatterns.prototype;

import lombok.Data;

/**
 * TODO
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
@Data
public class Car implements Cloneable{

    private int seats;

    private Engine engine;

    public Car(int seats, Engine engine) {
        this.seats = seats;
        this.engine = engine;
    }

    public void detail() {
        System.out.println("the seats is :" + seats);
        System.out.println("the engine is :" + engine);
    }

    @Override
    public Car clone() throws CloneNotSupportedException{
        Car car = (Car) super.clone();
        car.engine = engine.clone();
        return car;
    }
}
