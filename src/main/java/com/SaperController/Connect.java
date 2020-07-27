package com.SaperController;

import java.sql.*;

public class Connect {
	
	private static String URL = "jdbc:postgresql:Ranking";
	private static String user = "postgres";
	private static String password = "SQLdata";
	
	public static Connection connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
