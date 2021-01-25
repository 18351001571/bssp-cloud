package com.cloud.bssp.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 * @date: 2021/1/22
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        //定义两种结果
        String[] doc = {"阴性", "阳性"};
        //初始化检测事件
        CheckEvent check = new CheckEvent("核酸检测");
        //初始化消息发布者
        Publisher publisher = new Publisher(check,new ArrayList<>());
        //实例化接受检测的用户
        List<ISubscriber> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //初始化用户
            User user = new User("小" + i);
            users.add(user);
        }
        //用户订阅事件
        publisher.setSubscribers(users);
        int index;
        //发布检测结果
        for (int i = 0; i < 10; i++) {
            System.out.println("---------------");
            //随机检测结果
            index = (int) (Math.random() * doc.length);
            check.setSubscriber(users.get(i));
            check.setResult(doc[index]);
            //发布
            publisher.publish(check);
        }

    }
}
