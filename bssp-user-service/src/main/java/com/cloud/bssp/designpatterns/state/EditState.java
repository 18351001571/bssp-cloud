package com.cloud.bssp.designpatterns.state;

/**
 * 编辑状态
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class EditState extends State {

    public EditState(Activity activity) {
        super(activity);
    }

    @Override
    public State edit() {
        System.out.println("活动正在编辑");
        return this;
    }

    @Override
    public State save() {
        System.out.println("活动已保存");
        return activity.changeState(new SaveState(activity));
    }

    @Override
    public State submit() {
        System.out.println("活动已提交");
        return activity.changeState(new SubmitState(activity));
    }

    @Override
    public State pass() {
        System.out.println("编辑中无法审核");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("编辑中无法审核");
        return this;
    }

    @Override
    public State start() {
        System.out.println("编辑中无法开启");
        return this;
    }

    @Override
    public State close() {
        System.out.println("编辑中无法关闭");
        return this;
    }
}
