package com.action;

import java.io.File;
public class Delete
{
	public static String path_id;
	public static String column;
	public static String filename;
	
	public  void fileDelete(String id,String file) {
		path_id=id;
		filename=file;
		String path=Path.path+path_id;
		File f1 = new File(path,filename);
		if(f1.delete()) {
			//System.out.println("file deleted successfully..");
		}
		else{
			//System.out.println("file cann't delete..");
		}
	}

}