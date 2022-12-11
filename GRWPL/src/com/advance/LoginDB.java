package com.advance;

import java.sql.*;

public class LoginDB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classdb", "root", "root");
		
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery("select * from stud_details where name=\"pratiksha\";");
		
		while(rs.next()) {
			System.out.println("name ="+rs.getString(1) );
			System.out.println("roll no ="+rs.getInt(2) );
			System.out.println("mobile ="+rs.getString(3) );
			System.out.println("class ="+rs.getString(4) );
		}
		con.close();
	}
}
