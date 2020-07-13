package com.cloud.bssp.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;
import java.util.List;
import java.util.logging.Filter;

@SpringBootTest
class BsspAuthServiceApplicationTests {

    @Autowired
    private List<Filter> filterList;

    @Test
    void contextLoads() {
        System.out.println("11111111");
    }

}
