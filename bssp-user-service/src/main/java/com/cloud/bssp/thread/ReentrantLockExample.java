package com.cloud.bssp.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 重入锁实现同步
 * Create Date: 2020/8/17
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class ReentrantLockExample {

    /**
     * 库存
     */
    static class Inventory {

        //初始化ReentrantLock实例
        Lock lock = new ReentrantLock();

        //库存数量
        private int num = 100;

        //增加库存
        public void add(int n) {
            //加锁
            lock.lock();
            try {
                num += n;
                System.out.println("增加库存后的数量=" + num);
            } finally {
                //释放锁
                lock.unlock();
            }
        }

        //减少库存
        public void sub(int n) {
            //加锁
            lock.lock();
            try {
                num -= n;
                System.out.println("减少库存后的数量=" + num);
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                inventory.add(1);
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                inventory.sub(1);
            }).start();
        }
    }
}
