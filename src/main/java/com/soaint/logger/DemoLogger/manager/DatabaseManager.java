package com.soaint.logger.DemoLogger.manager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.soaint.logger.DemoLogger.config.LoggerConfiguration;

public class DatabaseManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private static DatabaseManager instance = null;
	private LoggerConfiguration configuration;
	
	private DatabaseManager(LoggerConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public static synchronized DatabaseManager getInstance(LoggerConfiguration configuration) {
		if (instance == null) {
			instance = new DatabaseManager(configuration);
		}
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(configuration.getProperty("logger.bd.jdbcDriver"));
			String userName = configuration.getProperty("logger.bd.username");
			String password = configuration.getProperty("logger.bd.password");
			connection = DriverManager.getConnection(configuration.getProperty("logger.bd.dburl"), userName, password);
		} catch (SQLException e) {
			throw new RuntimeException("Error de conexion: ", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Error de conexion: ", e);
		}
		return connection;
	}
	
	public Statement getStatment(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException("Error de conexion: ", e);
		}
	}
	
	public void createLogTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = getStatment(connection);
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS LogRecord(message varchar(255), type int)");
		} catch (SQLException e) {
			throw new RuntimeException("Error de creacion de log: ", e);
		} finally {
			try {
				if (statement != null) {
	            	statement.close();
	            }
	            if (connection != null) {
	            	connection.close();
	            }
	        } catch (SQLException sqlException) {
	        	sqlException.printStackTrace();
	        }
		}
	}

	public void insertMessageBD(String message, int messageType) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = getStatment(connection);
			StringBuilder querySB = new StringBuilder();
			querySB.append("INSERT INTO LogRecord(message, type) VALUES('");
			querySB.append(message);
			querySB.append("', ");
			querySB.append(String.valueOf(messageType));
			querySB.append(")");
			statement.execute(querySB.toString());
		} catch (SQLException e) {
			throw new RuntimeException("Error de insercion: ", e);
		} finally {
			try {
				if (statement != null) {
	            	statement.close();
	            }
	            if (connection != null) {
	            	connection.close();
	            }
	        } catch (SQLException sqlException) {
	        	sqlException.printStackTrace();
	        }
		}
	}
	

}