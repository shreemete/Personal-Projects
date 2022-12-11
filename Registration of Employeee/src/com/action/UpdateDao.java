package com.action;

import com.action.Connector;
import com.action.Iterate;

	import java.sql.*;
	//onnection con = Connector.getCon();
public class UpdateDao {
		public static boolean updateStudentToDB(Iterate it) throws SQLException, ClassNotFoundException{
			boolean f = false;
			try {
				Connection con = Connector.getCon();
				String q ="update emp_doc set "+Delete.column+"=? where id="+Delete.path_id;
				
				PreparedStatement pstmt =con.prepareStatement(q);
				pstmt.setString(1, it.al.get(0));
				
				
//				System.out.println(it.getAl().get(0));
				
				pstmt.executeUpdate();
				f=true;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
}

