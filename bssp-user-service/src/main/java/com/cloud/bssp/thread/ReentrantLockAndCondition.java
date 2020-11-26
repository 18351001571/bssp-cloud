package com.cloud.bssp.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: ReentrantLock和Condition的使用
 * Create Date: 2020/8/21
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class ReentrantLockAndCondition {

    /**
     * 库存
     */
    static class Inventory {

        //初始化ReentrantLock实例
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        //库存数量
        private int num = 100;

        //增加库存
        public void add(int n) throws InterruptedException {
            //加锁
            lock.lock();
            try {
                //先等待sub的通知
                condition.await();
                num += n;
                System.out.println("增加库存后的数量=" + num);
            } finally {
                //释放锁
                lock.unlock();
            }
        }

        //减少库存
        public void sub(int n) throws InterruptedException {
            //加锁
            lock.lock();
            try {
                num -= n;
                System.out.println("减少库存后的数量=" + num);
                //睡1s，为了看add方法接收通知的效果
                Thread.sleep(1000);
                condition.signal();
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        new Thread(() -> {
            try {
                inventory.add(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //睡1s，先走增加的线程，再走减少
        Thread.sleep(1000);

        new Thread(() -> {
            try {
                inventory.sub(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
