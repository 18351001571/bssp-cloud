package com.cloud.bssp.designpatterns.chainofresponsibility;

/**
 * 大小检查
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class SizeQualityCheck extends CarQualityCheck{

    public SizeQualityCheck(CarQualityCheck next) {
        super(next);
    }

    @Override
    public boolean checkSelf(Car car) {
        if ("大".equals(car.getSize())){
            System.out.println("车辆大小校验通过");
            return checkNest(car);
        }
        System.out.println("车辆大小校验未通过");
        return false;
    }
}
