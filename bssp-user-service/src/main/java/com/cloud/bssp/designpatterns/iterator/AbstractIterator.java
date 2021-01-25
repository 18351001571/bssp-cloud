package com.cloud.bssp.designpatterns.iterator;

/**
 * 抽象迭代器
 * @date: 2021/1/13
 * @author weirx
 * @version 3.0
 */
public interface AbstractIterator {

    String first();

    boolean hasNext();

    String next();

    String current();

}
