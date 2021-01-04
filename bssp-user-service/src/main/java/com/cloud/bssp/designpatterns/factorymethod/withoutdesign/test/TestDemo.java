package com.cloud.bssp.designpatterns.factorymethod.withoutdesign.test;

import com.cloud.bssp.designpatterns.factorymethod.withoutdesign.Car;
import com.cloud.bssp.designpatterns.factorymethod.withoutdesign.IShop;
import com.cloud.bssp.designpatterns.factorymethod.withoutdesign.Plane;
import com.cloud.bssp.designpatterns.factorymethod.withoutdesign.Ship;
import com.cloud.bssp.BsspUserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * test
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BsspUserApplication.class)
public class TestDemo {

    @Autowired
    private IShop shop;

    @Test
    public void testWithout() {

        Car car = shop.getCar();
        car.run();

        Ship ship = shop.getShip();
        ship.run();

        Plane plane = shop.getPlane();
        plane.run();

    }

}
