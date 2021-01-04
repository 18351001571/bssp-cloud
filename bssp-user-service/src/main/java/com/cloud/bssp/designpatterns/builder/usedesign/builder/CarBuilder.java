package com.cloud.bssp.designpatterns.builder.usedesign.builder;

import com.cloud.bssp.designpatterns.builder.usedesign.entity.Car;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.CarType;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.Engine;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.GPS;
import lombok.Data;

/**
 * TODO
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
@Data
public class CarBuilder implements Builder {

    private CarType carType;

    private int seats;

    private Engine engine;

    private GPS GPS;

    public Car getResult() {
        return new Car(carType, seats, engine, GPS);
    }
}
