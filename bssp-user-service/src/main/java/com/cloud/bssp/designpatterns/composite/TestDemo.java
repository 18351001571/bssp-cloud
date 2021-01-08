package com.cloud.bssp.designpatterns.composite;


import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.prototype.Car;
import com.cloud.bssp.designpatterns.prototype.Engine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * 客户端
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BsspUserApplication.class)
public class TestDemo {

    @Test
    public void test() {

        //创建一个公司
        Company company = new Company("神奇公司",new ArrayList<>());
        //招聘公司的CEO
        CEO ceo = new CEO("神奇",new ArrayList<>());
        //招聘经理
        Manager manager1 = new Manager("神奇一号",new ArrayList<>());
        Manager manager2 = new Manager("神奇二号",new ArrayList<>());
        Manager manager3 = new Manager("神奇三号",new ArrayList<>());
        //招聘员工
        Staff staff1 = new Staff("员工一号", new ArrayList<>());
        Staff staff2 = new Staff("员工二号", new ArrayList<>());
        Staff staff3 = new Staff("员工三号", new ArrayList<>());
        Staff staff4 = new Staff("员工四号", new ArrayList<>());
        Staff staff5 = new Staff("员工五号", new ArrayList<>());
        //组装公司组织结构
        //安排经理下属
        manager1.getEmployee().add(staff1);
        manager1.getEmployee().add(staff2);
        manager2.getEmployee().add(staff3);
        manager2.getEmployee().add(staff4);
        manager3.getEmployee().add(staff5);
        //安排ceo下属
        ceo.getEmployee().add(manager1);
        ceo.getEmployee().add(manager2);
        ceo.getEmployee().add(manager3);
        //安排ceo到公司
        company.getEmployee().add(ceo);
        //输出公司组织架构
        company.desc();

    }

}
