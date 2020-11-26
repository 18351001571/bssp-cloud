package com.cloud.bssp.thread;

/**
 * Description: synchronized同步，同步方法，同步代码块
 * Create Date: 2020/8/12
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class Synchronized {

    /**
     * 同步方法
     */
//    static class Inventory {
//
//        //库存数量
//        private int num = 100;
//
//        //增加库存
//        public synchronized void add(int n) {
//            num += n;
//            System.out.println("增加库存后的数量=" + num);
//        }
//    }

    /**
     * 同步代码块
     */
    static class Inventory {

        //库存数量
        private int num = 100;

        //增加库存
        public void add(int n) {

            synchronized (this) {
                num += n;
                System.out.println("增加库存后的数量=" + num);
            }
        }
    }

    public static void main(String[] args) {
        //初始化库存
        Inventory inventory = new Inventory();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                inventory.add(1);
            }).start();
        }
    }
}
