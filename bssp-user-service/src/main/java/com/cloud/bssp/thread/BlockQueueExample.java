package com.cloud.bssp.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description: 阻塞队列实现线程同步
 * Create Date: 2020/8/17
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class BlockQueueExample {

    /**
     * 定义一个元素的队列,通过阻塞达到新增一个消费一个的效果
     * 数组元素定义多个时，因消费线程是100个独立线程，执行时间顺序存在差异，不能保证完全顺序执行
     */
    final static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(1);

    /**
     * 库存
     */
    static class Inventory {

        //增加库存
        public void add(int n) {
            try {
                System.out.println("开始增加第" + n + "库存。。。。。");
                //压入队列
                queue.put("第" + n + "库存。。。。。");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //减少库存
        public void sub() {
            try {
                //取出数据
                System.out.println("[取出]====" + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                inventory.add(i);
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                inventory.sub();
            }).start();
        }
    }
}
