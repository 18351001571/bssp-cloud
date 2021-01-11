package com.cloud.bssp.designpatterns.faced.usedesign.student;

/**
 * 学生
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
public class Student {

    private String name = "张三";

    private int age = 11;

    private String address = "哈尔滨";

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
