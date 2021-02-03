package com.cloud.bssp.message.kafka;

import com.cloud.bssp.message.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka测试类
 *
 * @author weirx
 * @date 2021/02/03 15:03
 **/
@RestController
@RequestMapping("test/kafka")
public class TestKafka {

    @Autowired
    private KafkaProducer producer;

    @RequestMapping("/send/{topic}")
    public void send(@PathVariable String topic){
        producer.send(topic);
    }
}
