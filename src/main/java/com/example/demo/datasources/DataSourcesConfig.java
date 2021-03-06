package com.example.demo.datasources;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourcesConfig {
    // 创建可读数据源
    @Bean(name = "ReadDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.read") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }
    // 创建可写数据源
    @Bean(name = "WriteDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.write") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

}
