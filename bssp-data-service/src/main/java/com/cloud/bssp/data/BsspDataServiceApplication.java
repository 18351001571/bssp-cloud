package com.cloud.bssp.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @description: 数据服务启动类
 *
 * 注解@ServletComponentScan： 使Servlet，filter，listener 可以通过 @WebServlet,@WebFilter,@WebListener
 *                            等注解直接注册，无需其他代码
 * @author weirx
 * @date 2020/6/17
 */
@SpringBootApplication
@ServletComponentScan
public class BsspDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsspDataServiceApplication.class, args);
    }

}
