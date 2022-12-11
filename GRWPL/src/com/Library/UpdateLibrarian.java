package com.Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UpdateLibrarian extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String email ;
	String [] details = new String [4];
	int status;
	librarian old_values;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public UpdateLibrarian(String email) throws Exception {
		setTitle("GRWPL Library Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateLibrarian.class.getResource("/images/Logo1.jpg")));
		givenString( email);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize( 732, 605);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateDetails = new JLabel("UPDATE DETAILS");
		lblUpdateDetails.setBorder(new LineBorder(new Color(250, 250, 210), 2));
		lblUpdateDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateDetails.setFont(new Font("Mangal", Font.BOLD, 24));
		lblUpdateDetails.setForeground(new Color(250, 250, 210));
		lblUpdateDetails.setBounds(61, 42, 242, 46);
		contentPane.add(lblUpdateDetails);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblName.setForeground(new Color(250, 240, 230));
		lblName.setBounds(105, 146, 78, 39);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(new Color(250, 240, 230));
		lblEmail.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblEmail.setBounds(105, 218, 73, 31);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setForeground(new Color(250, 240, 230));
		lblAddress.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblAddress.setBounds(105, 275, 73, 31);
		contentPane.add(lblAddress);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobile.setForeground(new Color(250, 240, 230));
		lblMobile.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblMobile.setBounds(105, 340, 73, 31);
		contentPane.add(lblMobile);
		this.email=email;
		textField = new JTextField(old_values.name);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(237, 148, 281, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(old_values.email);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(237, 210, 281, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField(old_values.address);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(237, 275, 281, 39);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField(old_values.mobile);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(237, 340, 281, 39);
		contentPane.add(textField_3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				librarian o=new librarian();
				o.name=textField.getText();
				o.email =textField_1.getText();
				o.mobile =textField_3.getText();
				o.address =textField_2.getText();
				
				Connection con;
				try {
					con = Connector.getCon();
					String q="update librarian_table set name=?,email=?,mobile=?,address=? where email=?";
					PreparedStatement pstmt = con.prepareStatement(q);
					
					pstmt.setString(1,o.name);
					pstmt.setString(2,o.email);
					pstmt.setString(3,o.mobile);
					pstmt.setString(4,o.address);
					pstmt.setString(5,email);
					status=pstmt.executeUpdate();
					if(status==1) {
						librarian.name=o.name;
						librarian.email=o.email;
						librarian.mobile=o.mobile;
						
						librarian.address=o.address;
						//librarian.pass=pass1;
						librarian.update_status=status;
					}else {
						librarian.update_status=status;
					}
					JOptionPane.showMessageDialog(contentPane, "Successfully updated...");
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					status=0;
					JOptionPane.showMessageDialog(contentPane, "Failed to update...");
				}
				
			}
		});
		btnUpdate.setFont(new Font("Mangal", Font.BOLD, 18));
		btnUpdate.setForeground(new Color(106, 90, 205));
		btnUpdate.setBackground(new Color(250, 250, 210));
		btnUpdate.setBounds(92, 452, 113, 39);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(details[0]);
				textField_1.setText(details[1]);
				textField_2.setText(details[2]);
				textField_3.setText(details[3]);
			}
		});
		btnReset.setForeground(new Color(106, 90, 205));
		btnReset.setFont(new Font("Mangal", Font.BOLD, 18));
		btnReset.setBackground(new Color(250, 250, 210));
		btnReset.setBounds(447, 452, 113, 39);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnBack.setForeground(new Color(106, 90, 205));
		btnBack.setFont(new Font("Mangal", Font.BOLD, 20));
		btnBack.setBackground(new Color(250, 250, 210));
		btnBack.setBounds(521, 42, 113, 39);
		contentPane.add(btnBack);
	}
	
	

	private void givenString(String s) throws Exception {
		
		Connection con= Connector.getCon();
		String q1 ="select * from librarian_table where email = '"+s+"';";
		PreparedStatement pstmt1 = con.prepareStatement(q1);
		ResultSet rs1=pstmt1.executeQuery();
		if(rs1.next()) {
			old_values.name=rs1.getString(1);
			old_values.email=rs1.getString(2);
			old_values.address=rs1.getString(4);
			old_values.mobile=rs1.getString(3);
		}
		
		
		
	}
}
