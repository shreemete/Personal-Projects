<%@	page import="com.action.Connector" %>
<%@	page import="java.sql.*" %>
<%@	page import="java.io.*" %>
<%@	page import="com.action.Delete" %>
<%@	page import="com.action.DocumentUpdator" %>
<%
	String id =request.getParameter("emp_id");
	//System.out.println("------------------------------");
	//System.out.println(id);
	String file =request.getParameter("file");
	//String file =session.getAttribute("file1").toString();
	//System.out.println(file);
	//String col =request.getParameter("col");
	//System.out.println(col);
	Delete dl = new Delete();
	dl.fileDelete(id, file);
	//dl.fileDelete(id,col,file);
	//String path="/Registration of Employeee/WebContent/files/"+id;
	//File f1 = new File(path,file);
	//f1.delete();
	//DocumentUpdator du = new DocumentUpdator();
	//du.doPost(request, response);
%>