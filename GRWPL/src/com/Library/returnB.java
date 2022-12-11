package com.Library;

public class returnB {

	 static String sr;
	 static String bkID;
	 static String bkName;
	 static String bkAuthor;
	 static String dueDate;
	 static String[] arr;

	public static String[] getArr() {
		return arr;
	}

	public static void setArr(String[] arr) {
		returnB.arr = arr;
	}

	public String getSr() {
		return sr;
	}

	public void setSr(String sr) {
		this.sr = sr;
	}

	public String getBkID() {
		return bkID;
	}

	public void setBkID(String bkID) {
		this.bkID = bkID;
	}

	public String getBkName() {
		return bkName;
	}

	public void setBkName(String bkName) {
		this.bkName = bkName;
	}

	public String getBkAuthor() {
		return bkAuthor;
	}

	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
}
