<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
<link rel="stylesheet" href="registration.css">
<script src="sweetalert/sweetalert.min.js"></script>
</head>
<body>

<%
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("project");
String date = request.getParameter("projectDate");
String text = request.getParameter("text");
int total_pay=0;
int paid = 0;
int remained = 0;
String customer1="";
String customer2="";
String customer3="";
String customer4="";
String customer5="";

String customer6="";
String customer7="";
String customer8="";
String customer9="";
String customer10="";
try{
	customer2 = request.getParameter("customer2");
	
}catch(Exception e){
	customer2 = "";
	System.out.println("Customer2");
}
try{
	customer1 = request.getParameter("customer1");
	
}catch(Exception e){
	customer1 = "";
}

try{
	customer3 = request.getParameter("customer3");
	
}catch(Exception e){
	customer3 = "";
}
try{
	customer4 = request.getParameter("customer4");
	
}catch(Exception e){
	customer4 = "";
}
try{
	customer5 = request.getParameter("customer5");
	
}catch(Exception e){
	customer5 = "";
}
try{
	customer6 = request.getParameter("customer6");
	
}catch(Exception e){
	customer6 = "";
}
try{
	customer7 = request.getParameter("customer7");
	
}catch(Exception e){
	customer7 = "";
}
try{
	customer8 = request.getParameter("customer8");
	
}catch(Exception e){
	customer8 = "";
}
try{
	customer9 = request.getParameter("customer9");
	
}catch(Exception e){
	customer9 = "";
}
try{
	customer10 = request.getParameter("customer10");
	
}catch(Exception e){
	customer10 = "";
}
try{
	total_pay = Integer.parseInt(request.getParameter("total_pay"));
}catch(Exception e){
	total_pay=0;
}
try{
	paid = Integer.parseInt(request.getParameter("paid"));
}catch(Exception e){
	paid=0;
}
try{
	remained = Integer.parseInt(request.getParameter("remained"));
}catch(Exception e){
	remained=0;
}



	Connection con = Connector.getCon();
	String q1="insert into project_info (emp_id,project_name,project_date,description) values (?,?,?,?)";
	PreparedStatement pstmt1 = con.prepareStatement(q1);
	
	pstmt1.setInt(1,id);
	pstmt1.setString(2,name);
	pstmt1.setString(3,date);
	pstmt1.setString(4,text);
	
	
	pstmt1.executeUpdate();
	String q="select id from project_info where emp_id=? order by id desc";
	PreparedStatement ps= con.prepareStatement(q);
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	rs.next();
	int no = rs.getInt(1);
	System.out.println(no);
	String q2="insert into student_name (id,customer1,customer2,customer3,customer4,customer5,customer6,customer7,customer8,customer9,customer10,total_pay,paid,remained) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt2 = con.prepareStatement(q2);
	
	pstmt2.setInt(1,no);
	pstmt2.setString(2,customer1);
	pstmt2.setString(3,customer2);
	pstmt2.setString(4,customer3);
	pstmt2.setString(5,customer4);
	pstmt2.setString(6,customer5);
	pstmt2.setString(7,customer6);
	pstmt2.setString(8,customer7);
	pstmt2.setString(9,customer8);
	pstmt2.setString(10,customer9);
	pstmt2.setString(11,customer10);
	//pstmt2.setString(3,date);
	//pstmt2.setString(4,text);
	pstmt2.setInt(12,total_pay);
	pstmt2.setInt(13,paid);
	pstmt2.setInt(14,remained);
	
	
	int done=pstmt2.executeUpdate();
	if(done>0){
	%>
	<script type="text/javascript">
		alert("Data added Successfully");
		location.href="project1.jsp?id=<%=id %>";
	</script>
<%}else{ %>
<script type="text/javascript">
		alert("Data Faild Try Again");
		location.href="project1.jsp?id=<%=id %>";
	</script>
<%} %>

</body>
</html>