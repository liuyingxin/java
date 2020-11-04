package com.learn.java;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.learn.java.*")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class JavaApplication {

    public static void main(String[] args) {
        System.out.println("开始了");
        SpringApplication.run(JavaApplication.class, args);
        System.out.println("成功了");
    }

}
