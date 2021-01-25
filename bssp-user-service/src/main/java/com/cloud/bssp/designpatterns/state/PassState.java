package com.cloud.bssp.designpatterns.state;

/**
 * 通过状态
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class PassState extends State{

    public PassState(Activity activity) {
        super(activity);
    }

    @Override
    public State edit() {
        System.out.println("审核通过无法编辑");
        return this;
    }

    @Override
    public State save() {
        System.out.println("审核通过无法保存");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("审核通过无法提交");
        return this;
    }

    @Override
    public State pass() {
        System.out.println("审核通过无法再次审核");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("审核通过无法再次审核");
        return this;
    }

    @Override
    public State start() {
        System.out.println("活动已经开启");
        return activity.changeState(new StartState(activity));
    }

    @Override
    public State close() {
        System.out.println("审核通过无法关闭");
        return this;
    }
}
