package com.cloud.bssp.designpatterns.factorymethod.withoutdesign.impl;

import com.cloud.bssp.designpatterns.factorymethod.withoutdesign.Car;
import com.cloud.bssp.designpatterns.factorymethod.withoutdesign.IShop;
import com.cloud.bssp.designpatterns.factorymethod.withoutdesign.Plane;
import com.cloud.bssp.designpatterns.factorymethod.withoutdesign.Ship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ShopImpl
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
@Slf4j
@Service
public class ShopImpl implements IShop {
    @Override
    public Car getCar() {
        log.info("this is car");
        return new Car();
    }

    @Override
    public Ship getShip() {
        log.info("this is Ship");
        return new Ship();
    }

    @Override
    public Plane getPlane() {
        log.info("this is Plane");
        return new Plane();
    }
}
