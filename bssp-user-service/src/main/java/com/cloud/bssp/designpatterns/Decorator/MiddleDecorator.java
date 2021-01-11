package com.cloud.bssp.designpatterns.Decorator;

/**
 * 中装饰器
 * @date: 2021/1/8
 * @author weirx
 * @version 3.0
 */
public class MiddleDecorator implements AbstractDolls{

    private AbstractDolls abstractDolls;

    public MiddleDecorator(AbstractDolls abstractDolls) {
        this.abstractDolls = abstractDolls;
    }

    @Override
    public int getSize() {
        return abstractDolls.getSize();
    }

    @Override
    public void setSize(int size) {
        abstractDolls.setSize(size);
    }

    public void configSize(){
        this.setSize(this.getSize()+10);
    }
}
