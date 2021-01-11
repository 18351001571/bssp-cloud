package com.cloud.bssp.designpatterns.faced.withoutdesign.edu;

import com.cloud.bssp.designpatterns.faced.withoutdesign.student.StudentAddressService;
import com.cloud.bssp.designpatterns.faced.withoutdesign.student.StudentAgeService;
import com.cloud.bssp.designpatterns.faced.withoutdesign.student.StudentNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 教育服务
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
@Service
public class EduService {

    @Autowired
    private StudentNameService studentNameService;

    @Autowired
    private StudentAgeService studentAgeService;

    @Autowired
    private StudentAddressService studentAddressService;

    public void getStudentName(){
        System.out.println("学生姓名是：" + studentNameService.getName());
    }

    public void getStudentAge(){
        System.out.println("学生年龄是：" + studentAgeService.getAge());
    }

    public void getStudentAddress(){
        System.out.println("学生地址是：" + studentAddressService.getAddress());
    }
}
