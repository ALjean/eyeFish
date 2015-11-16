package com.jean.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



/**
 * Created by Stas on 28.06.15.
 */
@Component
@Scope("singleton")
public class PoolConnectionFactory {

    @Autowired
    private BasicDataSource basicDataSource;

    public BasicDataSource getBds() {
        return basicDataSource;
    }




}
