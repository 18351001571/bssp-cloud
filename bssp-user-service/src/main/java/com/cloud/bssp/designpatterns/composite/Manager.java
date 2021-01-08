package com.cloud.bssp.designpatterns.composite;

import java.util.List;

/**
 * 经理
 * @date: 2021/1/8
 * @author weirx
 * @version 3.0
 */
public class Manager extends Employee{

    public Manager(String name, List<Employee> employee) {
        super(name, employee);
    }

    public void desc(){
        System.out.println("I am manager，my name is " + super.getName()+",employee is "+ super.getEmployee());
    }
}
