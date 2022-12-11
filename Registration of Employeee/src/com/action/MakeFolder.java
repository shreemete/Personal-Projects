package com.action;

import java.io.File;

public class MakeFolder {
	public static String path_id;
	public void folder(String s){
		path_id=s;
		//System.out.println("Make Folder Id :"+s);
		File f = new File(Path.path+path_id+"");
		if(f.mkdir()) {
			//System.out.println("Folder created ....");
		}else {
			//System.out.println("Cannt create Folder ....");
		}
	}
}