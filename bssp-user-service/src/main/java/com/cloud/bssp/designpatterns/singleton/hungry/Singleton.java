package com.cloud.bssp.designpatterns.singleton.hungry;

/**
 * TODO
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
public class Singleton {

    private final static Singleton singleton = new Singleton();

    public Singleton getSingleton(){
        return singleton;
    }
}
