package com.cloud.bssp.thread;

import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 * Description: ExchangerExample
 * Create Date: 2020/9/9
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class ExchangerExample {

    /**
     * 初始化string类型的Exchanger
     */
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            String flag1 = "111";
            System.out.println(Thread.currentThread().getName() + "交换前flag1=" + flag1);
            try {
                //交换数据，并进入阻塞
                flag1 = exchanger.exchange(flag1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "交换后flag1=" + flag1);
        }).start();

        Thread.sleep(1000);
        new Thread(() -> {
            String flag2 = "222";
            System.out.println(Thread.currentThread().getName() + "交换后flag2=" + flag2);
            try {
                //交换数据，唤醒上一个线程
                flag2 = exchanger.exchange(flag2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "交换前flag2=" + flag2);
        }).start();
    }


}
