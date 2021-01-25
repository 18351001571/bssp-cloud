package com.cloud.bssp.designpatterns.state;

/**
 * 测试
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        //初始化活动
        Activity activity = new Activity("1", "活动1");
        //初始化编辑状态
        State state = new EditState(activity);
        //保存
        state = state.save();
        //提交
        state = state.submit();
        //审核通过
        state = state.pass();
        //开启
        state = state.start();
        //开启状态下编辑
        state.edit();
        //开启状态下提交
        state.submit();
    }
}
