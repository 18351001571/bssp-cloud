package com.cloud.bssp.designpatterns.composite;

import java.util.List;

/**
 * 员工抽象
 * @date: 2021/1/8
 * @author weirx
 * @version 3.0
 */
public abstract class Employee {

    private String name;
    private List<Employee> employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Employee(String name, List<Employee> employee) {
        this.name = name;
        this.employee = employee;
    }
}
