package com.cloud.bssp.designpatterns.state;

/**
 * 活动
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class Activity {

    /**
     * 活动id
     */
    private String id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 更新状态
     */
    public State changeState(State state){
        return state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Activity(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
