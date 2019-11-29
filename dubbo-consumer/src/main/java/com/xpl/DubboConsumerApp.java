package com.xpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ImportResource(value = {"classpath:com/xpl/framework/config/spring-dubbo.xml"})
@EnableTransactionManagement
@SpringBootApplication
public class DubboConsumerApp {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(DubboConsumerApp.class, args);
        //随项目启动的方法
        ac.getBean(com.xpl.web.timer.SystemTimer.class).speak();
    }

}
