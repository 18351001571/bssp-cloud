package com.cloud.bssp.thread;

import java.util.concurrent.Phaser;

/**
 * Description: PhaserExample
 * Create Date: 2020/9/8
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class PhaserExample {

    /**
     * 线程数，即学生数量
     */
    private static int PARTIES = 5;

    static Phaser p = new Phaser() {

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("第一题完成");
                    return false;
                case 1:
                    System.out.println("第二题完成");
                    return false;
                case 2:
                    System.out.println("第三题完成");
                    return false;
                default:
                    return true;
            }
        }
    };

    private static void firstQuestion() {
        System.out.println("线程：" + Thread.currentThread().getName() + "，第一题");
        p.arriveAndAwaitAdvance();
    }

    private static void secondQuestion() {
        System.out.println("线程：" + Thread.currentThread().getName() + "，第二题");
        p.arriveAndAwaitAdvance();
    }

    private static void thirdQuestion() {
        System.out.println("线程：" + Thread.currentThread().getName() + "，第三题");
        p.arriveAndAwaitAdvance();
    }

    public static void main(String[] args) {
        for (int i = 0; i < PARTIES; i++) {
            new Thread(() -> {
                //线程注册
                p.register();
                firstQuestion();
                secondQuestion();
                thirdQuestion();
            }).start();
        }
    }
}
