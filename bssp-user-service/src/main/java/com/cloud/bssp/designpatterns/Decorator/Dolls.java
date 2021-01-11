package com.cloud.bssp.designpatterns.Decorator;

/**
 * 套娃实体
 * @date: 2021/1/8
 * @author weirx
 * @version 3.0
 */
public class Dolls implements AbstractDolls{

    public Dolls(int size) {
        this.size = size;
    }

    private int size;

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
