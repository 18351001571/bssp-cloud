package com.cloud.bssp.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * 调优小程序
 *
 * @date: 2020/12/16
 * @author weirx
 * @version 3.0
 */
public class Tuning {
    public static void main(String[] args) {
        System.out.println("Tuning...!");
        List list = new LinkedList();
        for (; ; ) {
            byte[] bytes = new byte[1024 * 1024];
            list.add(bytes);
        }
    }
}
