package com.cloud.bssp.designpatterns.composite;

import java.util.List;

/**
 * CEO
 * @date: 2021/1/8
 * @author weirx
 * @version 3.0
 */
public class CEO extends Employee {

    public CEO(String name, List<Employee> employee) {
        super(name, employee);
    }

    public void desc(){
        System.out.println("I am CEO，my name is " + super.getName()+",employee is "+ super.getEmployee());
    }
}
