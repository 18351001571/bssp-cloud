package com.cloud.bssp.designpatterns.Decorator;

import com.cloud.bssp.BsspUserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * test
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BsspUserApplication.class)
public class TestDemo {

    @Test
    public void testDemo() {

        Dolls dolls = new Dolls(10);
        System.out.println("原套娃大小：" + dolls.getSize());
        SmallDecorator smallDecorator = new SmallDecorator(dolls);
        smallDecorator.configSize();
        System.out.println("SmallDecorator装饰后套娃大小：" + dolls.getSize());
        MiddleDecorator middleDecorator = new MiddleDecorator(dolls);
        middleDecorator.configSize();
        System.out.println("MiddleDecorator装饰后套娃大小：" + dolls.getSize());
    }

}
