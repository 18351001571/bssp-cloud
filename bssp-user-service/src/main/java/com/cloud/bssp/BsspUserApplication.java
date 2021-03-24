package com.cloud.bssp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author weirx
 */
@SpringBootApplication
@ComponentScan(value = "com.cloud.bssp.user")
public class BsspUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsspUserApplication.class, args);
    }

}
