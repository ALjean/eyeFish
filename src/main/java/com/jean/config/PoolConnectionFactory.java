package com.jean.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * Created by Stas on 28.06.15.
 */
@Component
@Scope("singleton")
public class PoolConnectionFactory {

    @Autowired
    private DataSource basicDataSource;

    public DataSource getBds() {
        return basicDataSource;
    }




}
