package com.cloud.bssp.designpatterns.flyweight.usedesign;

import java.util.Map;

/**
 * 树基本属性
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
public class TreeBaseField {

    private String name;

    private String color;

    private Map<String,Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public TreeBaseField(String name, String color, Map<String, Object> map) {
        this.name = name;
        this.color = color;
        this.map = map;
    }

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
}
