package com.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LibrarianDb {
	String name;
	String email;
	String mobile;
	String address;
	String pass;
	public LibrarianDb(String name1, String email1,String mobile1,String address1,String pass1) {
		name=name1;
		email=email1;
		mobile=mobile1;
		address=address1;
		pass=pass1;
		
	}
	public boolean insertLib() {
		boolean f=false;
		try {
			
			Connection con= Connector.getCon();
			String q ="insert into librarian_table(name,email,mobile,address,pass) values(?,?,?,?,?)";
			
			PreparedStatement pstmt =con.prepareStatement(q);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3,mobile);
			pstmt.setString(4, address);
		 	pstmt.setString(5, pass);
			pstmt.executeUpdate();
			f=true;
		} 
		catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		return f;
	}
	
}
