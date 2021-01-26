package com.cloud.bssp.designpatterns.visitor;

/**
 * 测试类
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public class TestDemo {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("张老师", "一班", 0.99);
        Student student = new Student("小张", "一班", 8);

        HeadMaster headMaster = new HeadMaster();
        student.accept(headMaster);
        teacher.accept(headMaster);

        Parents parents = new Parents();
        student.accept(parents);
        teacher.accept(parents);
    }
}
