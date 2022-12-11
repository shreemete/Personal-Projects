package com.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddStudentDB {
	String enrollID,  StdName,  StdRoll,  StdMobile,  StdEmail,  StdDep, StdClass,  addDate;
	public AddStudentDB(String enrollID, String StdName, String StdRoll, String StdMobile, String StdEmail, String StdDep,
			String StdClass, String addDate) {
		// TODO Auto-generated constructor stub
		this.enrollID=enrollID;
		this.StdName=StdName;
		this.StdRoll=StdRoll;
		this.StdMobile=StdMobile;
		this.StdEmail=StdEmail;
		this.StdDep=StdDep;
		this.StdClass=StdClass;
		this.addDate=addDate;
	}

	public boolean insertedDB() {
		// TODO Auto-generated method stub
boolean f = false;
		
		try {
			Connection con = Connector.getCon();
			String q ="insert into student_details(enroll,name,rollno,mobile,email,department,class,addDate) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, enrollID);
			pstmt.setString(2, StdName);
			pstmt.setString(3, StdRoll);
			pstmt.setString(4, StdMobile);
			pstmt.setString(5, StdEmail);
			pstmt.setString(6, StdDep);
			pstmt.setString(7, StdClass);
			pstmt.setString(8, addDate);
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
