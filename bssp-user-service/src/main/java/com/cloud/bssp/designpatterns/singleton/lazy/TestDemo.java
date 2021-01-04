package com.cloud.bssp.designpatterns.singleton.lazy;


import com.cloud.bssp.BsspUserApplication;
import com.cloud.bssp.designpatterns.singleton.Singleton;
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

    public Singleton singleton = null;

    @Test
    public void test() {
        Singleton s = new Singleton();
        this.singleton = s;
        singleton.print();
    }
}
