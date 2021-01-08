package com.cloud.bssp.designpatterns.adapter;

/**
 * 圆钉
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class SquareNails {

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public SquareNails(double width) {
        this.width = width;
    }

    /**
     * 边长
     */
    private double width;

}
