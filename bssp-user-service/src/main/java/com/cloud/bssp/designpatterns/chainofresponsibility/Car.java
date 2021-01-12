package com.cloud.bssp.designpatterns.chainofresponsibility;

/**
 * Car
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class Car {

    private String color;

    private String size;

    private String engine;

    private String tire;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public Car(String color, String size, String engine, String tire) {
        this.color = color;
        this.size = size;
        this.engine = engine;
        this.tire = tire;
    }
}
