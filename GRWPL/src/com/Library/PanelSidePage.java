package com.Library;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelSidePage extends JFrame{
	private JButton btn_home,btn_addBooks,btn_addStudents,btn_bookDetails,btn_studentDetails,btn_issueBooks,btn_returnBooks,btn_report;
	/*private JScrollPane panel;*/
	private JPanel panel;
	public boolean f;
	public PanelSidePage(JPanel panel,String str,JFrame delframe){
		this.panel=panel;
		f=false;
		//JScrollPane scrollPane= new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridLayout grid = new GridLayout(12,1,1,2);
		panel.setBorder(new EmptyBorder(5,0,0,5));
		panel.setBackground(Color.WHITE);
		
		Font font = new Font("Arial",Font.BOLD,20);
		
		btn_home=new JButton("HOME");
		btn_home.setFont(font);
		
		if(str=="home")
		{
			btnBackground1(btn_home);
			
		}else {
			btnBackground2(btn_home);
			btn_home.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					NewLibrarianPage home = new NewLibrarianPage();
					home.setVisible(true);
					delframe.dispose();
					f=true;
					
				}
			});
		}
		
		btn_addBooks=new JButton("ADD BOOKS");
		btn_addBooks.setFont(font);
		if(str=="addBooks")
		{
			btnBackground1(btn_addBooks);
		}else {
			btnBackground2(btn_addBooks);
			btn_addBooks.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					AddBookPage addBook =new AddBookPage();
					addBook.setVisible(true);
					delframe.dispose();
					f=true;
					//System.out.println("Hi mi alo");
				}
			});
		}
		
		btn_addStudents=new JButton("ADD STUDENTS");
		btn_addStudents.setFont(font);
		if(str=="addStudents")
		{
			btnBackground1(btn_addStudents);
		}else {
			btnBackground2(btn_addStudents);
			btn_addStudents.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					AddStudentPage addStudent =new AddStudentPage();
					addStudent.setVisible(true);
					delframe.dispose();
					//System.out.println("Hi mi alo");
				}
			});
		}
		
		btn_bookDetails=new JButton("BOOK DETAILS");
		btn_bookDetails.setFont(font);
		if(str=="bookDetails")
		{
			btnBackground1(btn_bookDetails);
		}else {
			btnBackground2(btn_bookDetails);
			btn_bookDetails.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					BookDetails bookDetails =new BookDetails();
					bookDetails.setVisible(true);
					delframe.dispose();
					//System.out.println("Hi mi alo");
				}
			});
		}
		
		btn_studentDetails=new JButton("STUDENT DETAILS");
		btn_studentDetails.setFont(font);
		if(str=="studentDetails")
		{
			btnBackground1(btn_studentDetails);
		}else {
			btnBackground2(btn_studentDetails);
			btn_studentDetails.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					StudentDetails studentDetails =new StudentDetails();
					studentDetails.setVisible(true);
					delframe.dispose();
					//System.out.println("Hi mi alo");
				}
			});
		}
		
		btn_issueBooks=new JButton("ISSUE BOOKS");
		btn_issueBooks.setFont(font);
		if(str=="issueBooks")
		{
			btnBackground1(btn_issueBooks);
		}else {
			btnBackground2(btn_issueBooks);
			btn_issueBooks.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					IssueBook issueBooks =new IssueBook();
					issueBooks.setVisible(true);
					delframe.dispose();
					//System.out.println("Hi mi alo");
				}
			});
		}
		
		btn_returnBooks=new JButton("RETURN BOOKS");
		btn_returnBooks.setFont(font);
		if(str=="returnBooks")
		{
			btnBackground1(btn_returnBooks);
		}else {
			btnBackground2(btn_returnBooks);
			btn_returnBooks.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ReturnBook returnBook =new ReturnBook();
					returnBook.setVisible(true);
					delframe.dispose();
					//System.out.println("Hi mi alo");
				}
			});
		}
		
		btn_report=new JButton("REPORT");
		btn_report.setFont(font);
		if(str=="report")
		{
			btnBackground1(btn_report);
		}else {
			btnBackground2(btn_report);
			btn_report.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Reports report =new Reports();
					report.setVisible(true);
					delframe.dispose();
					//System.out.println("Hi mi alo");
				}
			});
		}
		JButton btn_due=new JButton("CHECK DUE");
		btn_due.setFont(font);
		btn_due.setBackground(new Color(150,150,200));
		btn_due.setForeground(Color.WHITE);
		btn_due.setBorder(new LineBorder(Color.BLACK, 3, true));
		btn_due.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DueChecker due = new DueChecker();
				due.setVisible(true);
			}
		});
		
		
		panel.setLayout(grid);
		panel.add(btn_home);
		panel.add(btn_addBooks);
		panel.add(btn_addStudents);
		panel.add(btn_bookDetails);
		panel.add(btn_studentDetails);
		panel.add(btn_issueBooks);
		panel.add(btn_returnBooks);
		panel.add(btn_report);
		panel.add(btn_due);
		
		//this.panel=scrollPane;
	}
	protected void closeFrame(String str) {
		// TODO Auto-generated method stub
		if(str=="home") {
			NewLibrarianPage home = new NewLibrarianPage();
			
		}else if(str=="addBooks") {
			AddBookPage addBook =new AddBookPage();
			addBook.dispose();
		}else if(str=="addStudents") {
			AddStudentPage addStudent =new AddStudentPage();
			addStudent.dispose();
		}else if(str=="bookDetails") {
			BookDetails bookDetails =new BookDetails();
			bookDetails.dispose();
		}else if(str=="studentDetails") {
			StudentDetails studentDetails =new StudentDetails();
			studentDetails.dispose();
		}else if(str=="issueBooks") {
			IssueBook issueBooks =new IssueBook();
			issueBooks.dispose();
		}else if(str=="returnBooks") {
			ReturnBook returnBook =new ReturnBook();
			returnBook.dispose();
		}else if(str=="report") {
			Reports report =new Reports();
			report.dispose();
		}
		
	}
	private void btnBackground1(JButton btn) {
		// TODO Auto-generated method stub
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
		btn.setBorder(new LineBorder(Color.black, 3, true));
		

	}
	private void btnBackground2(JButton btn) {
		btn.setBackground(new Color(100,100,100));
		btn.setForeground(Color.WHITE);
		btn.setBorder(new LineBorder(Color.black, 3, true));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(Color.white);
				btn.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(new Color(100,100,100));
				btn.setForeground(Color.white);
			}
		});
	}
}
