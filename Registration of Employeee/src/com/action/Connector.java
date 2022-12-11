package com.action;
import java.sql.*;
public class Connector {
	public static Connection getCon() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
		
	}
}