<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<%@	page import="com.action.Connector" %>
<%	

	
	
	
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	try{

		Connection con = Connector.getCon();
		String sql="select * from emp_info where email=? and contact=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		
		rs.next();
			session.setAttribute("emp_name", rs.getString(2));
			session.setAttribute("status","status");
			session.setAttribute("emp_id", rs.getString(1));
		%>
		<script>
		location.href="searchPage.jsp";
		</script>
		
		<%
		}
		catch(Exception e){ %>
		<script>
		alert("Enter correct email and password.");
		location.href="signIn.jsp";
		</script>
		<%
		}
		%>