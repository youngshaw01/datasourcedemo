package com.youngshaw.datasourcedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 在所有涉及到的SpringApplication配置类上取消dataSource的自动配置
 */
//在SpringBootApplication标签后加上exclude
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

@MapperScan(basePackages = "com.younghsaw.datasourcedemo.dao")
public class DatasourcedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourcedemoApplication.class, args);
    }

}
