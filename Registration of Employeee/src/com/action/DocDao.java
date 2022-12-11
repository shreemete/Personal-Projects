package com.action;

import com.action.Connector;
import com.action.Iterate;

import java.sql.*;
//Connection con = Connector.getCon();
public class DocDao {
	public static boolean insertStudentToDB(Iterate it) throws SQLException, ClassNotFoundException{
		boolean f = false;
		try {
			Connection con = Connector.getCon();
			String q ="insert into emp_doc(id,ssc,hsc,graduation,resume,photo,sign) values(?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt =con.prepareStatement(q);
			
			pstmt.setInt(1, it.getEmpId());
			pstmt.setString(2, it.al.get(0));
			pstmt.setString(3, it.al.get(1));
			pstmt.setString(4, it.al.get(2));
		 	pstmt.setString(5, it.al.get(3));
			pstmt.setString(6, it.al.get(4));
			pstmt.setString(7, it.al.get(5));
			
			
//			System.out.println(it.getAl().get(0));
			
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
