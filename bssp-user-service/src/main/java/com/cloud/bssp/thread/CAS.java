package com.cloud.bssp.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Description: CAS
 * Create Date: 2020/8/19
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class CAS {

    private static int num = 0;

    public static boolean add(int source, int target) {
        int count = 0;
        while (true) {
            if (num == source) {
                num = target;
                return true;
            } else {
                count++;
                if (count == 10) {
                    return false;
                }
            }
        }
    }

//    public static void main(String[] args) {
//        new Thread(() -> {
//            //将数据更新为1
//            if (add(0, 1)) {
//                System.out.println(Thread.currentThread().getName() + "更新num为1成功");
//            } else {
//                System.out.println(Thread.currentThread().getName() + "更新num为1失败");
//            }
//            //将数据更新为0
//            if (add(1, 0)) {
//                System.out.println(Thread.currentThread().getName() + "更新num为0成功");
//            } else {
//                System.out.println(Thread.currentThread().getName() + "更新num为0失败");
//            }
//
//        }).start();
//
//        new Thread(() -> {
//            //将数据更新为10
//            if (add(0, 10)) {
//                System.out.println(Thread.currentThread().getName() + "更新num为10成功");
//            } else {
//                System.out.println(Thread.currentThread().getName() + "更新num为10失败");
//            }
//
//        }).start();
//    }


    public static void main(String[] args) {
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(0, 0);

        new Thread(() -> {
            atomicStampedReference.compareAndSet(0, 1, 0, 1);
            atomicStampedReference.compareAndSet(1, 0, 1, 2);
        }).start();

        new Thread(() -> {
            boolean b = atomicStampedReference.compareAndSet(0, 1, 0, 1);
            if (b) {
                System.out.println("更新为10成功");
            } else {
                System.out.println("更新为10失败");
            }
        }).start();
    }
}
