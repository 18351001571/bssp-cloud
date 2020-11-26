package com.cloud.bssp.thread;

/**
 * Description: Synchronized锁重入
 * Create Date: 2020/8/19
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class SynchronizedReentrantLock {

    static class Inventory extends InventoryParent {

        //增加库存
        public synchronized void add(int n) {
            super.num += n;
            System.out.println("增加库存后的数量=" + super.num);
            super.sub(n);
        }
    }

    static class InventoryParent {

        //库存数量
        private int num = 100;

        //增加库存
        public synchronized void sub(int n) {
            num -= n;
            System.out.println("减少库存后的数量=" + num);
        }
    }

    public static void main(String[] args) {
        //初始化库存
        Inventory inventory = new Inventory();
        new Thread(() -> {
            inventory.add(1);
        }).start();
    }
}
