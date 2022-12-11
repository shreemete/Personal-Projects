<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<%
	String s=null;
	String status="";
	try{
		status=session.getAttribute("status").toString();
		s=status;
	}catch(Exception e){
		s="";
	}
	if(!s.equals(status)){
		response.sendRedirect("index.jsp");
	}
%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/dataFetch.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

<title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%


int id=Integer.parseInt(request.getParameter("id"));
String email =session.getAttribute("email").toString();
String pass =session.getAttribute("pass").toString();
	Connection con = Connector.getCon();
	Statement st= con.createStatement();
	ResultSet rs=st.executeQuery("select * from emp_doc   where id="+id+" order by id;");
	
	rs.next();
%>  <div class="container">
    <h1 class="title">Documents</h1>
    <h2>Employee ID : <%=id %></h2>
    <div class="content">
    <div class="box ssc">
        <h1>SSC Marksheet</h1>
        <a href=".\files\<%=id%>\<%=rs.getString(2) %>" target="_blank">View</a>
    </div>
    
    <div class="box hsc">
        <h1>HSC Marksheet</h1>
        <a href=".\files\<%=id%>\<%=rs.getString(3) %>" target="_blank">View</a>
    </div>
    <div class="box grad">
        <h1>Graduation Certificate</h1>
        <a href=".\files\<%=id%>\<%=rs.getString(4) %>" target="_blank">View</a>
    </div>
    <div class="box resume">
        <h1>Resume</h1>
        <a href=".\files\<%=id%>\<%=rs.getString(5) %>" target="_blank">View</a>
    </div>
    <div class="box photo">
        <h1>Photo</h1>
        <a href=".\files\<%=id%>\<%=rs.getString(6) %>" target="_blank">View</a>
    </div>
    <div class="box sign">
        <h1>Signature</h1>
        <a href=".\files\<%=id%>\<%=rs.getString(7) %>" target="_blank">View</a>
    </div>
</div>
<div class="back">
    <a href="employeeDetails.jsp">
        <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
        <span>Back</span>
    </a>
</div>
<div class="update">
    <a href="updateDocument1.jsp">Document Update</a>
</div>
</div>

</body>
</html>