package com.cloud.bssp.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * Description: WaitAndNotify
 * Create Date: 2020/8/19
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public class WaitAndNotify {

    static class Print {
        /**
         * 当值为1时打印数字，当值为2时打印字母
         */
        private int flag = 1;
        private int count = 1;

        public synchronized void printNum() {
            if (flag != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(count);
            flag = 2;
            notify();
        }

        public synchronized void printChar() {
            if (flag != 2) {
                //打印字母
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print((char) (count - 1 + 'A'));
            count++;
            flag = 1;
            notify();
        }
    }

    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                print.printNum();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                print.printChar();
            }
        }).start();
    }
}
