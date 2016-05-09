package com.jean.dao.impl;

import com.jean.DaoDfmException;
import com.jean.config.PoolConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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

	@Autowired
	@Qualifier("getConnectionFactory")
	private PoolConnectionFactory connectionFactory;

	private Connection connection;

	protected Connection getConnection() throws DaoDfmException {
		try {
			if (connection == null || connection.isClosed()) {

				try {
					connection = connectionFactory.getBds().getConnection();
					connection.setAutoCommit(false);
				} catch (SQLException e) {
					throw new DaoDfmException("No connection to base", e);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	protected void closeConnection(Connection connection) throws DaoDfmException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DaoDfmException("Can't close connection ", e);
			}
		}

	}

	protected void closePreparedStatement(PreparedStatement statement) throws DaoDfmException {

		if (statement != null) {
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

	protected int getGeneratedKey(Statement preparedStatement) throws DaoDfmException {
		int result = 0;
		try {
			ResultSet keySet = preparedStatement.getGeneratedKeys();
			keySet.next();
			result = keySet.getInt(1);
		} catch (SQLException e) {
			throw new DaoDfmException("Can't return genKey ", e);
		}

		return result;

	}
}
