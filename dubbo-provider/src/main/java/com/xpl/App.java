package com.xpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.xpl.dao")
@ImportResource(value = {"classpath:com/xpl/framework/config/spring-dubbo.xml"})
@EnableTransactionManagement
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(App.class, args);
    }

}
