package com.cloud.bssp.designpatterns.factorymethod.usedesign.test;

import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.factorymethod.usedesign.IShop;
import com.cloud.bssp.designpatterns.factorymethod.usedesign.Product;
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
    private IShop shipImpl;

    @Autowired
    private IShop carImpl;

    @Autowired
    private IShop planeImpl;

    @Test
    public void testUsed() {
        //以下使用注入的方式，注意在工厂IShop的每个实现指定bean的名称
        Product car = carImpl.getProduct();

        Product ship = shipImpl.getProduct();

        Product plane = planeImpl.getProduct();

        //以下使用new的方式
//        IShop planeImpl = new PlaneImpl();
//        Product plane = planeImpl.getProduct();
//
//
//        IShop carImpl = new CarImpl();
//        Product car = carImpl.getProduct();
//        car.run();
//
//        IShop shipImpl = new ShipImpl();
//        Product ship = shipImpl.getProduct();

        car.run();
        plane.run();
        ship.run();

    }

}
