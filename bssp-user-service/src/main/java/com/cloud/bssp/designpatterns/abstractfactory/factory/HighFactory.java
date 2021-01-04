package com.cloud.bssp.designpatterns.abstractfactory.factory;

import com.cloud.bssp.designpatterns.abstractfactory.entity.Car;
import com.cloud.bssp.designpatterns.abstractfactory.entity.HighCar;
import com.cloud.bssp.designpatterns.abstractfactory.entity.HighShip;
import com.cloud.bssp.designpatterns.abstractfactory.entity.Ship;

/**
 * TODO
 * @date: 2020/12/30
 * @author weirx
 * @version 3.0
 */
public class HighFactory implements AbstractFactory{
    @Override
    public Car getCar() {
        return new HighCar();
    }

    @Override
    public Ship getShip() {
        return new HighShip();
    }
}
