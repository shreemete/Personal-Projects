<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%
String email=request.getParameter("email");
String pass=request.getParameter("pass");
session.setAttribute("email", email);
session.setAttribute("pass", pass);
if(email.equals("achievers@gmail.com") && pass.equals("admin")){
	session.setAttribute("status", "login");
	response.sendRedirect("home.jsp");
}
else{
		%>
		<script>
		alert("Enter valid email and password");
		location.href="index.jsp";
		</script>
		<%
	 }
%>
</body>
</html>