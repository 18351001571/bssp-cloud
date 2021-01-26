package com.cloud.bssp.designpatterns.visitor;

/**
 * 访问者
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public interface Visitor {

    /**
     * 访问教师
     * @param user
     */
    void visit(Teacher user);

    /**
     * 访问学生
     * @param user
     */
    void visit(Student user);
}
