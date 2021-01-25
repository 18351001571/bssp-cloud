package com.cloud.bssp.designpatterns.observer;

/**
 * 检测事件
 * @date: 2021/1/22
 * @author weirx
 * @version 3.0
 */
public class CheckEvent implements IEvent{

    private String name;

    private String result;

    private ISubscriber subscriber;

    public ISubscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
    }

    public CheckEvent(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        subscriber.look();
        System.out.println("事件名称：" + name);
        System.out.println("事件结果：" + result);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
