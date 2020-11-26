package com.cloud.bssp.message;

import com.cloud.bssp.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private  RocketMqProducer rocketMqProducer;

    @RequestMapping("/send")
    public void sendMsg(){
        rocketMqProducer.sendMsg("我来测试以下rocketmq");
    }

}
