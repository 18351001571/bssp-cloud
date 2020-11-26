package com.cloud.bssp.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Description: CyclicBarrier线程栅栏
 * Create Date: 2020/8/19
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class CyclicBarrierExample {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(6);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "到达");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "准备开始");
        cyclicBarrier.await();

    }
}

