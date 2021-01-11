package com.cloud.bssp.designpatterns.flyweight.usedesign;

/**
 * 树
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
public class Tree {

    private TreeBaseField baseField;

    private double high;

    public TreeBaseField getBaseField() {
        return baseField;
    }

    public void setBaseField(TreeBaseField baseField) {
        this.baseField = baseField;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public Tree(TreeBaseField baseField, double high) {
        this.baseField = baseField;
        this.high = high;
    }
}
