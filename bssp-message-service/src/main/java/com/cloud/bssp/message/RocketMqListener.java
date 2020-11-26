package com.cloud.bssp.message;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RocketMqProducer
 * @date: 2020/11/26
 * @author weirx
 * @version 3.0
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "queue_test_topic", selectorExpression = "*", consumerGroup = "queue_group_test")
public class RocketMqListener implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        String msg = new String(body);
        log.info("接收到消息：{}", msg);

    }
}
