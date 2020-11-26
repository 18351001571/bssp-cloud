package com.cloud.bssp.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * Description: TODO
 * Create Date: 2020/8/17
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class Jol {

    public static class A {
    }

    static class B {
        private long s;
    }

    static class C {
        private int a;
        private long s;
    }

    int[] aa = new int[0];


    public static void main(String[] args) {
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        B b = new B();
        System.out.println(ClassLayout.parseInstance(b).toPrintable());
        C c = new C();
        System.out.println(ClassLayout.parseInstance(c).toPrintable());
        int[] aa = new int[0];
        System.out.println(ClassLayout.parseInstance(aa).toPrintable());
    }

}
