package com.action;

 

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
@MultipartConfig
public class UploadUpdatedFile extends HttpServlet{
		private static final long serialVersionUID = 1L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			try(PrintWriter out = resp.getWriter()){
				Part part = req.getPart("ssc");
				String fileName=part.getSubmittedFileName();
				out.println(fileName);
				int n=Integer.parseInt(req.getParameter("emp_id"));
				String str = req.getParameter("file");
				String col = req.getParameter("col");
				//System.out.println(str+" ================= "+fileName+"========="+col);
				DeleteFolder df = new DeleteFolder(n,str,col);
				df.fileDelete();
				String path = Path.path+n+"\\"+File.separator+fileName;
				/*String path = "D:\\Registration of Employeee\\WebContent\\files\\"+n+"\\"+File.separator+fileName;*/
				//String path = "//var//lib//tomcat8//webapps//Registration_of_Employeee//WebContent//files//"+n+"\\"+File.separator+fileName;

				InputStream is =part.getInputStream();
				boolean succs =uploadFile(is,path);
				if(succs) {
					resp.sendRedirect("updateDocumentAction.jsp?id="+n+"&file="+fileName+"&col="+col+"");
					out.println("File uploaded to :"+path);
				}else {
					out.print("error msg");
				}
			}
		}
		public boolean uploadFile(InputStream is , String path) {
			boolean test = false;
			try {
				byte[] byt = new byte[is.available()];
				is.read();
				FileOutputStream fops = new FileOutputStream(path);
				fops.write(byt);
				test=true;
				fops.flush();
				fops.close();
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("error here");
			}
			
			return test;
		}

	}
