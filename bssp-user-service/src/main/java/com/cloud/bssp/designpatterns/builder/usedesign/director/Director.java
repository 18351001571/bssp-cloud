package com.cloud.bssp.designpatterns.builder.usedesign.director;

import com.cloud.bssp.designpatterns.builder.usedesign.builder.Builder;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.CarType;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.Engine;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.GPS;

/**
 * TODO
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORT);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setGPS(new GPS("haerbin nangang haerbindajie"));
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.0, 0));
        builder.setGPS(new GPS("haerbin nangang haerbindajie"));
    }
}
