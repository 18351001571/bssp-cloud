package com.cloud.bssp.designpatterns.state;

/**
 * 提交状态
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class SubmitState extends State{

    public SubmitState(Activity activity) {
        super(activity);
    }

    @Override
    public State edit() {
        System.out.println("活动已提交，无法编辑");
        return this;
    }

    @Override
    public State save() {
        System.out.println("活动已提交，无法保存");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("活动已提交，无法再次提交");
        return this;
    }

    @Override
    public State pass() {
        System.out.println("活动已经审核通过");
        return activity.changeState(new PassState(activity));
    }

    @Override
    public State reject() {
        System.out.println("活动已经审核拒绝");
        return activity.changeState(new RejectState(activity));
    }

    @Override
    public State start() {
        System.out.println("未审核无法开启");
        return this;
    }

    @Override
    public State close() {
        System.out.println("未审核无法关闭");
        return this;
    }
}
