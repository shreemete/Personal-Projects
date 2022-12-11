<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		response.sendRedirect("../index.jsp");
	}
%>
<meta charset="ISO-8859-1">
<title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">

<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<link rel="stylesheet" href="../CSS/home1.css">
</head>
<body>
<%

try{
    String email =session.getAttribute("email").toString();
    String pass =session.getAttribute("pass").toString();
	
%>
    <header>
      <div class="logo">
        Acheivers Academy
      </div>
      <section>
        <div class="title">
          Employee Registration
        </div>
        <div class="btn btn1">
          <a href="registration1.jsp">New Registration</a>
        </div>
        <div class="btn btn2">
          <a href="employeeDetails.jsp">Employee Details</a>
        </div>
        <div class="back">
            <a href="logoutAdmin.jsp">Logout</a>
        </div>
      </section>
      <div class="search-box">
        <form action="searchPage1.jsp" method="post">
        <input type="text" name="name" placeholder="Type to Search..."id="">
        <input type="hidden" name="email" value=<%=email %>>
        <input type="hidden" name="pass" value=<%=pass %>>
        <div class="search-btn">
          <span>Search Here</span>
            <i class="fas fa-search"></i>
        </div>
        <input type="submit">
        <div class="cancel-btn">
            <i class="fas fa-times"></i>
        </div>
        <div class="clear" onclick="document.querySelector('input').value=''"></div>
        <div class="search-data">Enter Employee Name</div>
        </form>
    </div>
    </header>
    <script>
      const searchBtn = document.querySelector(".search-btn");
      const cancelBtn = document.querySelector(".cancel-btn");
      const searchBox = document.querySelector(".search-box");
      const searchData = document.querySelector(".search-data");
      const searchInput = document.querySelector("input");
      const Button = document.querySelector("span");
      const clearBtn = document.querySelector(".clear");

      searchBtn.onclick=()=>{
          searchBox.classList.add("active");
          searchInput.classList.add("active");
          searchBtn.classList.add("active");
          cancelBtn.classList.add("active");
          clearBtn.classList.add("active");
          searchData.classList.add("active");
          Button.classList.add("active");

          
      }
      cancelBtn.onclick=()=>{
          if(searchInput.value==""){
              searchBox.classList.remove("active");
              searchInput.classList.remove("active");
              searchBtn.classList.remove("active");
              cancelBtn.classList.remove("active");
              searchData.classList.remove("active");
              clearBtn.classList.remove("active");
              Button.classList.remove("active");

          }
          
      }
  </script>
  <%
}catch(Exception e){
	%>
	<script >
	location.href="../index.jsp";
    </script>
	<%
}

	
  %>
</body>
</html>