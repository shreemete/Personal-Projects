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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueBook extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel panel_head,panel_side,panel_center;

	int issb=0;
	String enroll=null;
	public IssueBook() {
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
		new PanelSidePage(panel_side,"issueBooks",this);
		JScrollPane scrollPane1= new JScrollPane(panel_side, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_center=new JPanel();
		panel_center.setBorder(new LineBorder(new Color(200,200,200), 10));
		panel_center.setBackground(Color.WHITE);
		
		panel_center.setLayout(new BorderLayout(0,0) );
		JPanel panel_lbl= new JPanel();
		panel_lbl.setLayout(new BorderLayout(0,0));
		Font font = new Font("Arial",Font.BOLD,35);
		JLabel lbl_head=new JLabel("ISSUE BOOK");
		lbl_head.setFont(font);
		lbl_head.setBounds(150,60,250,45);
		lbl_head.setBorder(new EmptyBorder(30,100,30,50));
		panel_lbl.add(lbl_head,BorderLayout.WEST);
		panel_lbl.setBackground(Color.WHITE);
		
		JPanel panel_add= new JPanel();
		panel_add.setBackground(Color.WHITE);
		panel_add.setBounds(135, 155, 1401, 736);
		panel_add.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel_add.setLayout(new BorderLayout());
		
		JPanel panel_add_1= new JPanel();
		panel_add_1.setBackground(Color.WHITE);
		panel_add_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		Font font1 = new Font("Arial",Font.BOLD,22);
		Font font2 = new Font("Arial",Font.PLAIN,18);
		
		JLabel lblRollNo = new JLabel("ROLL NO.");
		lblRollNo.setFont(font1);
		
		JTextField txtRoll= new JTextField();
		txtRoll.setFont(font2);
		
		JLabel lblClass = new JLabel("CLASS");
		lblClass.setFont(font1);
		
		String s[] = {"Select","C01","C02","C03","CE1","CE2","CE3","DD1","DD2","DD3","E&TC1","E&TC2","E&TC3","MU1","MU2","MU3"};
		JComboBox txtClass= new JComboBox(s);
		txtClass.setSelectedIndex(0);
		
		txtClass.setFont(font2);
		
		JLabel lblStdName = new JLabel("Name ");
		lblStdName.setFont(font1);
		
		JTextField txtStdName= new JTextField();
		txtStdName.setFont(font2);
		txtStdName.setEditable(false);
		
		JLabel lblIssuedBook = new JLabel("Issued Book");
		
		lblIssuedBook.setFont(font1);
		
		JTextField txtIssuedBook = new JTextField();
		txtIssuedBook.setHorizontalAlignment(SwingConstants.CENTER);
		txtIssuedBook.setFont(font2);
		txtIssuedBook.setEditable(false);
		
		JPanel panel_add_2= new JPanel();
		panel_add_2.setBackground(Color.WHITE);
		panel_add_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagLayout grid = new GridBagLayout();
		panel_add_2.setLayout(grid);
		
		
		
		JLabel lblBookID = new JLabel("Book ID");
		lblBookID.setFont(font1);
		
		JTextField txtBookID = new JTextField();
		txtBookID.setFont(font2);
		
		
		JLabel lblBookName = new JLabel("Book Name ");
		lblBookName.setFont(font1);
		
		JTextField txtBookName = new JTextField();
		txtBookName.setFont(font2);
		txtBookName.setEditable(false);
		
		JButton btn_search_book = new JButton("Search");
		btn_search_book.setFont(font2);
		btn_search_book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bookid=txtBookID.getText();
				
				try {
					Connection con= Connector.getCon();
					String q4 ="select book_name from book_details where book_id='"+bookid+"';";
					PreparedStatement pstmt4 = con.prepareStatement(q4);
					ResultSet rs4=pstmt4.executeQuery();
					rs4.next();
					txtBookName.setText("  "+rs4.getString(1));
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
					/*System.out.println("aye mi ith ahe");*/
					JOptionPane.showMessageDialog(contentPane, "Student is not present ");
				}
			}
		});
		
		
		
		
		JButton btn_issue = new JButton("Issue");
		btn_issue.setFont(font2);
		
		
		JButton btn_reset = new JButton("Reset");
		btn_reset.setFont(font2);
		btn_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtBookID.setText(null);
				txtBookName.setText(null);
				txtClass.setSelectedIndex(0);
				txtIssuedBook.setText(null);
				txtRoll.setText(null);
				txtStdName.setText(null);
				txtBookID.setEnabled(true);
				btn_search_book.setEnabled(true);
				btn_issue.setEnabled(true);
				
			}
		});
		
		JButton btn_search = new JButton("Search");
		btn_search.setFont(font2);
		btn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String roll=txtRoll.getText();
				String Class=(String) txtClass.getSelectedItem();
				try {
					Connection con= Connector.getCon();
					String q1 ="select name,enroll from student_details where rollno='"+roll+"' and class='"+Class+"';";
					PreparedStatement pstmt1 = con.prepareStatement(q1);
					ResultSet rs1=pstmt1.executeQuery();
					rs1.next();
					/*System.out.println(rs1.getString(1));*/
					txtStdName.setText("  "+rs1.getString(1));
					enroll=rs1.getString(2);
					String q ="select count(enroll) from issuebook where enroll='"+rs1.getString(2)+"';";
					PreparedStatement pstmt = con.prepareStatement(q);
					ResultSet rs=pstmt.executeQuery();
					rs.next();
					int a = rs.getInt(1);
					/*System.out.println(a);*/
					if(a==1) {
						String q2 ="select count(issuedbook1) from issuebook where enroll='"+rs1.getString(2)+"' and action1='issued';";
						PreparedStatement pstmt2 = con.prepareStatement(q2);
						ResultSet rs2=pstmt2.executeQuery();
						rs2.next();
						issb+=rs2.getInt(1);
						/*System.out.println(issb);*/
						String q3 ="select count(issuedbook2) from issuebook where enroll='"+rs1.getString(2)+"' and action1='issued';";
						PreparedStatement pstmt3 = con.prepareStatement(q3);
						ResultSet rs3=pstmt3.executeQuery();
						rs3.next();
						issb+=rs3.getInt(1);
						/*System.out.println(issb);*/
						
					}
					txtIssuedBook.setText(String.valueOf(issb));
					if(issb==2) {
					JOptionPane.showMessageDialog(contentPane, "Your treasure is full ,you can't get book");
					txtBookID.setEnabled(false);
					btn_search_book.setEnabled(false);
					btn_issue.setEnabled(false);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					/*System.out.println("aye mi ith ahe");*/
					JOptionPane.showMessageDialog(contentPane, "Student is not present ");
				}
			}
		});
		
		btn_issue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IssuedBookDB issue=new IssuedBookDB(enroll, txtBookID.getText(),issb);
				boolean f=issue.insertedDB();
				if(f) {
					JOptionPane.showMessageDialog(contentPane, "Book issued successfully ...");
					txtBookID.setText(null);
					txtBookName.setText(null);
					issb+=1;
					txtIssuedBook.setText(String.valueOf(issb));
					if(issb==2) {
						txtBookID.setEnabled(false);
						btn_search_book.setEnabled(false);
						btn_issue.setEnabled(false);
						}
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Failed to issue book, try again ...");
				}
			}
		});
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		panel_add_1.setLayout(grid);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=30;
		gbc.gridx=0; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,20);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(lblRollNo,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=100;
		gbc.ipady=30;
		gbc.gridx=1; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(txtRoll,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=30;
		gbc.gridx=2; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,20);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(lblClass,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=100;
		gbc.ipady=30;
		gbc.gridx=3; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,150);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(txtClass,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=100;
		gbc.ipady=30;
		gbc.gridx=4; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(btn_search,gbc);
		
		
		
		
		panel_add.add(panel_add_1,BorderLayout.NORTH);
		
		
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		gbc1.fill= GridBagConstraints.HORIZONTAL;
		gbc1.ipadx=0;
		gbc1.ipady=30;
		gbc1.gridx=0; 
		gbc1.gridy=0;
		gbc1.anchor =GridBagConstraints.WEST;
		gbc1.insets = new Insets(30,0,30,10);
		panel_add_2.add(lblStdName,gbc1);
		
		gbc1.ipadx=600;
		gbc1.ipady=30;
		gbc1.gridx=1; 
		gbc1.gridy=0;
		gbc1.gridwidth=4;
		gbc1.insets = new Insets(30,0,30,100);
		panel_add_2.add(txtStdName,gbc1);
		
		gbc1.ipadx=0;
		gbc1.ipady=30;
		gbc1.gridx=5; 
		gbc1.gridy=0;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(0,0,0,10);
		panel_add_2.add(lblIssuedBook,gbc1);
		
		gbc1.ipadx=50;
		gbc1.ipady=30;
		gbc1.gridx=6; 
		gbc1.gridy=0;
		gbc1.insets = new Insets(30,0,30,100);
		gbc1.anchor =GridBagConstraints.CENTER;
		panel_add_2.add(txtIssuedBook,gbc1);
		

		gbc1.fill= GridBagConstraints.HORIZONTAL;
		gbc1.ipadx=0;
		gbc1.ipady=30;
		gbc1.gridx=0; 
		gbc1.gridy=1;
		gbc1.anchor =GridBagConstraints.WEST;
		gbc1.insets = new Insets(30,0,30,10);
		panel_add_2.add(lblBookID,gbc1);
		
		gbc1.ipadx=200;
		gbc1.ipady=30;
		gbc1.gridx=1; 
		gbc1.gridy=1;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(30,0,30,100);
		panel_add_2.add(txtBookID,gbc1);
		
		gbc1.ipadx=0;
		gbc1.ipady=30;
		gbc1.gridx=3; 
		gbc1.gridy=1;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(0,0,0,10);
		panel_add_2.add(btn_search_book,gbc1);
		
		gbc1.ipadx=50;
		gbc1.ipady=30;
		gbc1.gridx=0; 
		gbc1.gridy=2;
		gbc1.insets = new Insets(30,0,30,100);
		panel_add_2.add(lblBookName,gbc1);
		
		gbc1.ipadx=600;
		gbc1.ipady=30;
		gbc1.gridx=1; 
		gbc1.gridy=2;
		gbc1.gridwidth=4;
		gbc1.insets = new Insets(30,0,30,100);
		panel_add_2.add(txtBookName,gbc1);
		
		gbc1.ipadx=100;
		gbc1.ipady=30;
		gbc1.gridx=0; 
		gbc1.gridy=3;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(30,0,30,100);
		panel_add_2.add(btn_issue,gbc1);
		
		gbc1.ipadx=100;
		gbc1.ipady=30;
		gbc1.gridx=5; 
		gbc1.gridy=3;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(30,0,30,0);
		panel_add_2.add(btn_reset,gbc1);
		
		
		
		panel_add.add(panel_add_2,BorderLayout.CENTER);

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
