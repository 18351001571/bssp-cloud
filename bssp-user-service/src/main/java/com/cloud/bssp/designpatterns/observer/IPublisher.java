package com.cloud.bssp.designpatterns.observer;

/**
 * 发布接口
 * @date: 2021/1/22
 * @author weirx
 * @version 3.0
 */
public interface IPublisher {

    /**
     * 发布事件
     * @param event
     */
    void publish(IEvent event);
}
