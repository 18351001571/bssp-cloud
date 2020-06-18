package com.cloud.bssp.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BsspGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsspGeneratorApplication.class, args);
    }

}
