package com.cloud.bssp.designpatterns.memento;

/**
 * 管理者
 * @date: 2021/1/22
 * @author weirx
 * @version 3.0
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
