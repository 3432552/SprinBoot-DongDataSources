package com.example.demo.datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Autowired
    @Qualifier("ReadDataSource")   //获取读的数据源
    private DataSource ReadDataSource;

    @Autowired
    @Qualifier("WriteDataSource")  //获取写的数据源
    private DataSource WriteDataSource;

    /**
     * 这个是主要的方法,从多个数据源里获得用户想走的数据源
     */
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("此时使用的数据源:============>" + DataSourceContextHolder.getDbType());
        return DataSourceContextHolder.getDbType();
    }

    /**
     * 配置数据源信息   注册数据源的操作 最终注入到datasource数据源中
     */
    @Override
    public void afterPropertiesSet() {
        Map<Object, Object> map = new HashMap<>();
        map.put("ReadDataSource", ReadDataSource);
        map.put("WriteDataSource", WriteDataSource);
        setTargetDataSources(map);
        setDefaultTargetDataSource(WriteDataSource);
        super.afterPropertiesSet();
    }

}
