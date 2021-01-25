package com.cloud.bssp.designpatterns.memento;

/**
 * TODO
 * @date: 2021/1/22
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {

        //创建角色并初始化
        GameRole gameRole = new GameRole();
        gameRole.getInstance();
        //获取当前角色状态
        gameRole.state();
        //存档
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.save());
        //战斗
        gameRole.fight();
        //获取角色状态
        gameRole.state();
        //读档
        gameRole.read(caretaker.getMemento());
        //获取角色状态
        gameRole.state();
    }
}
