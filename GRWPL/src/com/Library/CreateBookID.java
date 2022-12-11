package com.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateBookID {
	int id;
	String sid="Bk";
	public CreateBookID() {
		// TODO Auto-generated constructor stub
		try {
			Connection con = Connector.getCon();
			String q1 ="select COUNT(book_id) from book_details;";
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			ResultSet rs1=pstmt1.executeQuery();
			rs1.next();
			id = rs1.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("aye mi ith ahe");
		}
	}
	
	public String bookID(){
		id+=1;
		int l= String.valueOf(id).length();
		
		for (int i =5;i>l;i--) {
			sid=sid+"0";
		}
		sid=sid+String.valueOf(id);
		
		return sid;
	}
	/*
	public String AddedDate() {
		
		return "";
	}*/
	
}















