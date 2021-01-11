package com.cloud.bssp.designpatterns.flyweight.withoutdesign;

import java.util.Map;

/**
 * 树
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
public class Tree {

    private String name;

    private String color;

    private Map<String,Object> other;

    public Map<String, Object> getOther() {
        return other;
    }

    public void setOther(Map<String, Object> other) {
        this.other = other;
    }

    public Tree(String name, String color, Map<String, Object> other, double high) {
        this.name = name;
        this.color = color;
        this.other = other;
        this.high = high;
    }

    private double high;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }
}
