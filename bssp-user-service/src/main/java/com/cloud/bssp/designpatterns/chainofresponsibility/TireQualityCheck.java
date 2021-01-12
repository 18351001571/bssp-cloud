package com.cloud.bssp.designpatterns.chainofresponsibility;

/**
 * 轮胎检查
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class TireQualityCheck extends CarQualityCheck{

    public TireQualityCheck(CarQualityCheck next) {
        super(next);
    }

    public TireQualityCheck() {

    }

    @Override
    public boolean checkSelf(Car car) {
        if ("4".equals(car.getTire())){
            System.out.println("车辆轮胎校验通过");
            return checkNest(car);
        }
        System.out.println("车辆轮胎未校验通过");
        return false;
    }
}
