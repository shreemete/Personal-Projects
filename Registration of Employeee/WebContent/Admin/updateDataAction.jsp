<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<%
int id = Integer.parseInt(request.getParameter("emp_id"));
String name = request.getParameter("emp_name");
String email = request.getParameter("emp_email");
String contact = request.getParameter("emp_contact");
String joiningDate = request.getParameter("emp_join_date");
String designation = request.getParameter("emp_designation");
String blood_group = request.getParameter("emp_blood");
try{
	Connection con = Connector.getCon();
	String q="update emp_info set name=?,email=?,contact=?,date_of_joining=?,designation=?,blood_group=? where id =?";
	PreparedStatement pstmt = con.prepareStatement(q);
	
	pstmt.setString(1,name);
	pstmt.setString(2,email);
	pstmt.setString(3,contact);
	pstmt.setString(4,joiningDate);
	pstmt.setString(5,designation);
	pstmt.setString(6,blood_group);
	pstmt.setInt(7,id);
	
	pstmt.executeUpdate();
	response.sendRedirect("employeeDetails.jsp");
}catch(Exception e){
	System.out.println(e);
	response.sendRedirect("updateData.jsp?id="+id);
}

%>