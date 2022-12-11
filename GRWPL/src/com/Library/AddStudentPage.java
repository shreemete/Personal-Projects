package com.Library;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPage extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentPage frame = new AddStudentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel panel_head,panel_side,panel_center;
	String sid;
	public AddStudentPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomePage.class.getResource("/images/Logo1.jpg")));
		setTitle("GRWPL Library Management System");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1750, 1000);
		setLocationRelativeTo(null);
		setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_head=new JPanel();
		new PanelHeadPage(panel_head,this);
		panel_side=new JPanel();
		new PanelSidePage(panel_side,"addStudents",this);
		JScrollPane scrollPane1= new JScrollPane(panel_side, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_center=new JPanel();
		panel_center.setBorder(new LineBorder(new Color(200,200,200), 10));
		panel_center.setBackground(Color.WHITE);
		panel_center.setLayout(new BorderLayout(0,0) );
		JPanel panel_lbl= new JPanel();
		panel_lbl.setLayout(new BorderLayout(0,0));
		Font font = new Font("Arial",Font.BOLD,35);
		JLabel lbl_head=new JLabel("ADD STUDENTS");
		lbl_head.setFont(font);
		lbl_head.setBounds(150,60,250,45);
		lbl_head.setBorder(new EmptyBorder(30,100,30,50));
		panel_lbl.add(lbl_head,BorderLayout.WEST);
		panel_lbl.setBackground(Color.WHITE);
		
		JPanel panel_add= new JPanel();
		panel_add.setBackground(Color.WHITE);
		panel_add.setBounds(135, 155, 1401, 736);
		panel_add.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		panel_add.setLayout(grid);
		
		Font font1 = new Font("Arial",Font.BOLD,22);
		Font font2 = new Font("Arial",Font.PLAIN,20);

		JLabel lblStudentId = new JLabel("Enroll no. ");
		lblStudentId.setFont(font1);
		//panel_add.add(lblBookId);
		
		
		
		
		JLabel label = new JLabel("Student Name ");
		label.setFont(new Font("Arial", Font.BOLD, 22));
		//label.setBorder(new EmptyBorder(0, 0, 0, 20));
		//panel_add.add(label);
		
		JLabel label_1 = new JLabel("Roll no. ");
		label_1.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_1);
		
		JLabel label_2 = new JLabel("Mobile no. ");
		label_2.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_2);
		
		JLabel label_email = new JLabel("Email ID ");
		label_email.setFont(new Font("Arial", Font.BOLD, 22));
		
		JLabel label_3 = new JLabel("Department ");
		label_3.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_3);
		
		JLabel label_4 = new JLabel("Class ");
		label_4.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_4);
		
		JLabel label_5 = new JLabel("Date ");
		label_5.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_5);
			
		JTextField txtStudentEnroll = new JTextField();
		txtStudentEnroll.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentEnroll.setFont(font2);
		//txtStudentEnroll.setEditable(false);
		
		JTextField txtStudentName = new JTextField();
		//txtStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentName.setFont(font2);
		
		JTextField txtRollNo = new JTextField();
		//txtRollNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtRollNo.setFont(font2);
		
		JTextField txtMobileNo = new JTextField();
		//txtMobileNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtMobileNo.setFont(font2);
		
		JTextField txtEmailId = new JTextField();
		//txtMobileNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmailId.setFont(font2);
		
		/*txtDepatment = new JTextField();
		//txtDepatment.setHorizontalAlignment(SwingConstants.CENTER);
		txtDepatment.setFont(font2);*/
		
		String s[] = {"Select","Computer Science ","Civil Engineering","Dress Design","Electronics Engineering","Medical"};
		JComboBox dep= new JComboBox(s);
		dep.setSelectedIndex(0);
		dep.setFont(font2);
		int id =dep.getSelectedIndex();
		/*String s1[]=new String[4];*/
		/*if(id==1) {
			 s1[0] = "Select";
			 s1[1] = "C01";
			 s1[2] = "C02";
			 s1[3] = "C03";
		}else if(id==2) {
			String s1[] = {"Select","CE1","CE2","CE3"};
			s1[0] = "Select";
			 s1[1] = "CE1";
			 s1[2] = "CE2";
			 s1[3] = "CE3";
		}else if(id==3) {
			String s1[] = {"Select","DD1","DD2","DD3"};
			s1[0] = "Select";
			 s1[1] = "DD1";
			 s1[2] = "DD2";
			 s1[3] = "DD3";
		}else if(id==4) {
			String s1[] = {"Select","E&TC1","E&TC2","E&TC3"};
			s1[0] = "Select";
			 s1[1] = "E&TC1";
			 s1[2] = "E&TC2";
			 s1[3] = "E&TC3";
		}else if(id==5) {
			String s1[] = {"Select","MU1","MU2","MU3"};
			s1[0] = "Select";
			 s1[1] = "MU1";
			 s1[2] = "MU2";
			 s1[3] = "MU3";
		}else {
			s1[0]="Select";
		}*/
		String s1[] = {"Select","C01","C02","C03","CE1","CE2","CE3","DD1","DD2","DD3","E&TC1","E&TC2","E&TC3","MU1","MU2","MU3"};
		JComboBox txtClass= new JComboBox(s1);
		txtClass.setSelectedIndex(0);
		txtClass.setFont(font2);
		
		/*
		JTextField txtClass = new JTextField();
		//txtClass.setHorizontalAlignment(SwingConstants.CENTER);
		txtClass.setFont(font2);*/
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis); 
		
		JTextField txtDate = new JTextField(String.valueOf(date));
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setFont(font2);
		txtDate.setEditable(false);
		
		//button
		JButton btn_submit= new JButton("ADD");
		btn_submit.setFont(font2);
		btn_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(sid);
				AddStudentDB add = new AddStudentDB(txtStudentEnroll.getText(), txtStudentName.getText(), txtRollNo.getText(), txtMobileNo.getText(),txtEmailId.getText(), (String) dep.getSelectedItem(), (String) txtClass.getSelectedItem(), txtDate.getText());
				boolean f = add.insertedDB();
				
				if(f) {
					JOptionPane.showMessageDialog(contentPane, "Student Added Successfully");
					
					txtStudentEnroll.setText(null);
					txtStudentName.setText(null);
					txtRollNo.setText(null);
					txtMobileNo.setText(null);
					txtEmailId.setText(null);
					dep.setSelectedIndex(0);
					txtClass.setSelectedIndex(0);
					long millis=System.currentTimeMillis();  
					java.sql.Date date = new java.sql.Date(millis); 
					txtDate.setText(String.valueOf(date));
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Failed to add Student , Enroll no already existed , try agian");
				}
				
				
			}
		});
		JButton btn_reset= new JButton("RESET");
		btn_reset.setFont(font2);
		btn_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
					int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");  
					if(a==0) {
						txtStudentEnroll.setText(null);
						txtStudentName.setText(null);
						txtRollNo.setText(null);
						txtMobileNo.setText(null);
						txtEmailId.setText(null);
						dep.setSelectedIndex(0);
						txtClass.setSelectedIndex(0);
					}
				
				
				
			}
		});
		
		// book id
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=0;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(lblStudentId,gbc);
		
		// text book id
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=200;
		gbc.ipady=30;
		gbc.gridx=1; 
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtStudentEnroll,gbc);
		
		// student name
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=1;
		gbc.insets = new Insets(0,0,10,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label,gbc);
		
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=700;
		gbc.ipady=30;
		gbc.gridx=1; 
		gbc.gridy=1;
		gbc.gridwidth=5;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtStudentName,gbc);
		
		// roll no
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=2;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_1,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=200;
		gbc.ipady=30;
		gbc.gridx=1; 
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtRollNo,gbc);
		
		//  Mobile no.
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=80;
		gbc.gridx=4; 
		gbc.gridy=2;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_2,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=300;
		gbc.ipady=30;
		gbc.gridx=5; 
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.CENTER;
		panel_add.add(txtMobileNo,gbc);
		
	//  Email Id
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=3;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_email,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=600;
		gbc.ipady=30;
		gbc.gridx=1; 
		gbc.gridy=3;
		gbc.gridwidth=5;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtEmailId,gbc);
		
		// Department
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=4;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_3,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=300;
		gbc.ipady=30;
		gbc.gridx=1; 
		gbc.gridy=4;
		gbc.gridwidth=2;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(dep,gbc);
		
		//  quantity
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=80;
		gbc.gridx=4; 
		gbc.gridy=4;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_4,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=30;
		gbc.gridx=5; 
		gbc.gridy=4;
		gbc.gridwidth=1;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtClass,gbc);
		
		//  date
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=80;
		gbc.gridx=4; 
		gbc.gridy=0;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_5,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=200;
		gbc.ipady=30;
		gbc.gridx=5; 
		gbc.gridy=0;
		gbc.insets = new Insets(20,0,0,100);
		gbc.anchor =GridBagConstraints.CENTER;
		gbc.gridwidth = 1;
		panel_add.add(txtDate,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=30;
		gbc.gridx=0; 
		gbc.gridy=5;
		gbc.gridwidth=1;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(btn_submit,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=40;
		gbc.ipady=30;
		gbc.gridx=5; 
		gbc.gridy=5;
		gbc.gridwidth=1;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(btn_reset,gbc);
		

		JPanel panel_waste1= new JPanel();
		panel_waste1.setBorder(new EmptyBorder(70,100,30,50));
		panel_waste1.setBackground(Color.WHITE);
		
		JPanel panel_waste2= new JPanel();
		panel_waste2.setBorder(new EmptyBorder(70,100,30,50));
		panel_waste2.setBackground(Color.WHITE);
		
		JPanel panel_waste3= new JPanel();
		panel_waste3.setBorder(new EmptyBorder(40,50,30,50));
		panel_waste3.setBackground(Color.WHITE);
		
		panel_center.add(panel_lbl,BorderLayout.NORTH);
		panel_center.add(panel_add,BorderLayout.CENTER);
		panel_center.add(panel_waste1,BorderLayout.WEST);
		panel_center.add(panel_waste2,BorderLayout.EAST);
		panel_center.add(panel_waste3,BorderLayout.SOUTH);

		
		JScrollPane scrollPane= new JScrollPane(panel_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		contentPane.add(scrollPane1,BorderLayout.WEST);
		contentPane.add(panel_head,BorderLayout.NORTH);
		contentPane.add(scrollPane,BorderLayout.CENTER);
	}

}
