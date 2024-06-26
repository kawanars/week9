package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {

	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		
		try {
			Connection conn;
			conn = DriverManager.getConnection(url);
			System.out.println("Connected!");
			System.out.println("Connection to schema " + SCHEMA + " done");

			return conn;
			
		} catch (SQLException e) {
			System.out.println("Unable to get connection: " + url);
			throw new DbException(e);
		}
	}
		
	}