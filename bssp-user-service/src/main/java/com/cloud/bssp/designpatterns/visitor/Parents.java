package com.cloud.bssp.designpatterns.visitor;

/**
 * 家长访问者
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public class Parents implements Visitor {

    @Override
    public void visit(Teacher user) {
        System.out.println("--------家长访问------------");
        System.out.println("教师姓名：" + user.getName());
        System.out.println("班级：" + user.getTheClass());
        System.out.println("升学率为：" + user.getGraduationRates());
    }

    @Override
    public void visit(Student user) {
        System.out.println("----------家长访问----------");
        System.out.println("学生姓名：" + user.getName());
        System.out.println("排名：" + user.getRank());
        System.out.println("班级：" + user.getThClass());
    }
}
