package com.cloud.bssp.designpatterns.faced.usedesign.student;

import org.springframework.stereotype.Service;

/**
 * 学生地址
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
@Service
public class StudentAddressService implements IStudentAddress {

    @Override
    public String getAddress() {
        Student student = new Student();
        return student.getAddress();
    }
}
