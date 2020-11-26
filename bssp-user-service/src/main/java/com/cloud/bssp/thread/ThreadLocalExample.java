package com.cloud.bssp.thread;

/**
 * Description: 局部变量实现
 * Create Date: 2020/8/17
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class ThreadLocalExample {

    /**
     * 库存
     */
    static class Inventory {

        private ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 100);

        //增加库存
        public synchronized void add(int n, String threadName) {
            //增加库存
            num.set(num.get() + n);
            System.out.println("线程:" + threadName + ",增加库存后的数量=" + num.get());
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                inventory.add(1, Thread.currentThread().getName());
            }).start();
        }
    }
}
