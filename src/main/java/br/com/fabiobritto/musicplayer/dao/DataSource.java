package br.com.fabiobritto.musicplayer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	private String hostname;
	private String username;
	private String password;
	private String database;
	private Connection connection;
	
	public DataSource() {
		try {
			hostname = "localhost";
			database = "musicplayer";
			username = "musicplayer";
			password = "f@bi0";
			String URL = "jdbc:mysql://" + hostname + ":3306/" + database;
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			connection = DriverManager.getConnection(URL, username, password);
		}
		catch(SQLException e) {
			System.out.println("ERRO AO CONECTAR SQL: " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}
