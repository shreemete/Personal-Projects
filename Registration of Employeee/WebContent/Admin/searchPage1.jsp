<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../CSS/searchPage.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
	<%	

	
	String name = request.getParameter("name");
	session.setAttribute("name", name);
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	if(email==null && pass==null){
		try{
		email = session.getAttribute("email").toString();
		pass = session.getAttribute("pass").toString();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
		
	try{
		
	if(email!="achievers@gmail.com" && pass!="admin"){
		Connection con = Connector.getCon();
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp_info inner join emp_doc where emp_info.id=emp_doc.id AND (emp_info.name like '%"+name+"%');");
		rs.next();
		//ResultSet rs1=st.executeQuery("select * from emp_doc where id="+rs.getInt(1));
		//rs1.next();
		
	
	%>
    <div class="container">
        <div class="leftBox">
            <nav>
                <a href="#" onclick="tabs(0)" class="tab active">
                	<i class="far fa-user"></i>
                    Profile
                </a>
                <a href="#" onclick="tabs(1)" class="tab ">
                    <i class="far fa-file-alt"></i>
                    Documents
                </a>
                <%
                	session.setAttribute("emp_email", rs.getString(3));
                session.setAttribute("emp_pass", rs.getString(4));
                %>
               <a href="project2.jsp?id=<%=rs.getInt(1)%>">
                <i class="far fa-tasks"></i>
                Projects</a>
            </nav>
        </div>
        <div class="rightBox">
            <div class="profile tabshow">
                <h1>Employee Profile</h1>
                <h2>Employee ID <%=rs.getInt(1) %></h2>
                <img src="..\files\<%=rs.getInt(1)%>\<%=rs.getString(14) %>" target="_blank"alt="" >
                <div class="name">
                    <span>Name :</span>
                    <span><%=rs.getString(2) %></span>
                </div>
                <div class="email">
                    <span>Email :</span>
                    <span><%=rs.getString(3)%></span>
                </div>
                <div class="contact">
                    <span>Contact :</span>
                    <span><%=rs.getString(4)%></span>
                </div>
                <div class="designation">
                    <span>Designation :</span>
                    <span><%=rs.getString(6)%></span>
                </div>
                <div class="date">
                    <span>Date of joining :</span>
                    <span><%=rs.getString(5)%></span>
                </div>
                <div class="blood">
                    <span>Blood Group :</span>
                    <span><%=rs.getString(8)%></span>
                </div>
                
            </div>
            <div class="documents tabshow">
                <h1>Employee Documents</h1>
                <h2>Employee ID <%=rs.getInt(1) %></h2>
                <div class="ssc">
                    <span>SSC Marksheet </span>
                    <a href="..\files\<%=rs.getInt(1)%>\<%=rs.getString(10) %>" target="_blank">View</a>
                </div>
                <div class="hsc">
                    <span>HSC Marksheet </span>
                    <a href="..\files\<%=rs.getInt(1)%>\<%=rs.getString(11) %>" target="_blank">View</a>
                </div>
                <div class="grad">
                    <span>Graduation Certificate </span>
                    <a href="..\files\<%=rs.getInt(1)%>\<%=rs.getString(12) %>" target="_blank">View</a>
                </div>
                <div class="resume">
                    <span> Resume </span>
                    <a href="..\files\<%=rs.getInt(1)%>\<%=rs.getString(13) %>" target="_blank">View</a> 
                </div>
                <div class="photo">
                    <span>Photo  </span>
                    <a href="..\files\<%=rs.getInt(1)%>\<%=rs.getString(14) %>" target="_blank">View</a>
                </div>
                <div class="sign">
                    <span> Signature </span>
                    <a href="..\files\<%=rs.getInt(1)%>\<%=rs.getString(15) %>" target="_blank">View</a>
                </div>
                <div class="update">
    					<a href="updateDocument2.jsp?id=<%=rs.getInt(1) %>">Document Update</a>
				</div>
            </div>
            
        </div>
        <div class="back">
            <a href="home.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
        </div>
    </div>

    <script>
        const tabBtn=document.querySelectorAll(".tab");
        const tab=document.querySelectorAll(".tabshow");
        function tabs(panelIndex) {
            tab.forEach(function(node){
                node.style.display="none";
            });
            tab[panelIndex].style.display="block";
        }
        tabs(0);
    </script>
    <%}
		}catch(Exception e){
		
			%>
			<script type="text/javascript">
				alert("Name dosen't exist... try again");
				location.href="home.jsp";
			</script>
			<%
		}
	
	 %>
</body>
</html>