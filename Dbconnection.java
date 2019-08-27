package com.lms;

import java.sql.*;

public class Dbconnection {

	public static Connection connect;
	static Dbconnection get=new Dbconnection();

	public Connection connectDb() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "10decoders");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connect;
	}

}