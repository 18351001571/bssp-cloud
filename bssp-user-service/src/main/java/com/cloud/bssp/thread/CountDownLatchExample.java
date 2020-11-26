package com.cloud.bssp.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: TODO
 * Create Date: 2020/8/21
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        // 使用倒计数门闩器 ，迫使主线程进入等待 ；设置门栓的值为10
        CountDownLatch latch = new CountDownLatch(10);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //门栓值减1
                latch.countDown();
                System.out.println("当前门栓值：" + latch.getCount());
            }
        }).start();
        //阻塞主线程，等门栓值为0，主线程执行
        latch.await();
        System.out.println("主线程执行。。。");
    }
}
