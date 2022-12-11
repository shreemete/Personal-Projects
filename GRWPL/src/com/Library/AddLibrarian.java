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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddLibrarian extends JFrame {

	private JPanel contentPane;
	

	private JTextField txtEnterName;
	private JTextField txtEnterEmail;
	private JTextField txtEnterMobileNo;
	private JTextField txtEnterAddress;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLibrarian frame = new AddLibrarian();
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
	public AddLibrarian() {
		setTitle("GRWPL Library Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddLibrarian.class.getResource("/images/Logo1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 754, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new LineBorder(new Color(211, 211, 211)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	/*	Toolkit tkt = Toolkit.getDefaultToolkit();
		int xsize = (int)tkt.getScreenSize().getWidth();
		int ysize = (int)tkt.getScreenSize().getHeight();
		*/
		setSize(754, 650);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ADD LIBRARIAN");
		lblNewLabel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Mangal", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 28, 258, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Mangal", Font.PLAIN, 20));
		btnBack.setForeground(new Color(106, 90, 205));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setBounds(586, 28, 115, 41);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(96, 121, 120, 38);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblEmail.setBounds(96, 189, 120, 38);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Mobile No.\r\n");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblUsername.setBounds(96, 265, 120, 38);
		contentPane.add(lblUsername);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblAddress.setBounds(96, 338, 120, 38);
		contentPane.add(lblAddress);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Mangal", Font.PLAIN, 18));
		lblPassword.setBounds(96, 418, 120, 38);
		contentPane.add(lblPassword);
		
		txtEnterName = new JTextField();
		txtEnterName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterName.getText().equals("Enter Name")) {
					txtEnterName.setText("");
					txtEnterName.setForeground(new Color(255,255,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterName.getText().equals("")) {
					txtEnterName.setText("Enter Name");
					txtEnterName.setForeground(new Color(200,200,200));
				}
			}
		});
		txtEnterName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterName.setFont(new Font("Mangal", Font.PLAIN, 16));
		txtEnterName.setText("Enter Name");
		txtEnterName.setForeground(new Color(200, 200, 200));
		txtEnterName.setBackground(new Color(106, 90, 205));
		txtEnterName.setBounds(228, 121, 308, 38);
		contentPane.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		txtEnterEmail = new JTextField();
		txtEnterEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterEmail.getText().equals("Enter Email")) {
					txtEnterEmail.setText("");
					txtEnterEmail.setForeground(new Color(255,255,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterEmail.getText().equals("")) {
					txtEnterEmail.setText("Enter Email");
					txtEnterEmail.setForeground(new Color(200,200,200));
				}
			}
		});
		txtEnterEmail.setText("Enter Email");
		txtEnterEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterEmail.setForeground(SystemColor.scrollbar);
		txtEnterEmail.setFont(new Font("Mangal", Font.PLAIN, 16));
		txtEnterEmail.setColumns(10);
		txtEnterEmail.setBackground(new Color(106, 90, 205));
		txtEnterEmail.setBounds(228, 189, 308, 38);
		contentPane.add(txtEnterEmail);
		
		txtEnterMobileNo = new JTextField();
		txtEnterMobileNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterMobileNo.getText().equals("Enter Mobile No.")) {
					txtEnterMobileNo.setText("");
					txtEnterMobileNo.setForeground(new Color(255,255,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterMobileNo.getText().equals("")) {
					txtEnterMobileNo.setText("Enter Mobile No.");
					txtEnterMobileNo.setForeground(new Color(200,200,200));
				}
			}
		});
		txtEnterMobileNo.setText("Enter Mobile No.");
		txtEnterMobileNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterMobileNo.setForeground(SystemColor.scrollbar);
		txtEnterMobileNo.setFont(new Font("Mangal", Font.PLAIN, 16));
		txtEnterMobileNo.setColumns(10);
		txtEnterMobileNo.setBackground(new Color(106, 90, 205));
		txtEnterMobileNo.setBounds(228, 265, 308, 38);
		contentPane.add(txtEnterMobileNo);
		
		txtEnterAddress = new JTextField();
		txtEnterAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEnterAddress.getText().equals("Enter Address")) {
					txtEnterAddress.setText("");
					txtEnterAddress.setForeground(new Color(255,255,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterAddress.getText().equals("")) {
					txtEnterAddress.setText("Enter Address");
					txtEnterAddress.setForeground(new Color(200,200,200));
				}
			}
		});
		txtEnterAddress.setText("Enter Address");
		txtEnterAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterAddress.setForeground(SystemColor.scrollbar);
		txtEnterAddress.setFont(new Font("Mangal", Font.PLAIN, 16));
		txtEnterAddress.setColumns(10);
		txtEnterAddress.setBackground(new Color(106, 90, 205));
		txtEnterAddress.setBounds(228, 340, 308, 38);
		contentPane.add(txtEnterAddress);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setEchoChar('*');
		pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals("Password")) {
					pwdPassword.setText("");
					pwdPassword.setForeground(new Color(255,255,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setForeground(new Color(255,255,255));
				}
			}
		});
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			int i=0;
			public void actionPerformed(ActionEvent e) {
				if(i==0) {
					pwdPassword.setEchoChar((char)0);
					i++;
				}
				else {
					pwdPassword.setEchoChar('*');
					i--;
				}
			}
		});
		button.setBorder(new LineBorder(new Color(169, 169, 169), 2));
		button.setBackground(new Color(106, 90, 205));
		button.setIcon(new ImageIcon(AddLibrarian.class.getResource("/images/icons8-eye-24.png")));
		button.setBounds(485, 415, 51, 41);
		contentPane.add(button);
		pwdPassword.setForeground(new Color(255, 255, 255));
		pwdPassword.setBackground(new Color(106, 90, 205));
		pwdPassword.setText("Password");
		pwdPassword.setBounds(228, 415, 308, 41);
		contentPane.add(pwdPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianDb libDb =new LibrarianDb(txtEnterName.getText(), txtEnterEmail.getText(), txtEnterMobileNo.getText(), txtEnterAddress.getText(), pwdPassword.getText());
		boolean f=libDb.insertLib();
				if(f) {
					JOptionPane.showMessageDialog(contentPane, "Successfully added Librarian");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Something went wrong try again...");
				}
			}
		});
		btnSubmit.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		btnSubmit.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(106, 90, 205));
		btnSubmit.setBounds(96, 516, 120, 41);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwdPassword.setText("Password");
				txtEnterName.setText("Enter Name");
				txtEnterAddress.setText("Enter Address");
				txtEnterMobileNo.setText("Enter Mobile No.");
				txtEnterEmail.setText("Enter Email");
			}
		});
		btnReset.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnReset.setForeground(new Color(106, 90, 205));
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(408, 516, 128, 41);
		contentPane.add(btnReset);
	}

}
