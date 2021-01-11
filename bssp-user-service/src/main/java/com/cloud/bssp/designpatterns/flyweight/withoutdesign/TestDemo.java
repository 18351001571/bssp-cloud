package com.cloud.bssp.designpatterns.flyweight.withoutdesign;

import java.util.*;

/**
 * 客户端
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String arg[]) {
        System.out.println("开始种树");
        List<Tree> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(new Tree("杨树", "绿色", new HashMap<>(),Math.random() * (10 - 5) + 5));
        }
        System.out.println("种植完成");
    }

}
