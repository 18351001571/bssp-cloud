package com.cloud.bssp.designpatterns.state;

/**
 * 保存状态
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class SaveState extends State{

    public SaveState(Activity activity) {
        super(activity);
    }

    @Override
    public State edit() {
        System.out.println("活动正在编辑中");
        return activity.changeState(new EditState(activity));
    }

    @Override
    public State save() {
        System.out.println("活动已保存");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("活动已提交");
        return activity.changeState(new SubmitState(activity));
    }

    @Override
    public State pass() {
        System.out.println("保存状态无法审核");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("保存状态无法审核");
        return this;
    }

    @Override
    public State start() {
        System.out.println("保存状态无法开启");
        return this;
    }

    @Override
    public State close() {
        System.out.println("保存状态无法关闭");
        return this;
    }
}
