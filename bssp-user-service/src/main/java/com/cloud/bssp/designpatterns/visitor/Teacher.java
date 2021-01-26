package com.cloud.bssp.designpatterns.visitor;

/**
 * 教师类
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public class Teacher implements User {

    /**
     * 姓名
     */
    private String name;

    /**
     * 班级
     */
    private String theClass;

    /**
     * 升学率
     */
    private double graduationRates;

    public Teacher(String name, String theClass, double graduationRates) {
        this.name = name;
        this.theClass = theClass;
        this.graduationRates = graduationRates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheClass() {
        return theClass;
    }

    public void setTheClass(String theClass) {
        this.theClass = theClass;
    }

    public double getGraduationRates() {
        return graduationRates;
    }

    public void setGraduationRates(double graduationRates) {
        this.graduationRates = graduationRates;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
