package com.cloud.bssp.thread;

/**
 * Description: Volatile同步
 * Create Date: 2020/8/12
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class Volatile {

    /**
     * 同步代码块
     */
    static class Inventory {

        //库存数量
        private volatile int num = 100;

        //增加库存
        public void add(int n) {
            num += n;
            System.out.println("增加库存后的数量=" + num);
        }

        //减少库存
        public void sub(int n) {
            num -= n;
            System.out.println("减少库存后的数量=" + num);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                inventory.add(1);
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                inventory.sub(1);
            }).start();
        }
    }

}
