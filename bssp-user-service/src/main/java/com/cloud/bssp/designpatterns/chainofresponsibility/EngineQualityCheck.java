package com.cloud.bssp.designpatterns.chainofresponsibility;

/**
 * 引擎检查
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public class EngineQualityCheck extends CarQualityCheck{

    public EngineQualityCheck(CarQualityCheck next) {
        super(next);
    }

    @Override
    public boolean checkSelf(Car car) {
        if ("1.4".equals(car.getEngine())){
            System.out.println("车辆引擎校验通过");
            return checkNest(car);
        }
        System.out.println("车辆引擎校验未通过");
        return false;
    }
}
