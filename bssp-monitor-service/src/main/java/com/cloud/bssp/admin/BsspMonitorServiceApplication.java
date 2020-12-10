package com.cloud.bssp.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
@EnableAdminServer
@EnableDiscoveryClient
public class BsspMonitorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsspMonitorServiceApplication.class, args);
    }

}
