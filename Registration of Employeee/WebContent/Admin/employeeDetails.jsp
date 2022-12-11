<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
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
	if(!s.equals("login")){
		response.sendRedirect("index.jsp");
	}
%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/employeeDetails1.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%


String email1 =session.getAttribute("email").toString();
String pass =session.getAttribute("pass").toString();
%>
    <header>
        <div class="logo">
          Acheivers Academy
        </div>
    </header>
    <div class="container">
        <h1>Employee Details</h1>

        <div class="content">
            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Date of Joining</th>
                    
                    <th>Documents</th>
                    <th style="width:100px">Action</th>
                    <th style="width:100px">Projects</th>
                </tr>
            </thead>
            
            <tbody>
<%
	
	
	
	Connection con = Connector.getCon();
	Statement st= con.createStatement();
	ResultSet rs=st.executeQuery("select * from emp_info order by id");
	while(rs.next()){
		
	
		%>	
                <tr>
                    <td><%=rs.getInt(1) %></td>
                    <td><%=rs.getString(2) %></td>
                    <td><%=rs.getString(3) %></td>
                    <td><%=rs.getString(4) %></td>
                    <td><%=rs.getString(5) %></td>
                    
                    <td><a href="dataFetch.jsp?id=<%=rs.getInt(1)%>">Documents</a></td>
                    <td><a href="updateData.jsp?id=<%=rs.getInt(1)%>">Update</a></td>
                    <td><a href="project1.jsp?id=<%=rs.getInt(1)%>">Project</a></td>
                </tr>
<%
}
%>
              </tbody>
            </table>
        </div>
        
    </div>
    <div class="back">
            <a href="home.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
    </div>
    
</body>
</html>