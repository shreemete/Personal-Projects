package com.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddBookDB {

	public String bookID,bookName,authorName,bookEdition,dept,quantity,date;
	
	public AddBookDB(String bookID,String bookName,String authorName,String bookEdition,String dept,String quantity,String date) {
		// TODO Auto-generated constructor stub
		this.bookID=bookID;
		this.bookName=bookName;
		this.authorName=authorName;
		this.bookEdition=bookEdition;
		this.dept=dept;
		this.quantity=quantity;
		this.date=date;
	}
	
	public boolean insertedDB() {
		boolean f = false;
		
		try {
			Connection con = Connector.getCon();
			String q ="insert into book_details(book_id,book_name,book_author,book_edition,department,quantity,added_date) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, bookID);
			pstmt.setString(2, bookName);
			pstmt.setString(3, authorName);
			pstmt.setString(4, bookEdition);
			pstmt.setString(5, dept);
			pstmt.setInt(6, Integer.parseInt(quantity));
			pstmt.setString(7, date);
			//pstmt.setString(1, bookID);
			pstmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("aye mi ith ahe");
		}
		
		return f;
	}
	
}
