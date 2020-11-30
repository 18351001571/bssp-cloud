package com.cloud.bssp.message.rocketmq.consumer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * RocketMqProducer
 * @date: 2020/11/26
 * @author weirx
 * @version 3.0
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "test_asyncOrder",
        selectorExpression = "*",
        consumerGroup = "test_asyncOrder",
        consumeMode = ConsumeMode.ORDERLY)
public class SimpleAsyncOrderMessageListener implements RocketMQListener<MessageExt> {

    @SneakyThrows
    @Override
    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        String msg = new String(body);
        log.info("receive sync message：{}", msg);
        Thread.sleep(15000);
    }
}
