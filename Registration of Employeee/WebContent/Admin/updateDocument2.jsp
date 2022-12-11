<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<%
String s=null;

try{
	 
	s=session.getAttribute("status").toString();
}catch(Exception e){
	
	s="";
}
if(!s.equals("login")){
	response.sendRedirect("../index.jsp");
}
%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/updateDocument1.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
String name =session.getAttribute("name").toString();
String email="";
String pass="";
try{

email = session.getAttribute("email").toString();
pass = session.getAttribute("pass").toString();
}catch(Exception e){
	
}
if(email==null && pass==null){
	try{
	email = session.getAttribute("email").toString();
	pass = session.getAttribute("pass").toString();
	}catch(Exception e){
		e.printStackTrace();
	}
}
	Connection con = Connector.getCon();
	Statement st= con.createStatement();
	ResultSet rs=st.executeQuery("select * from emp_doc   where id="+id+" order by id;");
	
	rs.next();
	String name1 = rs.getString(2);
	String name2 = rs.getString(3);
	String name3 = rs.getString(4);
	String name4 = rs.getString(5);
	String name5 = rs.getString(6);
	String name6 = rs.getString(7);
		
%>
    <h1>Update Documents</h1>
    <div class="container">
        
        <div>
            <a href="..\files\<%=id%>\<%=name1%>" target="_blank"><label for="">SSC Marksheet</label></a>
            <button id="show1">Upload</button>
        </div>
        <div>
            <a href="..\files\<%=id%>\<%=name2 %>" target="_blank"><label for="">HSC Marksheet</label></a>
            <button id="show2">Upload</button>
        </div>
        <div>
            <a href="..\files\<%=id%>\<%=name3 %>" target="_blank"><label for="">Graduation Certificate</label></a>
            <button id="show3">Upload</button>
        </div>
        <div>
            <a href="..\files\<%=id%>\<%=name4 %>" target="_blank"><label for="">Resume</label></a>
            <button id="show4">Upload</button>
        </div>
        <div>
            <a href="..\files\<%=id%>\<%=name5 %>" target="_blank"><label for="">Photo</label></a>
            <button id="show5">Upload</button>
        </div>
        <div>
            <a href="..\files\<%=id%>\<%=name6 %>" target="_blank"><label for="">Signature</label></a>
            <button id="show6">Upload</button>
        </div>
    </div>
    <div class="back">
            <a href="searchPage1.jsp?name=<%=name%>">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
    </div>
    <div class="content content1">
        <div class="close-btn">&times;</div>
        <form action="../updated2" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="emp_id" value="<%out.print(id);%>"/>
        	<%System.out.println(id); %>
        	<input type="hidden" name="file" value="<%=name1%>"/>
        	<input type="hidden" name="col" value="ssc"/>
            <label for="ssc">SSC Marksheet</label>
            <input type="file" name="ssc" id="form1-element">
            <input type="submit" value="Submit" id="sub1">
        </form>
    </div>
    <div class="content content2">
        <div class="close-btn">&times;</div>
        <form action="../updated2" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="emp_id" value="<%out.print(id);%>"/>
        	<input type="hidden" name="file" value="<%=rs.getString(3)%>"/>
        	<input type="hidden" name="col" value="hsc"/>
            <label for="ssc">HSC Marksheet</label>
            <input type="file" name="ssc" id="form2-element">
            <input type="submit" value="Submit" id="sub2">
        </form>
    </div>
    <div class="content content3">
        <div class="close-btn">&times;</div>
        <form action="../updated2" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="emp_id" value="<%out.print(id);%>"/>
        	<input type="hidden" name="file" value="<%=rs.getString(4)%>"/>
        	<input type="hidden" name="col" value="graduation"/>
            <label for="ssc">Graduation Certificate</label>
            <input type="file" name="ssc" id="form3-element">
            <input type="submit" value="Submit" id="sub3">
        </form>
    </div>
    <div class="content content4">
        <div class="close-btn">&times;</div>
        <form action="../updated2" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="emp_id" value="<%out.print(id);%>"/>
        	<input type="hidden" name="file" value="<%=rs.getString(5)%>"/>
        	<input type="hidden" name="col" value="resume"/>
            <label for="ssc">Resume</label>
            <input type="file" name="ssc" id="form4-element">
            <input type="submit" value="Submit" id="sub4">
        </form>
    </div>
    <div class="content content5">
        <div class="close-btn">&times;</div>
        <form action="../updated2" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="emp_id" value="<%out.print(id);%>"/>
        	<input type="hidden" name="file" value="<%=rs.getString(6)%>"/>
        	<input type="hidden" name="col" value="photo"/>
            <label for="ssc">Photo</label>
            <input type="file" name="ssc" id="form5-element">
            <input type="submit" value="Submit" id="sub5">
        </form>
    </div>
    <div class="content content6">
        <div class="close-btn">&times;</div>
        <form action="../updated2" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="emp_id" value="<%out.print(id);%>"/>
        	<input type="hidden" name="file" value="<%=rs.getString(7)%>"/>
        	<input type="hidden" name="col" value="sign"/>
            <label for="ssc">Signature</label>
            <input type="file" name="ssc" id="form6-element">
            <input type="submit" value="Submit" id="sub6">
        </form>
    </div>
    <script>
        document.querySelector("#show1").addEventListener("click",function(){
            document.querySelector(".content1").classList.add("active");
        });
        document.querySelector(".content1 .close-btn").addEventListener("click",function(){
            document.querySelector(".content1").classList.remove("active");
        });


        document.querySelector("#show2").addEventListener("click",function(){
            document.querySelector(".content2").classList.add("active");
        });
        document.querySelector(".content2 .close-btn").addEventListener("click",function(){
            document.querySelector(".content2").classList.remove("active");
        });


        document.querySelector("#show3").addEventListener("click",function(){
            document.querySelector(".content3").classList.add("active");
        });
        document.querySelector(".content3 .close-btn").addEventListener("click",function(){
            document.querySelector(".content3").classList.remove("active");
        });


        document.querySelector("#show4").addEventListener("click",function(){
            document.querySelector(".content4").classList.add("active");
        });
        document.querySelector(".content4 .close-btn").addEventListener("click",function(){
            document.querySelector(".content4").classList.remove("active");
        });


        document.querySelector("#show5").addEventListener("click",function(){
            document.querySelector(".content5").classList.add("active");
        });
        document.querySelector(".content5 .close-btn").addEventListener("click",function(){
            document.querySelector(".content5").classList.remove("active");
        });


        document.querySelector("#show6").addEventListener("click",function(){
            document.querySelector(".content6").classList.add("active");
        });
        document.querySelector(".content6 .close-btn").addEventListener("click",function(){
            document.querySelector(".content6").classList.remove("active");
        });
    </script>
</body>
</html>