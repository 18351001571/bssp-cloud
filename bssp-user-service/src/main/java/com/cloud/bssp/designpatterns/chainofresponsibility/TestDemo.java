package com.cloud.bssp.designpatterns.chainofresponsibility;

/**
 * 测试类
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        Car car = new Car("red", "大", "1.4", "4");
        CarQualityCheck qualityCheck =
                new ColorQualityCheck(
                        new SizeQualityCheck(
                                new EngineQualityCheck(
                                        new TireQualityCheck()
                                )
                        )
                );
        boolean result = qualityCheck.checkSelf(car);
        if (result){
            System.out.println("车辆质检通过，可以出场");
        }else {
            System.out.println("车辆质检未通过，禁止出厂");
        }
    }
}
