package com.cloud.bssp.designpatterns.builder.withouttdesign;

import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.builder.withouttdesign.entity.*;
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
        //生产运动汽车
        Car sportCar = new Car(
                CarType.SPORT,
                2,
                new Engine(3.0, 0),
                new GPS("haerbin nangang haerbindajie")
        );
        sportCar.detail();
        System.out.println("----------------------------------------");
        //生产城市汽车
        Car cityCar = new Car(
                CarType.CITY,
                4,
                new Engine(2.0, 0),
                new GPS("haerbin nangang haerbindajie")
        );
        cityCar.detail();
        System.out.println("----------------------------------------");
        //生产汽车手册
        Manual manual = new Manual(
                CarType.CITY,
                4,
                new Engine(2.0, 0),
                new GPS("haerbin nangang haerbindajie")
        );
        manual.detail();
        System.out.println("----------------------------------------");
    }

}
