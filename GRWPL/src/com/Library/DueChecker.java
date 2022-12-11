package com.Library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class DueChecker extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DueChecker frame = new DueChecker();
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
	private JTextField textField_3,textField_2,textField_1,textField;
	int dues=0;
	String enroll,name,dueDate;
	public DueChecker() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomePage.class.getResource("/images/Logo1.jpg")));
		setTitle("GRWPL Library Management System");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 497);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblStudentDues = new JLabel("Student Dues");
		lblStudentDues.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentDues.setBounds(74, 13, 225, 36);
		getContentPane().add(lblStudentDues); 
		
		JLabel lblRollNo = new JLabel("Roll No.");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRollNo.setBounds(74, 78, 90, 30);
		getContentPane().add(lblRollNo);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(176, 75, 113, 37);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClass.setBounds(342, 78, 90, 30);
		getContentPane().add(lblClass);
		
		String s[] = {"Select","C01","C02","C03","CE1","CE2","CE3","DD1","DD2","DD3","E&TC1","E&TC2","E&TC3","MU1","MU2","MU3"};
		JComboBox comboBox = new JComboBox<>(s);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(424, 77, 106, 37);
		getContentPane().add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(624, 79, 97, 30);
		getContentPane().add(btnSearch);
		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setBounds(0, 154, 811, 11);
		getContentPane().add(separator);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(74, 204, 56, 16);
		getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setEditable(false);
		textField_1.setBounds(173, 193, 548, 42);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDue = new JLabel("Dues");
		lblDue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDue.setBounds(74, 293, 56, 16);
		getContentPane().add(lblDue);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setEditable(false);
		textField_2.setBounds(173, 279, 116, 42);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(605, 279, 116, 42);
		getContentPane().add(textField_3);
		
		JLabel lblPayDues = new JLabel("Pay Dues");
		lblPayDues.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPayDues.setBounds(464, 277, 113, 48);
		getContentPane().add(lblPayDues);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(74, 363, 97, 37);
		getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals(textField_3.getText())) {
					try {
						Connection con = Connector.getCon();
						String q = "update issuebook set due=? where enroll=? and not (action1='issued' and action2='issued' )";
						
						PreparedStatement pstmt = con.prepareStatement(q);
						pstmt.setInt(1, 0);
						pstmt.setString(2, enroll);
						/*System.out.println(q);*/
						int n =pstmt.executeUpdate();
						if(n==1) {
							JOptionPane.showMessageDialog(contentPane, "Student paid dues successfully... ");
						}else {
							JOptionPane.showMessageDialog(contentPane, "Student didn't return the books yet.... ");
						}
					}catch(Exception e2) {
						e2.printStackTrace();
						
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "pay complete dues...");
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(new Rectangle(232, 656, 100, 50));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(624, 363, 97, 37);
		getContentPane().add(btnCancel, BorderLayout.CENTER);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String roll=textField.getText();
				String stdClass=String.valueOf(comboBox.getSelectedItem());
				
				
				try {
					Connection con = Connector.getCon();
					String q="select enroll,name from student_details where rollno=? and class=?";
					PreparedStatement pstmt = con.prepareStatement(q);
					pstmt.setString(1, roll);
					pstmt.setString(2, stdClass);
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					enroll=rs.getString(1);
					name=rs.getString(2);
					//===========================================================
					String q1="select due from issuebook where enroll=?;";
					PreparedStatement pstmt1 = con.prepareStatement(q1);
					pstmt1.setString(1, enroll);
					ResultSet rs1 = pstmt1.executeQuery();
					if(rs1.next()) {
						dues=rs1.getInt(1);
						
					}
					//=============================================
					
					SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date= new Date();
					String currentDate= myFormat.format(date);
					
					String q2="select due_date1 from issuebook where enroll=? and action1='issued';";
					PreparedStatement pstmt2 = con.prepareStatement(q2);
					pstmt2.setString(1, enroll);
					ResultSet rs2 = pstmt2.executeQuery();
					if(rs2.next()) {
						
						
						dueDate=rs2.getString(1);
						try {
						    Date date1 = myFormat.parse(dueDate);
						    Date date2 = myFormat.parse(currentDate);
						    long diff = date2.getTime() - date1.getTime();
						    int d = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						    System.out.println(d);
						    if(d>=0) {
						    	dues+=d;
						    }
						} catch (ParseException e1) {
						    e1.printStackTrace();
						}
					}
					
					
					
					
					//=============================================
					String q3="select due_date2 from issuebook where enroll=? and action2='issued';";
					PreparedStatement pstmt3 = con.prepareStatement(q3);
					pstmt3.setString(1, enroll);
					ResultSet rs3 = pstmt3.executeQuery();
					if(rs3.next()) {
						dueDate=rs3.getString(1);
					
					try {
					    Date date1 = myFormat.parse(dueDate);
					    Date date2 = myFormat.parse(currentDate);
					    long diff = date1.getTime() - date2.getTime();
					    int d = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
					    System.out.println(d);
					    if(d>=0) {
					    	dues+=d;
					    }
					} catch (ParseException e1) {
					    e1.printStackTrace();
					}
					}
					
					//=================================================
					textField_1.setText(name);
					textField_2.setText(String.valueOf(dues));
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

}
