package com.Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Toolkit;

public class DeleteLibrarian extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterLibrarianName;
	private JTextField txtEmail;
	private JTextField txtMobile;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteLibrarian frame = new DeleteLibrarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteLibrarian() {
		setTitle("GRWPL Library Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteLibrarian.class.getResource("/images/Logo1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 552);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteLibrarian = new JLabel("DELETE LIBRARIAN");
		lblDeleteLibrarian.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		lblDeleteLibrarian.setFont(new Font("Mangal", Font.BOLD, 20));
		lblDeleteLibrarian.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteLibrarian.setForeground(new Color(255, 255, 255));
		lblDeleteLibrarian.setBounds(69, 45, 234, 53);
		contentPane.add(lblDeleteLibrarian);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBorder(null);
		btnBack.setForeground(new Color(106, 90, 205));
		btnBack.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setBounds(642, 45, 97, 45);
		contentPane.add(btnBack);
		
		txtEnterLibrarianName = new JTextField();
		txtEnterLibrarianName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtEnterLibrarianName.getText().equals("Enter Librarian Email")) {
					txtEnterLibrarianName.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterLibrarianName.getText().equals("")) {
					txtEnterLibrarianName.setText("Enter Librarian Email");
				}
			}
		});
		txtEnterLibrarianName.setForeground(new Color(72, 61, 139));
		txtEnterLibrarianName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEnterLibrarianName.setText("Enter Librarian Email");
		txtEnterLibrarianName.setBounds(69, 127, 283, 40);
		contentPane.add(txtEnterLibrarianName);
		txtEnterLibrarianName.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(123, 104, 238));
		panel.setBorder(null);
		panel.setBounds(69, 203, 670, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setForeground(new Color(72, 61, 139));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setText("Name");
		txtEmail.setBounds(50, 31, 249, 46);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setEditable(false);
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMobile.setForeground(new Color(72, 61, 139));
		txtMobile.setText("Mobile");
		txtMobile.setColumns(10);
		txtMobile.setBounds(381, 31, 249, 46);
		panel.add(txtMobile);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setForeground(new Color(72, 61, 139));
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setText("Address");
		txtAddress.setColumns(10);
		txtAddress.setBounds(50, 117, 580, 46);
		panel.add(txtAddress);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		btnNewButton.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(106, 90, 205));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con= Connector.getCon();
					String q1 ="select * from librarian_table where email='"+txtEnterLibrarianName.getText()+"';";
					PreparedStatement pstmt1 = con.prepareStatement(q1);
					ResultSet rs1=pstmt1.executeQuery();
					rs1.next();
					txtEmail.setText(rs1.getString(1));
					txtMobile.setText(rs1.getString(3));
					txtAddress.setText(rs1.getString(4));
					
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "Invalid Librarian Email");
				}
				
			}
		});
		btnNewButton.setBounds(450, 127, 97, 40);
		contentPane.add(btnNewButton);
		
		
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con= Connector.getCon();
					String q2 ="delete from  librarian_table where email='"+txtEnterLibrarianName.getText()+"';";
					PreparedStatement pstmt2 = con.prepareStatement(q2);
					pstmt2.executeUpdate();
					JOptionPane.showMessageDialog(contentPane, "Successfully Deleted...");
					dispose();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnDelete.setForeground(new Color(106, 90, 205));
		btnDelete.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnDelete.setBorder(null);
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(579, 441, 160, 45);
		contentPane.add(btnDelete);
	}
}
