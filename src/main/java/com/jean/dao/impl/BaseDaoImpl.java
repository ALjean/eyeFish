package com.jean.dao.impl;

import com.jean.DaoDfmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by stas on 30.05.15.
 */
@Repository
public class BaseDaoImpl {

    private static final Logger log = Logger.getLogger(BaseDaoImpl.class);


    @Autowired
    private DataSource basicDataSource;

    private Connection connection;

    protected Connection getConnection() throws DaoDfmException {

        try {

            if (connection == null || connection.isClosed()) {
                connection = basicDataSource.getConnection();
                connection.setAutoCommit(false);
            }

        } catch (SQLException e) {
            log.error("No connection to base", e);
            throw new DaoDfmException("No connection to base", e);
        }


        return connection;
    }

    protected void closeConnection(Connection connection) throws DaoDfmException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Can't close connection ", e);
                throw new DaoDfmException("Can't close connection ", e);
            }
        }

    }

    protected void closePreparedStatement(PreparedStatement statement) throws DaoDfmException {

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                log.error("Can't close statement ", e);
                throw new DaoDfmException("Can't close statement ", e);
            }
        }
    }

    protected void rollback(Connection connection) throws DaoDfmException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            log.error("Error rollback ", e);
            throw new DaoDfmException("Error rollback ", e);
        }
    }

    protected int getGeneratedKey(Statement preparedStatement) throws DaoDfmException {
        int result;
        try {
            ResultSet keySet = preparedStatement.getGeneratedKeys();
            keySet.next();
            result = keySet.getInt(1);
        } catch (SQLException e) {
            log.error("Can't return genKey ", e);
            throw new DaoDfmException("Can't return genKey ", e);
        }

        return result;

    }
}
