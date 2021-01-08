package com.cloud.bssp.designpatterns.adapter;

/**
 * 圆钉
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class RoundNails {

    /**
     * 直径
     */
    private double diameter;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public RoundNails(double diameter) {
        this.diameter = diameter;
    }
}
