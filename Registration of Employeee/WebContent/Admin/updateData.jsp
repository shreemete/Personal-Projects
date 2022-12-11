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
	if(!s.equals("login")){
		response.sendRedirect("home.jsp");
	}
%>
<meta charset="ISO-8859-1">
<title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
<link rel="stylesheet" href="../CSS/updateData1.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body>
<%


	int id=Integer.parseInt(request.getParameter("id"));
	String email1 =session.getAttribute("email").toString();
	String pass =session.getAttribute("pass").toString();
	//System.out.println(id);
	Connection con = Connector.getCon();
	Statement st= con.createStatement();
	ResultSet rs=st.executeQuery("select * from emp_info  where id="+id+" order by id;");
	
	rs.next();
		
	
%>
<div class="register">
<h1>Update Employee Details</h1>
<div class="box">
<form action="updateDataAction.jsp" method="get">
	<input type="hidden" name="emp_id" value="<%=id%>"/>	
	<div class="hover">
		<p>Employe Name</p>
		<input type="text" name="emp_name" class="form__input" value="<%=rs.getString(2) %>"/>
		

	</div>
	<div class="hover">
		<p>Employe Email</p>
		<input type="email" name="emp_email" class="form__input" value="<%=rs.getString(3) %>"/>
		

	</div>
	<div class="hover">
		<p>Employe Contact</p>
		<input type="text" name="emp_contact" class="form__input" value="<%=rs.getString(4) %>"/>
		

	</div>
	<div class="hover">
		<p>Date of Joining</p>
		<input type="date" name="emp_join_date" class="form__input" value="<%=rs.getString(5) %>"/>
		

	</div>
	<div class="hover">
		<p>Designation</p>
		<input type="text" name="emp_designation" class="form__input" value="<%=rs.getString(6) %>"/>
		

	</div>
	<div class="hover">
		<p>Blood Group</p>
		<input type="text" name="emp_blood" class="form__input" value="<%=rs.getString(8) %>"/>
		

	</div>
	<div class="btn green">
		<input type="submit" value="Save" />
	</div>
	<!-- <div class="btn red">
		<input type="reset" value="Reset" />
	</div> -->
	
</form>
</div>
</div>
<div class="back">
            <a href="employeeDetails.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
</div>
<%

String msg = request.getParameter("msg");
if("done".equals(msg)){
%>
<script type="text/javascript">
alert("Data Added Successfully");
</script>
<%
}
%>
</body>
</html>