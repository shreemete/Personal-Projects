package com.Library;
import java.sql.*;
public class Connector {
	
	
	public static Connection getCon() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
