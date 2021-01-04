package com.cloud.bssp.designpatterns.abstractfactory.factory;

import com.cloud.bssp.designpatterns.abstractfactory.entity.*;

/**
 * TODO
 * @date: 2020/12/30
 * @author weirx
 * @version 3.0
 */
public class LowFactory implements AbstractFactory{
    @Override
    public Car getCar() {
        return new LowCar();
    }

    @Override
    public Ship getShip() {
        return new LowShip();
    }
}
