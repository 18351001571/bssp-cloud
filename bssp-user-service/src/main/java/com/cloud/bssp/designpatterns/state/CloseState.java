package com.cloud.bssp.designpatterns.state;

/**
 * 关闭状态
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class CloseState extends State{

    public CloseState(Activity activity) {
        super(activity);
    }

    @Override
    public State edit() {
        System.out.println("活动正在编辑中");
        return activity.changeState(new EditState(activity));
    }

    @Override
    public State save() {
        System.out.println("关闭状态无法保存");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("关闭状态无法提交");
        return this;
    }

    @Override
    public State pass() {
        System.out.println("关闭状态无法再次审核");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("关闭状态无法再次审核");
        return this;
    }

    @Override
    public State start() {
        System.out.println("关闭状态无法开启");
        return this;
    }

    @Override
    public State close() {
        System.out.println("关闭状态无法再次关闭");
        return this;
    }

}
