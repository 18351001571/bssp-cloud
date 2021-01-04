package com.cloud.bssp.jvm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 模拟CPU、内存飙高程序
 *
 * @date: 2020/12/21
 * @author weirx
 * @version 3.0
 */
public class TestCPUAndMemHigh {

    private static class CardInfo {

        String name = "张三疯";
        int age = 54;
        LocalDate birthdate = LocalDate.now();
        String address = "黑龙江省哈尔滨市南岗区金葫芦村88号";

        //空方法，用于线程调用，持续占用对象
        public void m() {
        }
    }

    /**
     * 50个调度线程
     */
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50,
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws Exception {
        executor.setMaximumPoolSize(50);

        //死循环
        for (; ; ) {
            modelFit();
            Thread.sleep(100);
        }
    }

    /**
     * 创建对象并线程调用对象方法
     */
    private static void modelFit() {
        //获取对象列表
        List<CardInfo> taskList = getAllCardInfo();
        //遍历
        taskList.forEach(info -> {
            // 线程调用对象方法
            executor.scheduleWithFixedDelay(() -> {
                //do sth with info
                info.m();

            }, 2, 3, TimeUnit.SECONDS);
        });
    }

    /**
     * 获取对象list
     * @return
     */
    private static List<CardInfo> getAllCardInfo() {
        List<CardInfo> taskList = new ArrayList<>();
        //创建一百个对象
        for (int i = 0; i < 100; i++) {
            CardInfo ci = new CardInfo();
            taskList.add(ci);
        }
        return taskList;
    }
}
