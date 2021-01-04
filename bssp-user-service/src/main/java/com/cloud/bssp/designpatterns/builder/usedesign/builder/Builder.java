package com.cloud.bssp.designpatterns.builder.usedesign.builder;

import com.cloud.bssp.designpatterns.builder.usedesign.entity.CarType;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.Engine;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.GPS;

/**
 * TODO
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public interface Builder {

    void setCarType(CarType carType);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setGPS(GPS gps);
}
