package com.action;

import java.util.ArrayList;

public class Iterate {
	private int empId;
	ArrayList<String> al = new ArrayList<>();
	
	public Iterate(String empId, ArrayList<String> al) {
		super();
		this.empId = Integer.parseInt(empId);
		this.al = al;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public ArrayList<String> getAl() {
		return al;
	}
	public void setAl(ArrayList<String> al) {
		this.al = al;
	}
	
	
}
