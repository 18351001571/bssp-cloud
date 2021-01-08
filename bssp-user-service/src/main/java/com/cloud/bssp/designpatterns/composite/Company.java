package com.cloud.bssp.designpatterns.composite;

import java.util.List;

/**
 * 公司
 * @date: 2021/1/8
 * @author weirx
 * @version 3.0
 */
public class Company extends Employee {


    public Company(String name, List<Employee> employee) {
        super(name, employee);
    }

    public void desc() {
        System.out.println("this is company，name is " + super.getName());
        List<Employee> list = this.getEmployee();
        System.out.println("---------------------");
        list.forEach(c -> {
            System.out.println("I am CEO ,my name is " + c.getName());
            c.getEmployee().forEach(m -> {
                System.out.println("I am manager ,my name is " + m.getName()+ ";my leader is " + c.getName());
                m.getEmployee().forEach(s -> {
                    System.out.println("I am staff ,my name is " + s.getName()+ ";my leader is " + m.getName());
                });
            });
        });

    }
}
