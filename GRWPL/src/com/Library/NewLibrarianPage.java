package com.Library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.Insets;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewLibrarianPage extends JFrame {


	private JPanel contentPane;
	
	

	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewLibrarianPage frame = new NewLibrarianPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JPanel panel_head,panel_side,panel_center;
	private JLabel lbl_book1 ,lbl_book2;
	private JLabel lbl_student1 ,lbl_student2;
	private JLabel lbl_issue_book1 ,lbl_issue_book2;
	private JLabel lbl_return_book1 ,lbl_return_book2;
	public NewLibrarianPage() {
		
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
		
		PanelSidePage ps=new PanelSidePage(panel_side,"home",this);
		if(ps.f) {
			dispose();
		}
		JScrollPane scrollPane1= new JScrollPane(panel_side, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_center=new JPanel();
		panel_center.setBorder(new LineBorder(new Color(200,200,200), 10));
		panel_center.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane(panel_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		panel_center.setLayout(grid);
		
		GridLayout g = new GridLayout(2,1);
		
		JPanel panel1=new JPanel();
		panel1.setBorder(new LineBorder(new Color(100,100,100),5));
		
		//Fonts
		Font font1 = new Font("Sans",Font.BOLD,40);
		Font font2 = new Font("Sans",Font.PLAIN,20);
		panel1.setLayout(g);
		
		
		// book details
		total ttl= new total();
		
		lbl_book1= new JLabel(String.valueOf(ttl.book));
		lbl_book1.setFont(font1);
		lbl_book1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_book2= new JLabel("Number of Books ");
		lbl_book2.setFont(font2);
		lbl_book2.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lbl_book1);
		panel1.add(lbl_book2);
		
		
		JPanel panel2=new JPanel();
		panel2.setBorder(new LineBorder(new Color(100,100,100),5));
		panel2.setLayout(g);
		// Student details
		lbl_student1= new JLabel(String.valueOf(ttl.student));
		lbl_student1.setFont(font1);
		lbl_student1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_student2= new JLabel("Number of Students ");
		lbl_student2.setFont(font2);
		lbl_student2.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(lbl_student1);
		panel2.add(lbl_student2);
				
		JPanel panel3=new JPanel();
		panel3.setBorder(new LineBorder(new Color(100,100,100),5));
		panel3.setLayout(g);
		//issue book details
		lbl_issue_book1= new JLabel(String.valueOf(ttl.issued));
		lbl_issue_book1.setFont(font1);
		lbl_issue_book1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_issue_book2= new JLabel("Number of Issued Books");
		lbl_issue_book2.setFont(font2);
		lbl_issue_book2.setHorizontalAlignment(SwingConstants.CENTER);
		panel3.add(lbl_issue_book1);
		panel3.add(lbl_issue_book2);
		
		JPanel panel4=new JPanel();
		panel4.setBorder(new LineBorder(new Color(100,100,100),5));
		panel4.setLayout(g);
		//issue book details
		lbl_return_book1= new JLabel(String.valueOf(ttl.returned));
		lbl_return_book1.setFont(font1);
		lbl_return_book1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_return_book2= new JLabel("Number of Returned Books");
		lbl_return_book2.setFont(font2);
		lbl_return_book2.setHorizontalAlignment(SwingConstants.CENTER);
		panel4.add(lbl_return_book1);
		panel4.add(lbl_return_book2);
		
		
		JPanel panel_table=new JPanel();
		panel_table.setBorder(new LineBorder(new Color(100,100,100),5));
		panel_table.setLayout(new BorderLayout());
		
		// panel book
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=100;
		gbc.gridx=0; 
		gbc.gridy=0;
		gbc.insets = new Insets(10,0,30,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_center.add(panel1,gbc);	
		
		// panel student
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=100;
		gbc.gridx=1; 
		gbc.gridy=0;
		gbc.insets = new Insets(10,50,30,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_center.add(panel2,gbc);
		
		// panel issued book
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=100;
		gbc.gridx=2; 
		gbc.gridy=0;
		gbc.anchor =GridBagConstraints.WEST;
		panel_center.add(panel3,gbc);
		
		// panel return book
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=100;
		gbc.gridx=3; 
		gbc.gridy=0;
		gbc.anchor =GridBagConstraints.WEST;
		panel_center.add(panel4,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		//gbc.ipadx=1200;
		gbc.ipady=200;
		gbc.gridx=0; 
		gbc.gridy=1;
		gbc.anchor =GridBagConstraints.WEST;
		gbc.insets = new Insets(10,0,0,0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel_center.add(panel_table,gbc);
		int n=0;
		try
		{
			Connection con = Connector.getCon();
			String q = "select count(enroll) from issuebook where action1='issued' or action1='return'";
			PreparedStatement pstmt =con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				n+=rs.getInt(1);
			}
			String q1 = "select count(enroll) from issuebook where action2='issued' or action2='return'";
			PreparedStatement pstmt1 =con.prepareStatement(q1);
			ResultSet rs1 = pstmt1.executeQuery();
			if(rs1.next()) {
				n+=rs1.getInt(1);
			}
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		String data[][]= new String[n][6];
		try {
			Connection con = Connector.getCon();
			String q2 = "select enroll,issuedbook1,action1 from issuebook where action1='issued' or action1='return'";
			PreparedStatement pstmt2 = con.prepareStatement(q2);
			ResultSet rs2= pstmt2.executeQuery();
			int j=0;
			while(rs2.next()) {
				data[j][0]=String.valueOf(j+1);
				data[j][1]=rs2.getString(1);
				String q3 = "select name from student_details where enroll=?";
				PreparedStatement pstmt3 = con.prepareStatement(q3);
				pstmt3.setString(1, rs2.getString(1));
				ResultSet rs3= pstmt3.executeQuery();
				if(rs3.next()) {
					data[j][2]=rs3.getString(1);
					}
				data[j][3]=rs2.getString(2);
				String q4 = "select book_name from book_details where book_id=?";
				PreparedStatement pstmt4 = con.prepareStatement(q4);
				pstmt4.setString(1, rs2.getString(2));
				ResultSet rs4= pstmt4.executeQuery();
				if(rs4.next()) {
					data[j][4]=rs4.getString(1);
					}
				data[j][5]=rs2.getString(3);
				
				j++;
			}
			String q5 = "select enroll,issuedbook2,action2 from issuebook where action2='issued' or action2='return'";
			PreparedStatement pstmt5 = con.prepareStatement(q5);
			ResultSet rs5= pstmt5.executeQuery();
			
			while(rs5.next()) {
				data[j][0]=String.valueOf(j+1);
				data[j][1]=rs5.getString(1);
				String q3 = "select name from student_details where enroll=?";
				PreparedStatement pstmt3 = con.prepareStatement(q3);
				pstmt3.setString(1, rs5.getString(1));
				ResultSet rs3= pstmt3.executeQuery();
				if(rs3.next()) {
				data[j][2]=rs3.getString(1);
				}
				data[j][3]=rs5.getString(2);
				String q4 = "select book_name from book_details where book_id=?";
				PreparedStatement pstmt4 = con.prepareStatement(q4);
				pstmt4.setString(1, rs5.getString(2));
				ResultSet rs4= pstmt4.executeQuery();
				if(rs4.next()) {
				data[j][4]=rs4.getString(1);
				}
				data[j][5]=rs5.getString(3);
				
				j++;
			}
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		String col[]= {"Sr.No.","Enroll No.","Student Name","Book ID","Book Name","action"};
		JTable jt=new JTable(data,col); 
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		JTableHeader header = jt.getTableHeader();
		header.setBackground(Color.black);
	    header.setForeground(Color.white);
	      
	    jt.setSelectionBackground(new Color(200,200,200));
		jt.setSelectionForeground(Color.black);
	    jt.setDefaultEditor(Object.class, null);
	    for (int i = 0 ; i<6;i++) {
			jt.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
	    header.setFont(new Font("Tahoma",Font.PLAIN,18));
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    jt.setFont(new Font("Tahoma",Font.PLAIN,18));
	    jt.setRowHeight(30);
		jt.setRowHeight(30);
		JScrollPane scrollPane2 = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_table.add(scrollPane2,BorderLayout.CENTER);
		contentPane.add(scrollPane1,BorderLayout.WEST);
		contentPane.add(panel_head,BorderLayout.NORTH);
		contentPane.add(scrollPane,BorderLayout.CENTER);
	}
}
