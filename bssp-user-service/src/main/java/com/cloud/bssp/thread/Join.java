package com.cloud.bssp.thread;

/**
 * Description: 验证Thread的join方法
 * Create Date: 2020/8/11
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class Join extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Join join = new Join();
        join.setName("我是join线程");
        join.start();
        //调用join方法
        join.join();

        System.out.println("我是main线程");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "i=" + i);
        }
    }
}
