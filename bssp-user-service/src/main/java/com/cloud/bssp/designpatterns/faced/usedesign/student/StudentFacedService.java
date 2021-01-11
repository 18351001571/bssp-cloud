package com.cloud.bssp.designpatterns.faced.usedesign.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 外观模式服务
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
@Service
public class StudentFacedService {

    @Autowired
    private StudentNameService studentNameService;

    @Autowired
    private StudentAgeService studentAgeService;

    @Autowired
    private StudentAddressService studentAddressService;

    public String getStudentName(){
        return studentNameService.getName();
    }

    public int getStudentAge(){
        return studentAgeService.getAge();
    }

    public String getStudentAddress(){
        return studentAddressService.getAddress();
    }

}
