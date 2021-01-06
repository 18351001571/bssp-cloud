package com.cloud.bssp.designpatterns.singleton.lazy.safe;

/**
 * 懒汉模式
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public class Singleton {

    public static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public Singleton() {
    }
}
