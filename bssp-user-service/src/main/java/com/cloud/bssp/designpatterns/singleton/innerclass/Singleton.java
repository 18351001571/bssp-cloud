package com.cloud.bssp.designpatterns.singleton.innerclass;

/**
 * 静态内部类
 * 内部静态类不会自动初始化，只有调用静态内部类的方法，静态域，或者构造方法的时候才会加载静态内部类
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public class Singleton {

    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private Singleton() {
    }
}
