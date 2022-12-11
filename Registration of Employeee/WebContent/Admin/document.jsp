<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.action.MakeFolder"%>
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
		response.sendRedirect("home.jsp");
	}
%>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/document1.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <title>Ingenious</title>
	<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
	<%
	String id = session.getAttribute("id").toString();
	String email = session.getAttribute("email").toString();
	
	String email1="";
	String pass="";
	try{
 	email1=session.getAttribute("email").toString();
	pass=session.getAttribute("pass").toString();
	}
	catch(Exception e){
		
	}
	//System.out.println("email : "+email+" id: "+id);
	MakeFolder mk = new MakeFolder();
	mk.folder(id);
	//session.setAttribute("id",id);
	%>
    <div class="container">
        <h1>Upload Documents</h1>
        <form action="../upload" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="emp_id" value="<%out.print(id);%>"/>
            <div class="box box1">
                <p>SSC Marksheet</p>
                <input type="file" name="ssc" class="upload-box">
            </div>
            <div class="box box2">
                <p>HSC Marksheet</p>
                <input type="file" name="hsc" class="upload-box">
            </div>
            <div class="box box3">
                <p>Graduation Certificate</p>
                <input type="file" name="grad" class="upload-box">
            </div>
            <div class="box box4">
                <p>Resume</p>
                <input type="file" name="resume" class="upload-box">
            </div>
            <div class="box box5">
                <p>Employee Photo</p>
                <input type="file" name="photo" class="upload-box">
            </div>
            <div class="box box6">
                <p>Employee Signature</p>
                <input type="file" name="sign" class="upload-box">
            </div>
            <div class="btn">
                <input type="submit" value="Save and Submit">
            </div>
        </form>
    </div>
    <div class="back">
            <a href="registration1.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
    </div>
    
</body>
</html>