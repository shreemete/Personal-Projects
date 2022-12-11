package com.Library;

import java.sql.*;

public class total {
	
	public long student ,book,issued=0,returned=0;
	public total() {
		try {
			Connection con = Connector.getCon();
			String q = "select count(enroll) from student_details;";
			PreparedStatement pstmt = con.prepareStatement(q);
			ResultSet rs= pstmt.executeQuery();
			rs.next();
			student=rs.getLong(1);
			
			String q1 = "select sum(quantity) from book_details;";
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			ResultSet rs1= pstmt1.executeQuery();
			rs1.next();
			book=rs1.getLong(1);
			
			String q2 = "select count(enroll) from issuebook where action1='issued' ;";
			PreparedStatement pstmt2 = con.prepareStatement(q2);
			ResultSet rs2= pstmt2.executeQuery();
			if(rs2.next()) {
				issued+=rs2.getLong(1);
			}
			String q3 = "select count(enroll) from issuebook where action2='issued' ;";
			PreparedStatement pstmt3 = con.prepareStatement(q3);
			ResultSet rs3= pstmt3.executeQuery();
			if(rs3.next()) {
				issued+=rs3.getLong(1);
			}
			
			String q4= "select count(enroll) from issuebook where action1='return' ;";
			PreparedStatement pstmt4 = con.prepareStatement(q4);
			ResultSet rs4= pstmt4.executeQuery();
			if(rs4.next()) {
				returned+=rs4.getLong(1);
			}
			
			String q5 = "select count(enroll) from issuebook where action2='return' ;";
			PreparedStatement pstmt5 = con.prepareStatement(q5);
			ResultSet rs5= pstmt5.executeQuery();
			if(rs5.next()) {
				returned+=rs5.getLong(1);
			}
			
			/*String q3 = "select count(enroll) from student_details;";
			PreparedStatement pstmt3 = con.prepareStatement(q3);
			ResultSet rs3= pstmt3.executeQuery();
			rs3.next();
			returned=rs3.getLong(1);*/
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
