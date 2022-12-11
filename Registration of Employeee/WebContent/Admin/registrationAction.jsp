<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<%
	int id = Integer.parseInt(request.getParameter("emp_id"));

String name = request.getParameter("emp_name");
String email = request.getParameter("emp_email");
String contact = request.getParameter("emp_contact");
String joiningDate = request.getParameter("emp_join_date");
String designation = request.getParameter("emp_designation");
String city = request.getParameter("emp_city");
String blood_group = request.getParameter("emp_blood");
try{
	Connection con = Connector.getCon();
	String q="insert into emp_info values (?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(q);
	pstmt.setInt(1,id);
	pstmt.setString(2,name);
	pstmt.setString(3,email);
	pstmt.setString(4,contact);
	pstmt.setString(5,joiningDate);
	pstmt.setString(6,designation);
	pstmt.setString(7,city);
	pstmt.setString(8,blood_group);
	
	pstmt.executeUpdate();
	session.setAttribute("email", email);
	session.setAttribute("id", id);
	response.sendRedirect("document.jsp");
	
	
}catch(Exception e){
	%>
	<script>
		alert("Regisration Failed");
		location.href="registration1.jsp";
	</script>
	<%
	
}

%>