package com.cloud.bssp.designpatterns.singleton.lazy.dcl;

/**
 * 懒汉模式-DCL
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public class Singleton {

    /**
     * volatile 解决指令重排序导致的问题
     */
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private Singleton() {
    }
}
