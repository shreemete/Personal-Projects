package com.action;

import java.io.File;
public class DeleteFolder {
	public static int path_id;
	public static String column;
	public static String filename;
	public DeleteFolder(int id,String file,String col) {
		path_id=id;
		column=col;
		filename=file;
		
	}
	public void fileDelete() {
		String path=Path.path+path_id;
		File f1 = new File(path,filename);
		f1.delete();
	}

}
