package com.Library;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddQuantity extends JFrame {


	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private static String ID;
	private static String Name;
	private static String qty;
	book old_values;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuantity frame = new AddQuantity();
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
	int status;
	public AddQuantity() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomePage.class.getResource("/images/Logo1.jpg")));
		setTitle("GRWPL Library Management System");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 512);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunatity = new JLabel("Quantity");
		lblQunatity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQunatity.setBounds(97, 247, 89, 30);
		contentPane.add(lblQunatity);
		
		textField_2 = new JTextField("0");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(198, 243, 353, 38);
		contentPane.add(textField_2);
		
		
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookName.setBounds(97, 170, 100, 30);
		contentPane.add(lblBookName);
		
		textField_3 = new JTextField(AddQuantity.Name);
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(198, 166, 353, 38);
		contentPane.add(textField_3);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookId.setBounds(97, 103, 89, 30);
		contentPane.add(lblBookId);
		
		textField = new JTextField(AddQuantity.ID);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(198, 99, 353, 38);
		contentPane.add(textField);
		
		JLabel lblAddQuantity = new JLabel("Add Book Quantity");
		lblAddQuantity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddQuantity.setBounds(55, 24, 239, 46);
		contentPane.add(lblAddQuantity);
		
		JButton btnAddQuantity = new JButton("Add Quantity");
		btnAddQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book o = new book();
				o.qty= String.valueOf(Integer.parseInt(textField_2.getText())+Integer.parseInt(AddQuantity.qty));
				
				Connection con;
				try {
					con = Connector.getCon();
					String q="update book_details set quantity=? where book_id=?";
					PreparedStatement pstmt = con.prepareStatement(q);
		
					pstmt.setInt(1,Integer.parseInt(o.qty));
					pstmt.setString(2,AddQuantity.ID);
					
					status=pstmt.executeUpdate();
					if(status==1) {
						book.qty=o.qty;
						//librarian.pass=pass1;
						book.add_status=status;
					}else {
						book.add_status=status;
					}
					JOptionPane.showMessageDialog(contentPane, "Successfully quantity added...");
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					status=0;
					JOptionPane.showMessageDialog(contentPane, "Failed to add...");
				}
			}
		});
		btnAddQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddQuantity.setBounds(83, 345, 140, 30);
		contentPane.add(btnAddQuantity);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBounds(472, 345, 140, 30);
		contentPane.add(btnCancel);
	}
	public static void details(String bookID, String bookName, String quantity) {
		// TODO Auto-generated method stub
		ID=bookID;
		Name=bookName;
		qty=quantity;
		
	}
	private void givenString() throws Exception {
		
		Connection con= Connector.getCon();
		String q1 ="select quantity from book_details where book_id = '"+AddQuantity.ID+"';";
		PreparedStatement pstmt1 = con.prepareStatement(q1);
		ResultSet rs1=pstmt1.executeQuery();
		if(rs1.next()) {
			old_values.qty=rs1.getString(1);
			
		}
		
		
		
	}
}
