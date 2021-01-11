package com.cloud.bssp.designpatterns.flyweight.usedesign;

import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;

/**
 * 享元工厂
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
public class FlyweightBeanFactory {

    public static HashMap<String, TreeBaseField> map = new HashMap<>();

    public static TreeBaseField getBaseField(String name, String color) {
        TreeBaseField treeBaseField = map.get(name);
        if (ObjectUtils.isEmpty(treeBaseField)) {
            map.put(name, new TreeBaseField(name, color,new HashMap<>()));
        }
        return map.get(name);
    }
}
