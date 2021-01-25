package com.cloud.bssp.designpatterns.state;

/**
 * 开启状态
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class StartState extends State{

    public StartState(Activity activity) {
        super(activity);
    }

    @Override
    public State edit() {
        System.out.println("已开启无法编辑");
        return this;
    }

    @Override
    public State save() {
        System.out.println("已开启无法保存");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("已开启无法提交");
        return this;
    }

    @Override
    public State pass() {
        System.out.println("已开启无法审核");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("已开启无法审核");
        return this;
    }

    @Override
    public State start() {
        System.out.println("已开启无法再次开启");
        return this;
    }

    @Override
    public State close() {
        System.out.println("活动已经关闭");
        return activity.changeState(new CloseState(activity));
    }
}
