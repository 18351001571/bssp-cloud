package com.cloud.bssp.designpatterns.state;

/**
 * 拒绝状态
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class RejectState extends State{

    public RejectState(Activity activity) {
        super(activity);
    }

    @Override
    public State edit() {
        System.out.println("审核拒绝无法编辑");
        return this;
    }

    @Override
    public State save() {
        System.out.println("审核拒绝无法保存");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("审核拒绝无法提交");
        return this;
    }

    @Override
    public State pass() {
        System.out.println("审核拒绝无法再次审核");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("审核拒绝无法再次审核");
        return this;
    }

    @Override
    public State start() {
        System.out.println("审核拒绝无法开启");
        return this;
    }

    @Override
    public State close() {
        System.out.println("活动已经关闭");
        return activity.changeState(new StartState(activity));
    }
}
