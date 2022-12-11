<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<%@	page import="com.action.Connector" %>
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
<link rel="stylesheet" href="../CSS/registration1.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script src="sweetalert/sweetalert.min.js"></script>
</head>
<body>
<%

String email =session.getAttribute("email").toString();
String pass =session.getAttribute("pass").toString();

%>
<div class="register" >
<h1>Employee Registration</h1>
<div class="box">
<form action="registrationAction.jsp" method="post">
	<%
		
		int id=1;
		int temp=0;
		try{
			Connection con = Connector.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select max(id) from emp_info");
			while(rs.next()){
				id=rs.getInt(1);
				temp=id;
				id+=1;
			}
		}catch(Exception e){
			
		}
		 %>
				
	
	<input type="hidden" name="emp_id" value="<%=id%>"/>
	
	<div class="hover">
		<input type="text" name="emp_name" class="form__input" placeholder=" " required/>
		<p>Employee Name</p>

	</div>
	<div class="hover">
		<input type="email" name="emp_email" class="form__input" placeholder=" "  required/>
		<p>Employee Email</p>

	</div>
	<div class="hover">
		<input type="text" name="emp_contact" class="form__input" placeholder=" " required/>
		<p>Employee Contact</p>

	</div>
	<div class="hover">
		<input type="date" name="emp_join_date" class="form__input" placeholder=" " required/>
		<p>Date of Joining</p>

	</div>
	<div class="hover">
		<input type="text" name="emp_designation" class="form__input" placeholder=" " required/>
		<p>Designation</p>

	</div>
	<div class="hover">
		<input type="text" name="emp_city" class="form__input" placeholder=" " required/>
		<p>Employee City</p>

	</div>
	<div class="hover">
		<input type="text" name="emp_blood" class="form__input" placeholder=" " required/>
		<p>Blood Group</p>

	</div>
	<div class="btn green">
		<input type="submit" value="Next" />
	</div>
	<div class="btn red">
		<input type="reset" value="Reset" />
	</div>
	
</form>
</div>

</div>
<div class="back">
            <a href="home.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
        </div>
<%
String msg = request.getParameter("msg");
if("done".equals(msg)){
	
	session.setAttribute("id", temp);
%>
<script type="text/javascript">
location.href="document.jsp";
</script>
<%
}
%>


</body>
</html>