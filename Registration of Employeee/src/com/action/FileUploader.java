package com.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.action.MakeFolder;
import javax.servlet.*; 
import javax.servlet.http.*;  
import com.oreilly.servlet.multipart.MultipartParser; 
import com.oreilly.servlet.multipart.Part;
//import com.mysql.cj.Session;
//import com.employee_details.EmpDao;
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FilePart; 

public class FileUploader extends HttpServlet{

	/**
	 *
	 */
//	private String fileSavePath;
	private static final long serialVersionUID = 1L;
	 public void init( ){
		 // save uploaded files to a 'data' directory in the web app
		 
//		 fileSavePath =   "D:\\Something\\WebContent\\files\\"+id;
//		 String id = request.getParameter("emp_id");
//		 System.out.print(id);
//		 String fileSavePath ="D:\\Registration of Employeee\\WebContent\\files\\"+id;
		 
	 }
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//MultipartRequest m=new MultipartRequest(request,"D://Registration of Employeee//WebContent//files//"+MakeFolder.path_id,1024*1024*10);
		
		response.setContentType("text/html"); 
		
//		String id =m.getParameter("emp_id");
		java.io.PrintWriter out = response.getWriter( );
		out.println("<html>");     
		out.println("<head>");     
		out.println("<title>File uploads</title>");       
		out.println("</head>");     
		out.println("<body>");     
		out.println("<h2>Here is information about any uploaded files</h2>");
		
		
		try{  
			
			
			
			// file limit size of 10 MB         
			MultipartParser parser = new MultipartParser(request,10 * 1024 * 1024);
//			String id1 =session.getAttribute("emp_id").toString();
			
			ArrayList<String> arr= new ArrayList<>();
//			System.out.println(id);
			String fileSavePath =Path.path+MakeFolder.path_id+"\\";//"D:\\Registration of Employeee\\WebContent\\files\\"
			Part _part = null;         
			while ((_part = parser.readNextPart( )) != null) 
			{                    
				if (_part.isFile( )) 
				{                
					// get some info about the file               
					FilePart fPart = (FilePart) _part;                
					String name = fPart.getFileName( ); 
					arr.add(name);
					if (name != null) {                       
						long fileSize = fPart.writeTo(new java.io.File(fileSavePath));                    
						out.println("The user's file path for the file: " +fPart.getFilePath( ) + "<br>");                    
						out.println("The content type of the file: " + fPart.getContentType( )+ "<br>");
						out.println("The file size: " +fileSize+ " bytes<br><br>");                   
						//commence with another file, if there is one                
					} 
					else {                   
						out.println("The user did not upload a file for this part.");
					}           
				}else if (_part.isParam( )) {              
					// do something else if it is a non-file-type parameter,               
					//such as a username           
				}            
			}// end while  
			
			Iterate it = new Iterate(MakeFolder.path_id,arr);
			boolean f;
			try {
				
				//System.out.print(MakeFolder.path_id+"======>");
				f = DocDao.insertStudentToDB(it);
				if(f) {
					
					out.println("<script>alert('Data Added Successfully...')</script>");

					response.sendRedirect("signIn.jsp");
				}else {
					out.println("Something went Wrong.......");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("</body>");         
			out.println("</html>");     
			
			
			
		
		}catch (java.io.IOException ioe){                
			//an error-page in the deployment descriptor is         
			//mapped to the java.io.IOException         
			throw new java.io.IOException("IOException occurred in: " + getClass( ).getName( ));  
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {                  
		throw new ServletException("GET method used with " + getClass( ).getName( )+ ": POST method required.");    
	} 

}
