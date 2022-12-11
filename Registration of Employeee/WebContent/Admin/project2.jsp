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
		response.sendRedirect("home.jsp");
	}
	%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/project.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
   <!-- 
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="js/j-quoery.js"></script>
    <link rel="stylesheet" href="CSS/dataTable.css">
    <script>
        $(document).ready(function() {
            $('#example').DataTable();
        } );
    </script>-->
    <title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
String name =session.getAttribute("name").toString();

String email =session.getAttribute("email").toString();
String pass =session.getAttribute("pass").toString();
Connection con = Connector.getCon();
Statement st1= con.createStatement();
ResultSet rs1=st1.executeQuery("select name from emp_info where id="+id+";");
rs1.next();
String emp_name=rs1.getString(1);
%>
    <div class="container">
        <div class="btns">
            <a href="#" onclick="tabs(0)" class="tab active" id="add">ADD PROJECT <span id="tri1"></span></a>
            <a href="#" onclick="tabs(1)" class="tab " id="view">VIEW PROJECTS <span id="tri2"></span></a>
        </div>
        <div class="emp_name">
            <h1>Name : <%=emp_name %>  </h1>
            <h1>Employee ID : <%=id %></h1>
        </div>
        <div class="add_project tabshow">
            <form action="projectDataAction2.jsp" method="post">
            	<input type="hidden" name="id" value="<%=id %>"/>
                <input type="text" name="project" id="pro_name" placeholder="Project Name" required>
                <input type="date" name="projectDate" placeholder="Date of Starting" id=""required>
                <div class="form-group">
                  
                  <textarea class="form-control" name="text" id="" placeholder=" " rows="3" required></textarea>
                  <label id="lbl" for="">Projects Description</label>
                </div>
                <div class="customer_name">
                    <input type="text" name="customer1" id="input" class="name" style="margin-bottom: 0px; width: 450px;" placeholder="Student Name">
                    <!-- <span class="close"  style="top: -14px;"><i class="material-icons" onclick="close()">close</i></span> -->
                    <a href="#" onclick="add_name()" id="add_name">ADD</a>
                </div>
                <!-- <a href="#" onclick="add_name()" id="add_name">ADD</a> -->
                <input type="text" name="total_pay" id="total_pay" placeholder="Total Payment">
                <input type="text" name="paid" id="paid" placeholder="Paid" onkeyup="remainn()">
                <input type="text" name="remained" id="remain" placeholder="Remain" readonly>
                <input type="submit" value="Save">
                <!-- <input type="file" accept="image/*;capture=camera" > -->
            </form>
        </div>
        <script>
        "use strict";
        function remainn(){
        	var total_pay=document.getElementById("total_pay").value;
        	var paid=document.getElementById("paid").value;
        	var final_remain=Number(total_pay)-Number(paid);
        	document.getElementById("remain").value=final_remain;
        }
        </script>
        
        <div class="view_projects tabshow" >
            <table id="example">
                <thead>
                <tr>
                    <th>Sr. No.</th>
                    <th>Project Name</th>
                    
                    <th>Submission Date</th>
                    <th>Project Description</th>
                    <th>Customer Name</th>
                    <th>Total Payment</th>
                    <th>Paid Payment</th>
                    <th>Remaining payment</th>
                    <th>Action</th>
                    
                </tr>
            </thead>
            <tbody>
            <%
	
	
	
					
					Statement st= con.createStatement();
					ResultSet rs=st.executeQuery("select * from project_info inner join student_name on project_info.id=student_name.id where emp_id="+id+";");
					while(rs.next()){
			%>
					<tr>
                    <td><%=rs.getInt(2) %></td>
                    <td><%=rs.getString(3) %></td>
                    <td><%=rs.getString(4) %></td>
                    <td><%=rs.getString(5) %></td>
                    <td>
                        <ol>
                        <%
                        	if(rs.getString(7) != "" && rs.getString(7) != null){
                        		%>
                        		<li><%=rs.getString(7) %></li>
                        		<%
                        	}
                        	if(rs.getString(8) != "" && rs.getString(8) != null){
                    			%>
                    			<li><%=rs.getString(8) %></li>
                    			<%
                    		}
                        	if(rs.getString(9) != "" && rs.getString(9) != null){
                    			%>
                    			<li><%=rs.getString(9) %></li>
                    			<%
                    		}
                        	else if(rs.getString(10) != "" && rs.getString(10) != null){
                    			%>
                    			<li><%=rs.getString(10) %></li>
                    			<%
                    		}
                        	else if(rs.getString(11) != "" && rs.getString(11) != null){
                    			%>
                    			<li><%=rs.getString(11) %></li>
                    			<%
                    		}
                        	else if(rs.getString(12) != "" && rs.getString(12) != null){
                    			%>
                    			<li><%=rs.getString(12) %></li>
                    			<%
                    		}
                        	else if(rs.getString(13) != "" && rs.getString(13) != null){
                    			%>
                    			<li><%=rs.getString(13) %></li>
                    			<%
                    		}
                        	else if(rs.getString(14) != "" && rs.getString(14) != null){
                    			%>
                    			<li><%=rs.getString(14) %></li>
                    			<%
                    		}
                        	else if(rs.getString(15) != "" && rs.getString(15) != null){
                    			%>
                    			<li><%=rs.getString(15) %></li>
                    			<%
                    		}
                        	else if(rs.getString(16) != "" && rs.getString(16) != null){
                    			%>
                    			<li><%=rs.getString(16) %></li>
                    			<%
                    		}
                        %>
                            
                        </ol>
                    </td>
                    <td><%=rs.getInt(17) %></td>
                    <td><%=rs.getInt(18) %></td>
                    <td><%=rs.getInt(19) %></td>
                    <td> <a href="updateProject2.jsp?id=<%=id%>&project_id=<%=rs.getInt(2)%>">Update</a> </td>
                </tr>
			<%
					}
		
			%>
                
             </tbody>
            </table>
        </div>
    </div>
	<div class="back">
            <a href="searchPage1.jsp?id=<%=id%>&name=<%=name%>">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
   	</div>
    <script>

        const tabBtn=document.querySelectorAll(".tab");
        const act = document.querySelector("a");
        const tab=document.querySelectorAll(".tabshow");
        function tabs(panelIndex) {
            act.classList.add("active");
            tab.forEach(function(node){
                node.style.display="none";
            });
            tab[panelIndex].style.display="block";
        }
        tabs(0);
        var i =2;
        const add = document.querySelector('#add_name');
        const customer = document.querySelector('.customer_name');
        function add_name(){
            if(i<=10){
            var newField = document.createElement('input');
            newField.setAttribute('type','text');
            newField.setAttribute('name','customer'+i);
            newField.setAttribute('id','input'+i);
            newField.setAttribute('class','name');
            newField.setAttribute('style',"margin-top:-30px; width: 450px;");
            newField.setAttribute('placeholder','Student Name');
            const span=document.createElement('span');
            // span.setAttribute('id','close');
            span.setAttribute('class','close'+i);
            
            const closeBtn=document.createElement('i');
            closeBtn.setAttribute('class','material-icons');
            // closeBtn.setAttribute('data-item','label');
            closeBtn.setAttribute('onclick','reset('+i+')');
            closeBtn.innerHTML='close';
            span.appendChild(closeBtn);
            customer.prepend(span);
            customer.prepend(newField);
            console.log(i);
            i++;
        }
            
        }
        function reset(i) {
            document.querySelectorAll('#input'+i).forEach(function(tag){
            tag.parentElement.removeChild(tag);
            })
            document.querySelectorAll('.close'+i).forEach(function(tag){
            tag.parentElement.removeChild(tag);
            })
            i--;
        }
    </script>
</body>
</html>
