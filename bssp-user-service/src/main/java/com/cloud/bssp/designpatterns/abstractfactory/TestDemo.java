package com.cloud.bssp.designpatterns.abstractfactory;

import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.abstractfactory.entity.Car;
import com.cloud.bssp.designpatterns.abstractfactory.entity.Ship;
import com.cloud.bssp.designpatterns.abstractfactory.factory.AbstractFactory;
import com.cloud.bssp.designpatterns.abstractfactory.factory.HighFactory;
import com.cloud.bssp.designpatterns.abstractfactory.factory.LowFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 * @date: 2020/12/30
 * @author weirx
 * @version 3.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BsspUserApplication.class)
public class TestDemo {

    @Test
    public void test() {
        //获取高配car
        AbstractFactory highFactory = new HighFactory();
        Car car = highFactory.getCar();
        car.run();
        //获取低配car
        LowFactory lowFactory = new LowFactory();
        Car lowCar = lowFactory.getCar();
        lowCar.run();
    }
}
