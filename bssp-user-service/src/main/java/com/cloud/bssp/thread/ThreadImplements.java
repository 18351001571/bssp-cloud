package com.cloud.bssp.thread;

import java.util.concurrent.*;

/**
 * Description: 线程三种实现
 * Create Date: 2020/8/11
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class ThreadImplements {

    /**
     * 继承Thread类方式
     */
    static class ExtendThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承Thread类方式");
        }
    }


//    public static void main(String[] args) {
//        //实例化一个对象
//        ExtendThread extendThread = new ExtendThread();
//        //start()执行
//        extendThread.start();
//    }

    /**
     * 实现Runnable接口方式
     */
    static class ImplRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("实现Runnable接口方式");
        }
    }

//    public static void main(String[] args) {
//        new Thread(new ImplRunnable()).start();
//    }

    /**
     * 实现callable接口方式
     */
    static class ImplCallable implements Callable {

        private String str;

        public ImplCallable(String str) {
            this.str = str;
        }

        @Override
        public Object call() throws Exception {
            System.out.println("实现callable接口方式");
            return str;
        }
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //创建目标对象
//        ImplCallable mc = new ImplCallable("实现callable接口方式");
//        //创建执行服务
//        ExecutorService ser = Executors.newFixedThreadPool(2);
//        //提交执行
//        Future<String> result = ser.submit(mc);
//        //获取结果
//        String msg = result.get();
//        //关闭服务
//        ser.shutdownNow();
//        System.out.println("线程执行结果：" + msg);
//    }

    /**
     * lambda表达式简化实现
     */
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("lambda表达式简化实现");
        }).start();
    }
}
