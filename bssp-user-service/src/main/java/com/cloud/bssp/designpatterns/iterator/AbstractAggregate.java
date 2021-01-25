package com.cloud.bssp.designpatterns.iterator;

/**
 * 抽象集合
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public interface AbstractAggregate {

    AbstractIterator iterator();
}
