package com.xiyuan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 启动类
 *
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = "com.*")
@EnableAspectJAutoProxy(proxyTargetClass = true)//开启对切面的支持
public class RpcClientApp extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RpcClientApp.class);
    }

    /**
     * 项目的启动方法
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(RpcClientApp.class, args);
        log.info("======服务已经启动========");
    }
}
