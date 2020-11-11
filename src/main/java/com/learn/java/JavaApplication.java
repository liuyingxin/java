package com.learn.java;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.spring4all.swagger.EnableSwagger2Doc;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@MapperScan("com.learn.java.mapper")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableSwagger2Doc
@EnableScheduling
@EnableConfigurationProperties

public class JavaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(JavaApplication.class)
                .main(JavaApplication.class)
                .run(args);
        context.registerShutdownHook();

        log.info("==================================");
        log.info("xinFinance Server startup");
        log.info("==================================");
    }

}
