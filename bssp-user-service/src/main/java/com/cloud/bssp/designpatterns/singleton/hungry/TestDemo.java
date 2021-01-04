package com.cloud.bssp.designpatterns.singleton.hungry;


import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.singleton.Singleton;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    }
}
