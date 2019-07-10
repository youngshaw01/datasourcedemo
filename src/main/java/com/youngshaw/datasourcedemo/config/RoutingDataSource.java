package com.youngshaw.datasourcedemo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/***
 * 获取路由
 */
public class RoutingDataSource  extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
