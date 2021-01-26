package com.cloud.bssp.designpatterns.visitor;

/**
 * 人员接口
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public interface User {

    /**
     * 查询
     */
    void accept(Visitor visitor);
}
