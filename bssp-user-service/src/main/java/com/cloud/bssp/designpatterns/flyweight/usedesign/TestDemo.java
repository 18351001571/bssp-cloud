package com.cloud.bssp.designpatterns.flyweight.usedesign;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        List<Tree> list = new ArrayList<>();
        System.out.println("开始种树");
        for (int i = 0; i < 100000; i++) {
            list.add(new Tree(FlyweightBeanFactory.getBaseField("杨树", "绿色"),
                    Math.random() * (10 - 5) + 5));
        }
        System.out.println("种树完成");
    }
}
