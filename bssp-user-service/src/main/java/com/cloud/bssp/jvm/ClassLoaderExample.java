package com.cloud.bssp.jvm;

/**
 * Description: TODO
 * Create Date: 2020/10/16
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class ClassLoaderExample {

    public static void main(String[] args) {

        System.out.println(T.count);
    }

    static class T {
        static int count = 2;
        static T t = new T();

        private T() {
            count++;
        }
    }
}
