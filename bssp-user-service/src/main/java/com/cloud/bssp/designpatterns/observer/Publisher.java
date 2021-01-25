package com.cloud.bssp.designpatterns.observer;

import java.util.List;

/**
 * 消息发送者
 * @date: 2021/1/22
 * @author weirx
 * @version 3.0
 */
public class Publisher implements IPublisher{

    private IEvent event;

    private List<ISubscriber> subscribers;

    public Publisher(IEvent event, List<ISubscriber> subscribers) {
        this.event = event;
        this.subscribers = subscribers;
    }

    /**
     * 发布消息
     * @param event
     */
    @Override
    public void publish(IEvent event){
        event.print();
    }

    public IEvent getEvent() {
        return event;
    }

    public void setEvent(IEvent event) {
        this.event = event;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

}
