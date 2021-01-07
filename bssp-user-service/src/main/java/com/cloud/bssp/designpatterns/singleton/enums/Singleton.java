package com.cloud.bssp.designpatterns.singleton.enums;

/**
 * 枚举
 * @date: 2021/1/5
 * @author weirx
 * @version 3.0
 */
public enum Singleton {

    INSTANCE;

    public void doSomeThing(){
        System.out.println("this is singleton by enum");
    }
}
