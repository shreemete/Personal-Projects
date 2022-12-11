<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<%

int id = Integer.parseInt(request.getParameter("id"));
String file = (request.getParameter("file"));
String col = (request.getParameter("col"));

out.print(id+"--------------"+file+"-----------------"+col);


try{
	Connection con = Connector.getCon();
	String q="update emp_doc set "+col+"=? where id=?";
	PreparedStatement pstmt = con.prepareStatement(q);
	pstmt.setInt(2,id);
	pstmt.setString(1,file);
	
	pstmt.executeUpdate();
	
	response.sendRedirect("updateDocument.jsp?id="+id+"");
	
}catch(Exception e){
	System.out.println(e);
	%>
	<script>
		alert("Document couldn't updated Try again ...");
		location.href="updateDocument.jsp";
	</script>
	<%
	/* response.sendRedirect("updateDocument.jsp?msg=wrong"); */
}

%>