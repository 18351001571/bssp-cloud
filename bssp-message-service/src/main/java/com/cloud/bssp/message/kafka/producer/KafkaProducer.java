package com.cloud.bssp.message.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * kafka生产者
 *
 * @author weirx
 * @date 2021/02/03 14:22
 **/
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * kafka消息发送
     * @param
     * @author weirx
     * @return void
     * @date: 2021/2/3
     */
    public void send(String topic){
        kafkaTemplate.send(topic,"hello kafka");
    }
}
