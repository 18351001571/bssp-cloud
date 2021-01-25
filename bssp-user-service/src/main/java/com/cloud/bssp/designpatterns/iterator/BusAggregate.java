package com.cloud.bssp.designpatterns.iterator;

import java.util.List;

/**
 * bus集合
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public class BusAggregate implements AbstractAggregate {

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    private List<String> list;

    public BusAggregate(List<String> list) {
        this.list = list;
    }

    @Override
    public AbstractIterator iterator() {
        return new ConductorIterator(this);
    }
}
