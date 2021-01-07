package com.cloud.bssp.designpatterns.singleton.hungry;

/**
 * 饿汉模式
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public class Singleton {

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    private Singleton() {
    }
}
