package com.cloud.bssp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 * @author weirx
 */
@SpringBootApplication
public class BsspGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsspGatewayApplication.class, args);
    }

}
