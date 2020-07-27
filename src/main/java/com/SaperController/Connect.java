package com.SaperController;

import java.sql.*;

public class Connect {
	
	private static String URL = "jdbc:postgresql:RankingSaper.sql";
	private static String user = "postgres";
	private static String password = "postgres";
	
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
