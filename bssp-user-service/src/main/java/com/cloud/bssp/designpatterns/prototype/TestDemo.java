package com.cloud.bssp.designpatterns.prototype;


import com.cloud.bssp.BsspUserApplication;
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
    public void test() throws CloneNotSupportedException {
        Car car = new Car(2, new Engine(3.0, 0));
        Car car1 = car.clone();
        System.out.println("------------打印car------------");
        car.detail();
        System.out.println("------------打印car1------------");
        car1.detail();
        System.out.println("------------修改car的seats打印car------------");
        car.setSeats(4);
        car.detail();
        System.out.println("------------修改car的seats打印car1------------");
        car1.detail();
        System.out.println("------------修改car的Engine打印car------------");
        car.getEngine().setMileage(10000);
        car.detail();
        System.out.println("------------修改car的Engine打印car1------------");
        car1.detail();
    }

}
