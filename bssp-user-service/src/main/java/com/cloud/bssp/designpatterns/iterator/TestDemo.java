package com.cloud.bssp.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        //初始化几个乘客
        List<String> list = new ArrayList<>();
        list.add("小明");
        list.add("小赵");
        list.add("小钱");
        list.add("小孙");
        list.add("小李");
        //初始化一个公交处
        BusAggregate busAggregate = new BusAggregate(list);
        //初始化一个售票员
        ConductorIterator conductorIterator = new ConductorIterator(busAggregate);
        String name = conductorIterator.first();
        System.out.println("第一位买票的乘客是：" + name);
        while (conductorIterator.hasNext()) {
            if (name.equals(conductorIterator.current())){
                conductorIterator.next();
                continue;
            }
            System.out.println("下一位买票的乘客是：" + conductorIterator.next());
        }

    }
}
