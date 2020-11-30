package com.cloud.bssp.message.rocketmq;

import com.cloud.bssp.message.rocketmq.producer.RocketMqProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * RocketMqTest
 * @date: 2020/11/26
 * @author weirx
 * @version 3.0
 */

@Slf4j
@Component
@RestController
@RequestMapping("/message")
public class RocketMqTest {

    @Autowired
    private RocketMqProducer rocketMqProducer;

    /**
     * 普通消息同步发送
     */
    @RequestMapping("/send/sync")
    public void sendMsg() {
        rocketMqProducer.sendSync("普通消息-同步发送", "test_sync");
    }

    /**
     * 普通消息异步步发送
     */
    @RequestMapping("/send/async")
    public void sendAsync() {
        rocketMqProducer.sendAsync("普通消息-异步发送", "test_async");
    }

    /**
     * 普通消息单向发送
     */
    @RequestMapping("/send/oneway")
    public void sendOneway() {
        rocketMqProducer.sendOneWay("普通消息-单向发送", "test_oneway");
    }

    /**
     * 顺序消息同步发送
     */
    @RequestMapping("/send/syncOrder")
    public void syncOrder() {
        rocketMqProducer.sendSyncOrder("顺序消息-顺序同步发送", "test_syncOrder", UUID.randomUUID().toString());
    }

    /**
     * 顺序消息异步发送
     */
    @RequestMapping("/send/asyncOrder")
    public void asyncOrder() {
        rocketMqProducer.sendAsyncOrder("顺序消息-顺序异步发送", "test_asyncOrder", UUID.randomUUID().toString());
    }

    /**
     * 定时消息发送
     */
    @RequestMapping("/send/delay")
    public void delay() {
        rocketMqProducer.sendDelay("test_delay", "延时消息", 3000L, 5);
    }

    /**
     * 事务消息发送
     */
    @RequestMapping("/send/transaction")
    public void transaction() {
        rocketMqProducer.sendTransaction("test_transaction", "事务消息");
    }

    /**
     * 消息重试,消费者监听形式
     */
    @RequestMapping("/send/reconsume")
    public void reconsume() {
        rocketMqProducer.reconsume("消息重试,消费者监听形式", "test_reconsume");
    }

    /**
     * 消息重试,自定义初始化消费者
     */
    @RequestMapping("/send/reconsume1")
    public void reconsume1() {
        rocketMqProducer.reconsume("消息重试,自定义初始化消费者", "test_reconsume_2");
    }


    /**
     * 消息过滤，发送tag消息
     */
    @RequestMapping("/send/tag/{tag}")
    public void tag(@PathVariable("tag") String tag) {
        //发送格式topic:tag
        rocketMqProducer.tag("消息过滤，发送tag消息", "test_tag:"+tag);
    }

}
