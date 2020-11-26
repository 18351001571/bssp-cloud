package com.cloud.bssp.thread;

import com.alibaba.fastjson.JSON;

/**
 * Description: String为什么被final修饰
 * Create Date: 2020/9/28
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class StringTest {
    /**
     * String数组的值是可以改变了
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "abcd";
        StringBuffer str1 = new StringBuffer("abcd");
        StringBuilder str2 = new StringBuilder("abcd");
        String str3 = str + "ef";

        int hashcode1 = str.hashCode();
        int hashcode2 = str1.hashCode();
        int hashcode3 = str2.hashCode();

        System.out.println(hashcode1 == hashcode2);
        System.out.println(hashcode1 == hashcode3);
        System.out.println(hashcode2 == hashcode3);
    }
}
