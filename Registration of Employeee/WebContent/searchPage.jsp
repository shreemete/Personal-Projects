<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<%@	page import="com.action.Connector" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="CSS/searchPage1.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%
	String s=null;
	
	try{
		
		s=session.getAttribute("status").toString();
	}catch(Exception e){
		
		s="";
	}
	if(!s.equals("status")){
		response.sendRedirect("signIn.jsp");
	}
%>
	<%
	try{
		
	
		

        String emp_id=session.getAttribute("emp_id").toString();
        Connection con = Connector.getCon();
		String sql="select * from emp_info inner join emp_doc on emp_info.id=emp_doc.id where emp_info.id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, emp_id);
		ResultSet rs=ps.executeQuery();

		
		while(rs.next()){
		
			
			session.setAttribute("id",rs.getInt(1) );
			session.setAttribute("email",rs.getString(3) );
			session.setAttribute("pass",rs.getString(4) );
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
                
                <a href="project.jsp" class="tab ">
                    <i class="far fa-tasks"></i>
                    Projects
                </a>
            </nav>
        </div>
        <div class="rightBox">
            <div class="profile tabshow">
                <h1>Employee Profile</h1>
                <h2>Employee ID <%=rs.getInt(1) %></h2>
                <img src=".\files\<%=rs.getInt(1)%>\<%=rs.getString(14) %>" alt="" >
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
                    <a href=".\files\<%=rs.getInt(1)%>\<%=rs.getString(10) %>" target="_blank">View</a>
                </div>
                <div class="hsc">
                    <span>HSC Marksheet </span>
                    <a href=".\files\<%=rs.getInt(1)%>\<%=rs.getString(11) %>" target="_blank">View</a>
                </div>
                <div class="grad">
                    <span>Graduation Certificate </span>
                    <a href=".\files\<%=rs.getInt(1)%>\<%=rs.getString(12) %>" target="_blank">View</a>
                </div>
                <div class="resume">
                    <span> Resume </span>
                    <a href=".\files\<%=rs.getInt(1)%>\<%=rs.getString(13) %>" target="_blank">View</a> 
                </div>
                <div class="photo">
                    <span>Photo  </span>
                    <a href=".\files\<%=rs.getInt(1)%>\<%=rs.getString(14) %>" target="_blank">View</a>
                </div>
                <div class="sign">
                    <span> Signature </span>
                    <a href=".\files\<%=rs.getInt(1)%>\<%=rs.getString(15) %>" target="_blank">View</a>
                </div>
                <div class="update">
    					<a href="updateDocument.jsp">Document Update</a>
				</div>
            </div>
            
        </div>
        <div class="back">
            <a href="logout.jsp">
                Logout
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
    <%
		
		}
		}catch(Exception e){
			e.printStackTrace();
		}
    %>
</body>
</html>