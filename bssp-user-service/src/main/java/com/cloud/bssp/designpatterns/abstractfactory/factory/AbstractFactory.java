package com.cloud.bssp.designpatterns.abstractfactory.factory;

import com.cloud.bssp.designpatterns.abstractfactory.entity.Car;
import com.cloud.bssp.designpatterns.abstractfactory.entity.Ship;

/**
 * TODO
 * @date: 2020/12/30
 * @author weirx
 * @version 3.0
 */
public interface AbstractFactory {

    Car getCar();

    Ship getShip();
}
