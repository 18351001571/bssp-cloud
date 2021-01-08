package com.cloud.bssp.designpatterns.adapter;

/**
 * 圆孔
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class RoundHold {

    /**
     * 直径
     */
    private double diameter;

    public RoundHold(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     * 校验是否合适
     * @param roundNails
     * @return
     */
    public boolean fits(RoundNails roundNails){
        if (diameter >= roundNails.getDiameter()){
            return true;
        }else {
            return false;
        }

    }
}
