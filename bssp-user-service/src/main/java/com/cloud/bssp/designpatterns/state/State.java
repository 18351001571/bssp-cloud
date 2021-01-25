package com.cloud.bssp.designpatterns.state;

/**
 * 抽象状态类
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
abstract class State {

    public Activity activity;

    public State(Activity activity) {
        this.activity = activity;
    }

    /**
     * 编辑
     */
    public abstract State edit();

    /**
     * 保存
     */
    public abstract State save();

    /**
     * 提交
     */
    public abstract State submit();

    /**
     * 审核通过
     */
    public abstract State pass();

    /**
     * 审核拒绝
     */
    public abstract State reject();

    /**
     * 开启
     */
    public abstract State start();

    /**
     * 关闭
     */
    public abstract State close();

}
