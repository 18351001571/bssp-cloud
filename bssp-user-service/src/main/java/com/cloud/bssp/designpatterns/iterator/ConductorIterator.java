package com.cloud.bssp.designpatterns.iterator;

/**
 * 售票员迭代
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class ConductorIterator implements AbstractIterator {

    private BusAggregate aggregate;

    private int current = 0;

    @Override
    public String first() {
        return aggregate.getList().get(0);
    }

    @Override
    public boolean hasNext() {
        if (aggregate.getList().size() > current) {
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        return aggregate.getList().get(current++);
    }

    public ConductorIterator(BusAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public String current() {
        return aggregate.getList().get(current);
    }
}
