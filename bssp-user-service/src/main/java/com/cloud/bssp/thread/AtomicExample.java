package com.cloud.bssp.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 原子变量实现
 * Create Date: 2020/8/17
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class AtomicExample {

    /**
     * 库存
     */
    static class Inventory {

        private AtomicInteger num = new AtomicInteger(100);

        //增加库存
        public void add(int n) {
            //增加库存
            num.incrementAndGet();
            System.out.println("增加库存后的数量=" + num);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                inventory.add(1);
            }).start();
        }
    }
}
