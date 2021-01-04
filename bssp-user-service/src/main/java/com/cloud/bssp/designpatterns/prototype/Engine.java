package com.cloud.bssp.designpatterns.prototype;

import lombok.Data;

/**
 * 汽车引擎
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
@Data
public class Engine implements Cloneable{

    /**
     * 排量
     */
    private final double volume;
    /**
     * 里程
     */
    private double mileage;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    @Override
    public Engine clone() throws CloneNotSupportedException {
        Engine clone = (Engine) super.clone();
        return clone;
    }
}
