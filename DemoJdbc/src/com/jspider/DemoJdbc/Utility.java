package com.jspider.DemoJdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Utility {

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
