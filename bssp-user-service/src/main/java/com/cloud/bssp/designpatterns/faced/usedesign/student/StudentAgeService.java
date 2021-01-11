package com.cloud.bssp.designpatterns.faced.usedesign.student;

import org.springframework.stereotype.Service;

/**
 * TODO
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
@Service
public class StudentAgeService implements IStudentAge {

    @Override
    public int getAge() {
        Student student = new Student();
        return student.getAge();
    }
}
