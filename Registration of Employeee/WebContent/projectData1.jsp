<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/projectData1.css">
<link rel="stylesheet" href="CSS/dataTable.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="js/j-quoery.js"></script>
    <script>
        $(document).ready(function() {
            $('#example').DataTable();
        } );
    </script>
<title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
%>
	<div class="container">
        <div class="title">
            <h1>Add Project</h1>
        </div>
        <div class="add">
            <form action="projectDataAction.jsp" method="post">
            	<input type="hidden" name="id" value="<%=id%>"/>
                <input type="text" name="project" placeholder="Project Name" required>
                <input type="date" name="projectDate" placeholder="Date of Starting" id=""required>
                <div class="form-group">
                  
                  <textarea class="form-control" name="text" id="" placeholder=" " rows="3" required></textarea>
                  <label id="lbl" for="">Projects Description</label>
                </div>
                <input type="text" name="customer" placeholder="Customer Name">
                <input type="text" name="pay" id="pay" placeholder="Payment">
                <input type="submit" value="Save">
            </form>
        </div>
        <div class="project">
            <h1>Project Details</h1>
        </div>
        <div class="content">
            
            <table id="example">
                <thead>
                <tr>
                    <th>Sr. No.</th>
                    <th>Project Name</th>
                    
                    <th>Submission Date</th>
                    <th>Project Description</th>
                    <th>Customer Name</th>
                    <th>Payment</th>
                    
                </tr>
            </thead>
            <tbody>
            <%
	
	
	
					Connection con = Connector.getCon();
					Statement st= con.createStatement();
					ResultSet rs=st.executeQuery("select * from emp_info inner join project_info where emp_info.id=project_info.emp_id AND project_info.emp_id="+id+";");
					while(rs.next()){
		
			%>
   
                <tr>
                    <td><%=rs.getInt(10) %></td>
                 
                    <td><%=rs.getString(11)%></td>
                    <td><%=rs.getString(12) %></td>
                    <td><%=rs.getString(13) %></td>
                    <td><%=rs.getString(14) %></td>
                    <td><%=rs.getString(15)%></td>
                </tr>
<%
	
	String email =rs.getString(3);
	session.setAttribute("email", email);
	String pass =rs.getString(4);
	session.setAttribute("pass", pass);
}
%>
     
             </tbody>
            </table>
        </div>
        <div class="back">
            <a href="searchPage.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span></span>
            </a>
        </div>
    </div>
    
</body>
</html>