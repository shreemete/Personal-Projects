package com.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssuedBookDB {

	String enroll,issuedbook;
	int issb;
	public IssuedBookDB(String enroll, String issuedbook, int issb) {
		this.enroll=enroll;
		this.issuedbook=issuedbook;
		this.issb=issb;
	}

	public boolean insertedDB() {
		boolean f=false;
		try {
			Connection con= Connector.getCon();
			String q="select count(enroll) from issuebook where enroll=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, enroll);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int a = rs.getInt(1);
			if(a==0) {
				String q1 ="insert into issuebook (enroll,issuedbook1,date1,action1,due_date1,due) values(?,?,?,?,?,?)";
				PreparedStatement pstmt1 = con.prepareStatement(q1);
				pstmt1.setString(1, enroll);
				pstmt1.setString(2, issuedbook);
				long millis=System.currentTimeMillis();  
				java.sql.Date date = new java.sql.Date(millis);
				//
				pstmt1.setString(3, String.valueOf(date));
				pstmt1.setString(4, "issued");
				
				java.sql.Date date1 = new java.sql.Date(millis+604800000); 
				//String.valueOf(date1)
				pstmt1.setString(5, String.valueOf(date1));
				
				pstmt1.setInt(6, 0);
				pstmt1.executeUpdate();
				f=quantityDB();/*
				System.out.println(f);*/
				
			}else {
				String q1=null;;
				if(issb==0) {
				q1 ="update issuebook set issuedbook1=?,date1=?,action1=?,due_date1=? where enroll=?";
				}else {
					q1 ="update issuebook set issuedbook2=?,date2=?,action2=?,due_date2=? where enroll=?";
				}
				PreparedStatement pstmt1 = con.prepareStatement(q1);
				pstmt1.setString(1, issuedbook);
				long millis=System.currentTimeMillis();  
				java.sql.Date date = new java.sql.Date(millis); 
				pstmt1.setString(2, String.valueOf(date));
				pstmt1.setString(3, "issued");
				
				java.sql.Date date1 = new java.sql.Date(millis+604800000); 
				pstmt1.setString(4, String.valueOf(date1));
				
				pstmt1.setString(5, enroll);
				pstmt1.executeUpdate();
				f=quantityDB();/*
				System.out.println(f);*/
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();/*
			System.out.println("aye mi ith ahe");*/
		}
		return f;
	}

	private boolean quantityDB() {
		try {
			Connection con= Connector.getCon();
			String q1 ="select quantity from book_details where book_id=?;";
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			pstmt1.setString(1, this.issuedbook);
			ResultSet rs1 = pstmt1.executeQuery();
			rs1.next();
			int qt=rs1.getInt(1);
			/*System.out.println(qt-1);*/
			String q="update book_details set quantity=? where book_id=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1,qt-1);
			pstmt.setString(2, issuedbook);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}
