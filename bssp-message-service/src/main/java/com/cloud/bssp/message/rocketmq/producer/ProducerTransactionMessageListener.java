package com.cloud.bssp.message.rocketmq.producer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 监听生产者发送消息后的回调，以及本地事务回查
 *
 * 注意：在rocketmq 2.1.0 版本重构了事务消息api，@RocketMQTransactionListener注解额txProducerGroup属性去掉了
 * 可参考：https://blog.csdn.net/z69183787/article/details/109958380
 * @date: 2020/11/30
 * @author weirx
 * @version 3.0
 */
@Slf4j
@Component
@RocketMQTransactionListener
public class ProducerTransactionMessageListener implements RocketMQLocalTransactionListener {

    /**
     * mq收到半事务消息后的回调方法，此处执行本地事务
     * @date: 2020/11/30
     * @param message
     * @param o
     * @return org.apache.rocketmq.spring.core.RocketMQLocalTransactionState
     * @author weirx
     * @version 3.0
     */
    @SneakyThrows
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("half message send success，msg = {}", message);
        try {
            //休眠60s
            Thread.sleep(60000);
            //增加异常抛出
//            throw new Exception("模拟本地事务处理失败");
        } catch (Exception e) {
            log.info("local transaction failed, msg = {}", e.getMessage());
            return RocketMQLocalTransactionState.ROLLBACK;
        }
//        log.info("local transaction success, tell mq to commit");
//        return RocketMQLocalTransactionState.COMMIT;
        log.info("local transaction unknown");
        return RocketMQLocalTransactionState.UNKNOWN;
    }

    /**
     * mq回查本地事务的状态
     * @date: 2020/11/30
     * @param message
     * @return org.apache.rocketmq.spring.core.RocketMQLocalTransactionState
     * @author weirx
     * @version 3.0
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        log.info("check local transaction state");
        //模拟本地事务的回查业务
        if (System.currentTimeMillis() % 3 == 0) {
            log.info("local transaction execute success，transaction commit");
            return RocketMQLocalTransactionState.COMMIT;
        } else {
            log.info("local transaction execute failed，transaction rollback");
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
}
