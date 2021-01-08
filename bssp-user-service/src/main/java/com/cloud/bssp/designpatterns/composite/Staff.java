package com.cloud.bssp.designpatterns.composite;

import java.util.List;

/**
 * 员工
 * @date: 2021/1/8
 * @author weirx
 * @version 3.0
 */
public class Staff extends Employee {

    public Staff(String name, List<Employee> employee) {
        super(name, employee);
    }

    public void desc() {
        System.out.println("I am staff，my name is " + super.getName() + ",employee is " + super.getEmployee());
    }
}
