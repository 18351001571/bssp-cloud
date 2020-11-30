package com.cloud.bssp.message.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 重试consumer
 *
 * @date: 2020/11/30
 * @author weirx
 * @version 3.0
 */
@Component
@Slf4j
public class RetryConsumer {
    public static void main(String[] args) throws MQClientException {
        //创建消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rmq-group");
        //设置NameServer地址,替换成自己的ip地址
        consumer.setNamesrvAddr("101.200.36.168:9876");
        //设置实例名称
        consumer.setInstanceName("consumer");
        //订阅topic
        consumer.subscribe("test_reconsume_2", "");
        //设置重试次数为2
        consumer.setMaxReconsumeTimes(2);
        //监听消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //获取消息
                for (MessageExt messageExt : list) {
                    log.info("消息重试：{} ", messageExt.getMsgId() + "---" + new String(messageExt.getBody()));
                }
                try {
                    //模拟错误
                    int i = 5 / 0;
                } catch (Exception e) {
                    e.printStackTrace();
                    //需要重试
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                //不需要重试
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        consumer.start();
        System.out.println("Consumer Started!");
    }
}
