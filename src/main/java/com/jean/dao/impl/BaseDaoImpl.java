package com.jean.dao.impl;

import com.jean.config.PoolConnectionFactory;
import com.jean.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by stas on 30.05.15.
 */
@Component
public class BaseDaoImpl implements BaseDao {


    @Autowired
    @Qualifier("getConnectionFactory")
    private PoolConnectionFactory connectionFactory;

    protected Connection getConnection() throws SQLException {
        return connectionFactory.getBds().getConnection();
    }



}
