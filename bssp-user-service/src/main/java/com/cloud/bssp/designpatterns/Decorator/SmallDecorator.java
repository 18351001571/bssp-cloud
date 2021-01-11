package com.cloud.bssp.designpatterns.Decorator;

/**
 * 小装饰器
 * @date: 2021/1/8
 * @author weirx
 * @version 3.0
 */
public class SmallDecorator implements AbstractDolls{

    private AbstractDolls abstractDolls;

    public SmallDecorator(AbstractDolls abstractDolls) {
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
