package com.cloud.bssp.designpatterns.visitor;

/**
 * 学生
 * @date: 2021/1/26
 * @author weirx
 * @version 3.0
 */
public class Student implements User {

    /**
     * 姓名
     */
    private String name;

    /**
     * 班级
     */
    private String thClass;
    /**
     * 排名
     */
    private Integer rank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThClass() {
        return thClass;
    }

    public void setThClass(String thClass) {
        this.thClass = thClass;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Student(String name, String thClass, Integer rank) {
        this.name = name;
        this.thClass = thClass;
        this.rank = rank;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
