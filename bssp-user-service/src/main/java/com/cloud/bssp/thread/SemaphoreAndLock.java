package com.cloud.bssp.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: SemaphoreAndLock
 * Create Date: 2020/8/24
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class SemaphoreAndLock {

//    public static void main(String[] args) {
//
//        Lock lock = new ReentrantLock();
//
//        //Semaphore semaphore = new Semaphore(1);
//
//        new Thread(()->{
//            lock.unlock();
//        }).start();
//    }

//    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(1);
//        System.out.println("当前通行证数量:" + semaphore.availablePermits());
//        new Thread(()->{
//            semaphore.release();
//        }).start();
//        Thread.sleep(1000);
//        System.out.println("当前通行证数量:" + semaphore.availablePermits());
//    }

    /**
     * 死锁恢复
     */
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        new Thread(() -> {
            try {
                semaphore1.acquire();
                System.out.println("线程" + Thread.currentThread().getName() + "获取semaphore1");
                Thread.sleep(5000);
                semaphore2.acquire();
                System.out.println("线程" + Thread.currentThread().getName() + "获取semaphore2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                semaphore2.acquire();
                System.out.println("线程" + Thread.currentThread().getName() + "获取semaphore2");
                Thread.sleep(5000);
                semaphore1.acquire();
                System.out.println("线程" + Thread.currentThread().getName() + "获取semaphore1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(10000);
        //主线程等待十秒，判断两个线程是否执行完毕，是否释放锁
        if (semaphore1.availablePermits() != 1) {
            System.out.println("发生死锁了，释放semaphore1");
            semaphore1.release();
        }
        if (semaphore2.availablePermits() != 1) {
            System.out.println("发生死锁了，释放semaphore2");
            semaphore2.release();
        }
    }
}
