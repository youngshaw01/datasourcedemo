package com.youngshaw.datasourcedemo.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * 配置4个数据源
 * 1个master  写数据源
 * 2个slave 读数据源
 * 1个routing 路由数据源
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.master")
    public DataSource masterDataSource() {
//        return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.slave1")
    public DataSource slave1DataSource() {
//        return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.slave2")
    public DataSource slave2DataSource() {
//        return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }

    // Primary 在自动注入时优先使用（Qualifier指定注入）
    @Bean
    @Primary
    public DataSource routingDataSource(
            @Qualifier("masterDataSource") DataSource masterDataSource,
            @Qualifier("slave1DataSource") DataSource slave1DataSource,
            @Qualifier("slave2DataSource") DataSource slave2DataSource
    ) {
        HashMap<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE1, slave1DataSource);
        targetDataSources.put(DBTypeEnum.SLAVE2, slave2DataSource);
        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(masterDataSource);
        routingDataSource.setTargetDataSources(targetDataSources);
        return routingDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource routingDataSource){
        return new DataSourceTransactionManager(routingDataSource);
    }
}
