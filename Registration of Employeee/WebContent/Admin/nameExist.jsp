<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");

String email = request.getParameter("email");
String pass = request.getParameter("pass");
try{

	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");
	String sql="select * from emp_info inner join emp_doc where emp_info.id=emp_doc.id AND (emp_info.name like '%"+name+"%');";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	
	rs.next();
	session.setAttribute("name", rs.getString(2));
	session.setAttribute("email", email);
	session.setAttribute("pass", pass);
	%>
	<script>
	location.href="searchPage1.jsp";
	</script>
	
	<%
	
	
}catch(Exception e){
	%>
	<script>
	alert("Name doesn't exist...try again");
	location.href="home.jsp";
	</script>
	
	<%
}
%>
</body>
</html>