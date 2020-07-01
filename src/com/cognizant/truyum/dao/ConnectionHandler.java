package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties"));
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("connection-url");
		String user = prop.getProperty("user");
		String pwd = prop.getProperty("password");
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pwd);
		return con;
	}
}
