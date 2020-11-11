package com.learn.java;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.learn.java.*")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@Slf4j
public class JavaApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaApplication.class, args);
        log.info("==================================");
        log.info("JavaApplication Server startup");
        log.info("==================================");

    }

}
