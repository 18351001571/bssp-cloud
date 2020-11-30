package com.cloud.bssp.message.rocketmq.producer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * RocketMqProducer
 * @date: 2020/11/26
 * @author weirx
 * @version 3.0
 */
@Slf4j
@Component
public class RocketMqProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送普通消息（同步发送）
     */
    public void sendSync(String msgBody, String topic) {
        for (int i = 0; i < 10; i++) {
            try {
                SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msgBody).build());
                if (ObjectUtils.isNotEmpty(sendResult)) {
                    //sendResult不空则表示消息发送成功
                    log.info("send success , send msg = {}, messageId = {}", msgBody, sendResult.getMsgId());
                }
            } catch (Exception e) {
                log.info("send failed, msg = {}", e);
            }

        }
    }

    /**
     * 发送普通消息（异步发送）
     */
    public void sendAsync(String msgBody, String topic) {
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(msgBody).build(), new SendCallback() {

                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("send success , send msg = {}, messageId = {}", msgBody, sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable throwable) {
                    log.info("send failed, msg = {}", throwable);
                }
            });
        }
    }

    /**
     * 发送普通消息（单向发送）
     */
    public void sendOneWay(String msgBody, String topic) {
        for (int i = 0; i < 10; i++) {
            //没有返回值和回调方法
            rocketMQTemplate.sendOneWay(topic, MessageBuilder.withPayload(msgBody).build());
        }
    }

    /**
     * 发送顺序消息
     */
    public void sendSyncOrder(String msgBody, String topic, String orderId) {
        for (int i = 0; i < 10; i++) {
            SendResult sendResult = rocketMQTemplate.syncSendOrderly(topic, MessageBuilder.withPayload(msgBody).build(), orderId);
            if (ObjectUtils.isNotEmpty(sendResult)) {
                //sendResult不空则表示消息发送成功
                log.info("send success , send msg = {}, messageId = {}", msgBody, sendResult.getMsgId());
            }
        }
    }

    /**
     * 发送异步顺序消息
     */
    @SneakyThrows
    public void sendAsyncOrder(String msgBody, String topic, String orderId) {
        for (int i = 0; i < 10; i++) {
            //这里为了清晰地展示每次发送消息的顺，添加一秒的间隔
            Thread.sleep(1000);
            rocketMQTemplate.asyncSendOrderly(topic, MessageBuilder.withPayload(msgBody).build(), orderId, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("send success , send msg = {}, messageId = {}", msgBody, sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable throwable) {
                    log.info("send failed , msg = {} ", throwable);
                }
            });
        }
    }

    /**
     * 发送延时消息
     */
    public void sendDelay(String topic, String msgBody, long timeout, Integer delayLevel) {
        SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msgBody).build(), timeout, delayLevel);
        if (ObjectUtils.isNotEmpty(sendResult)) {
            //sendResult不空则表示消息发送成功
            log.info("send success , send msg = {}, messageId = {}", msgBody, sendResult.getMsgId());
        }
    }

    /**
     * 发送事务消息
     * @date: 2020/11/30
     * @param topic
     * @param msgBody
     * @return void
     * @author weirx
     * @version 3.0
     */
    public void sendTransaction(String topic, String msgBody) {
        //发送事务消息
        rocketMQTemplate.sendMessageInTransaction(topic, MessageBuilder.withPayload(msgBody).build(), null);
    }

    /**
     * 重试
     */
    public void reconsume(String msgBody, String topic) {
        SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msgBody).build());
        if (ObjectUtils.isNotEmpty(sendResult)) {
            //sendResult不空则表示消息发送成功
            log.info("send success , send msg = {}, messageId = {}", msgBody, sendResult.getMsgId());
        }
    }

    /**
     * tag消息过滤
     */
    public void tag(String msgBody, String topic) {
        SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msgBody).build());
        if (ObjectUtils.isNotEmpty(sendResult)) {
            //sendResult不空则表示消息发送成功
            log.info("send success , send msg = {}, messageId = {}", msgBody, sendResult.getMsgId());
        }
    }
}
