package com.cloud.bssp.designpatterns.faced.usedesign.student;

import org.springframework.stereotype.Service;

/**
 * TODO
 * @date: 2021/1/11
 * @author weirx
 * @version 3.0
 */
@Service
public class StudentNameService implements IStudentName {

    @Override
    public String getName() {
        Student student = new Student();
        return student.getName();
    }
}
