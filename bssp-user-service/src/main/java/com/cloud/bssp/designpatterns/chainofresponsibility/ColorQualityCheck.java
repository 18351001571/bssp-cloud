package com.cloud.bssp.designpatterns.chainofresponsibility;

/**
 * 颜色检查
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class ColorQualityCheck extends CarQualityCheck{

    public ColorQualityCheck(CarQualityCheck next) {
        super(next);
    }

    @Override
    public boolean checkSelf(Car car) {
        if ("red".equals(car.getColor())){
            System.out.println("车辆颜色校验通过");
            return checkNest(car);
        }
        System.out.println("车辆颜色校验未通过");
        return false;
    }
}
