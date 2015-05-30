package com.jean.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by stas on 30.05.15.
 */
@Component
public class BaseDaoImpl {

    @Autowired
    protected JdbcTemplate jdbcTemplate;


}
