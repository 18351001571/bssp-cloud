package com.cloud.bssp.designpatterns.builder.usedesign;

import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.builder.usedesign.builder.CarBuilder;
import com.cloud.bssp.designpatterns.builder.usedesign.builder.ManualBuilder;
import com.cloud.bssp.designpatterns.builder.usedesign.director.Director;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.Car;
import com.cloud.bssp.designpatterns.builder.usedesign.entity.Manual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 客户端
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BsspUserApplication.class)
public class TestDemo {

    @Test
    public void test() {
        Director director = new Director();
        //生产运动汽车
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car sportCar = carBuilder.getResult();
        sportCar.detail();
        System.out.println("-----------------------------------");

        //生产城市汽车
        director.constructCityCar(carBuilder);
        Car cityCar = carBuilder.getResult();
        cityCar.detail();
        System.out.println("-----------------------------------");

        //生产汽车手册
        ManualBuilder manualBuilder = new ManualBuilder();
        director.constructCityCar(manualBuilder);
        Manual manual = manualBuilder.getResult();
        manual.detail();
        System.out.println("-----------------------------------");
    }

}
