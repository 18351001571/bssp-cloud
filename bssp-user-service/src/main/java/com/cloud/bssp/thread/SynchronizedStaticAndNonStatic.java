package com.cloud.bssp.thread;

/**
 * Description: Synchronized的静态同步与非静态同步
 * Create Date: 2020/8/18
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class SynchronizedStaticAndNonStatic {

    public static int count = 0;

    public static synchronized void inc() throws InterruptedException {
        count++;
        //这里将静态方法阻塞，验证是否能访问到inc2()
        Thread.sleep(10000);
        System.out.println("结果1： " + count);
    }

    public synchronized void inc2() {
        count++;
        System.out.println("结果2： " + count);
    }

    public synchronized void inc3(String tName) throws InterruptedException {
        System.out.println("结果3： " + tName);
        Thread.sleep(10000);
    }

    public synchronized void inc4(String tName) {
        System.out.println("结果4： " + tName);
    }

    public synchronized void inc5(String tName) throws InterruptedException {
        System.out.println("结果5： " + tName);
        Thread.sleep(10000);
        System.out.println("结果5操作完成： " + tName);
    }

    public static synchronized void inc6() throws InterruptedException {
        count++;
        //这里将静态方法阻塞，验证是否能访问到inc2()
        Thread.sleep(10000);
        System.out.println("结果6： " + count);
    }

    /**
     * 验证类锁与对象锁是否互斥
     * @param args
     * @throws InterruptedException
     */
//    public static void main(String[] args) throws InterruptedException {
//        //调用静态同步方法
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                //同步静态方法
//                try {
//                    SynchronizedStaticAndNonStatic.inc();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        //调用非静态同步方法前先进行阻塞一秒，确保静态同步方法在执行阻塞过程中
//        Thread.sleep(1000);
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                //同步动态方法
//                SynchronizedStaticAndNonStatic t = new SynchronizedStaticAndNonStatic();
//                t.inc2();
//            }).start();
//        }
//    }
//    public static void main(String[] args) {
//        SynchronizedStaticAndNonStatic t = new SynchronizedStaticAndNonStatic();
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                try {
//                    t.inc3(Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                t.inc4(Thread.currentThread().getName());
//            }).start();
//        }
//    }
//    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                //同步动态方法
//                SynchronizedStaticAndNonStatic t = new SynchronizedStaticAndNonStatic();
//                try {
//                    t.inc5(Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    SynchronizedStaticAndNonStatic.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    SynchronizedStaticAndNonStatic.inc6();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
