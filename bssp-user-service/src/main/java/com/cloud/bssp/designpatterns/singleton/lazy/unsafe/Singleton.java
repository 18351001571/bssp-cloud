package com.cloud.bssp.designpatterns.singleton.lazy.unsafe;

/**
 * 懒汉模式-线程不安全
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private Singleton() {
    }
}
