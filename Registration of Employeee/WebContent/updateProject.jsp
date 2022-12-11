<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/updateProject.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    <title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%
int id = Integer.parseInt(session.getAttribute("id").toString());
String email = session.getAttribute("email").toString();
String pass = session.getAttribute("pass").toString();

int project_id=Integer.parseInt(request.getParameter("project_id"));

try{
email = request.getParameter("email");
pass = request.getParameter("pass");
}catch(Exception e){
	
}
Connection con = Connector.getCon();
Statement st1= con.createStatement();
ResultSet rs1=st1.executeQuery("select name from emp_info where id="+id+";");
rs1.next();
String emp_name=rs1.getString(1);

%>
    <div class="container">
        <div class="btns">
            <a href="#" class="tab active" id="add">ADD PROJECT <span id="tri1"></span></a>
            
        </div>
        <div class="emp_name">
            <h1>Name : <%=emp_name %>  </h1>
            <h1>Employee ID : <%=id %></h1>
        </div>
        <div class="add_project tabshow">
            <form action="updateProjectAction.jsp" method="post">
                <h1>Update Project Information</h1>
                
            	<input type="hidden" name="id" value="<%=id %>"/>
            	<input type="hidden" name="project_id" value="<%=project_id %>"/>
            	<%
            		Statement st= con.createStatement();
            		ResultSet rs=st.executeQuery("select * from project_info inner join student_name on project_info.id=student_name.id where emp_id="+id+" and project_info.id="+project_id+";");
            		while(rs.next()){
            			int i = 0;
            	%>
                <input type="text" name="project" id="pro_name" value=<%=rs.getString(3) %> required>
                <input type="date" name="projectDate" value=<%=rs.getString(4) %> id=""required>
                <div class="form-group">
                  
                  <textarea class="form-control" name="text" id=""  rows="3" required><%=rs.getString(5) %></textarea>
                  <label id="lbl" for="">Projects Description</label>
                </div>
                
                <div class="customer_name">
                
                <%
                	if(rs.getString(16) != "" && rs.getString(16) != null){
                %>
                    <input type="text" name="customer10" id="input10" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(16) %>>
                    <span class="close10" ><i class="material-icons" onclick="reset(10)">close</i></span>
                <%
                       i++;
                    }
                %>
                <%
                	if(rs.getString(15) != "" && rs.getString(15) != null){
                %>
                    <input type="text" name="customer9" id="input9" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(15) %>>
                    <span class="close9" ><i class="material-icons" onclick="reset(9)">close</i></span>
                <%
                       i++;
                    }
                %>
                <%
                	if(rs.getString(14) != "" && rs.getString(14) != null){
                %>
                    <input type="text" name="customer8" id="input8" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(14) %>>
                    <span class="close8" ><i class="material-icons" onclick="reset(8)">close</i></span>
                <%
                       i++;
                    }
                %>
                <%
                	if(rs.getString(13) != "" && rs.getString(13) != null){
                %>
                    <input type="text" name="customer7" id="input7" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(13) %>>
                    <span class="close7" ><i class="material-icons" onclick="reset(7)">close</i></span>
                <%
                       i++;
                    }
                %>
                <%
                	if(rs.getString(12) != "" && rs.getString(12) != null){
                %>
                    <input type="text" name="customer6" id="input6" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(12) %>>
                    <span class="close6" ><i class="material-icons" onclick="reset(6)">close</i></span>
                <%
                       i++;
                    }
                %>
                <%
                	if(rs.getString(11) != "" && rs.getString(11) != null){
                %>
                    <input type="text" name="customer5" id="input5" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(11) %>>
                    <span class="close5"><i class="material-icons" onclick="reset(5)">close</i></span>
                <%
                       i++;
                    }
                %>
                <%
                	if(rs.getString(10) != "" && rs.getString(10) != null){
                %>
                    <input type="text" name="customer4" id="input4" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(10) %>>
                    <span class="close4"  ><i class="material-icons" onclick="reset(4)">close</i></span>
                <%
                      i++;
                    }
                %>
                <%
                	if(rs.getString(9) != "" && rs.getString(9) != null){
                %>
                    <input type="text" name="customer3" id="input3" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(9) %>>
                    <span class="close3"  ><i class="material-icons" onclick="reset(3)">close</i></span>
                <%
                       i++;
                    }
                %>
                <%
                	if(rs.getString(8) != "" && rs.getString(8) != null){
                %>
                    <input type="text" name="customer2" id="input2" class="name" style="margin-top: -30px; width: 450px;" value=<%=rs.getString(8) %>>
                    <span class="close2" ><i class="material-icons" onclick="reset(2)">close</i></span>
                <%
                       i++;
                    }
                %>
                <%
                	if(rs.getString(7) != "" && rs.getString(7) != null){
                %>
                    <input type="text" name="customer1" id="input" class="name" style="margin-bottom: 0px; width: 450px;" value=<%=rs.getString(7) %>>
                <%
                       i++;
                    }
                %>
                    <input type="hidden" id="no" value=<%=i+1 %>>
                    <a href="#" onclick="add_name()" id="add_name">ADD</a>
                </div>
                <!-- <a href="#" onclick="add_name()" id="add_name">ADD</a> -->
                <input type="text" name="total_pay" id="total_pay" value=<%=rs.getInt(17) %>>
                <input type="text" name="paid" id="paid" value=<%=rs.getInt(18) %> onkeyup="remainn()">
                <input type="text" name="remained" id="remain" value=<%=rs.getInt(19) %> readonly>
                <%} %>
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
    </div>
	<div class="back">
            <a href="project.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
        </div>
    <script>

        const tabBtn=document.querySelectorAll(".tab");
        const act = document.querySelector("a");
        const tab=document.querySelectorAll(".tabshow");
        
        var i =document.getElementById("no").value;
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
