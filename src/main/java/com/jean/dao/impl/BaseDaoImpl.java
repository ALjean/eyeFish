package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.config.PoolConnectionFactory;
import com.jean.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by stas on 30.05.15.
 */
@Component
public class BaseDaoImpl implements BaseDao {


    @Autowired
    @Qualifier("getConnectionFactory")
    private PoolConnectionFactory connectionFactory;

    private Connection connection;


    protected Connection getConnection() throws DaoDfmException {
        if (connection == null) {

            try {
                connection = connectionFactory.getBds().getConnection();
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw  new DaoDfmException("No connection to base", e);
            }


        }
        return connection;
    }

    protected void closeConnection(Connection connection) throws DaoDfmException {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DaoDfmException("Can't close connection ", e);
            }
        }

    }

    protected void closePreparedStatement(PreparedStatement statement) throws DaoDfmException {

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DaoDfmException("Can't close statement ", e);
            }
        }
    }

    protected void rollback(Connection connection) throws DaoDfmException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DaoDfmException("Error rollback ", e);
        }
    }


}
