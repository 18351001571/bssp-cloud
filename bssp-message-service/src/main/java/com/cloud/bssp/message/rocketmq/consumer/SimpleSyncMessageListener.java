package com.cloud.bssp.message.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
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
@RocketMQMessageListener(topic = "test_sync", selectorExpression = "*", consumerGroup = "test_sync")
public class SimpleSyncMessageListener implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        String msg = new String(body);
        log.info("receive sync message：{}", msg);
    }
}
