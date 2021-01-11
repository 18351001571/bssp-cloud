package com.cloud.bssp.designpatterns.faced.usedesign.edu;

import com.cloud.bssp.designpatterns.faced.usedesign.student.StudentFacedService;
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
    private StudentFacedService studentFacedService;

    public void getStudentName() {
        System.out.println("学生姓名是：" + studentFacedService.getStudentName());
    }

    public void getStudentAge() {
        System.out.println("学生年龄是：" + studentFacedService.getStudentAge());
    }

    public void getStudentAddress() {
        System.out.println("学生地址是：" + studentFacedService.getStudentAddress());
    }
}
