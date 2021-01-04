package com.cloud.bssp.designpatterns.builder.usedesign.builder;

import com.cloud.bssp.designpatterns.builder.usedesign.entity.*;
import lombok.Data;

/**
 * TODO
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
@Data
public class ManualBuilder implements Builder {

    private CarType carType;

    private int seats;

    private Engine engine;

    private GPS GPS;

    public Manual getResult() {
        return new Manual(carType, seats, engine, GPS);
    }
}
