package com.cloud.bssp.designpatterns.chainofresponsibility;

import org.apache.commons.lang3.ObjectUtils;

/**
 * 车辆质检
 * @date: 2021/1/12
 * @author weirx
 * @version 3.0
 */
public abstract class CarQualityCheck {

    /**
     * 下一个
     */
    public CarQualityCheck next;

    public CarQualityCheck(CarQualityCheck next) {
        this.next = next;
    }
    public CarQualityCheck() {
    }
    /**
     * 校验自己
     * @param car
     * @return
     */
    public abstract boolean checkSelf(Car car);

    /**
     * 校验下一个
     * @param car
     * @return
     */
    public boolean checkNest(Car car){
        if (ObjectUtils.isNotEmpty(next)){
            return next.checkSelf(car);
        }
        System.out.println("当前没有下一个流程，检测完成");
        return true;
    }
}
