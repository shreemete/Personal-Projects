package com.Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;

public class LibrarianLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLogin frame = new LibrarianLogin();
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
	public LibrarianLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LibrarianLogin.class.getResource("/images/Logo1.jpg")));
		setTitle("GRWPL Library Management System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		Toolkit tkt = Toolkit.getDefaultToolkit();
		int xsize = (int)tkt.getScreenSize().getWidth();
		int ysize = (int)tkt.getScreenSize().getHeight();*/
		
		setSize(938, 585);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 100, 100));
		contentPane.setBorder(new EmptyBorder(0, 0, 5, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-1522, -1870, 1952, 2442);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setBounds(new Rectangle(47, 23, 800, 900));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(LibrarianLogin.class.getResource("/images/library2.jpg")));
		panel.add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Gadugi", Font.PLAIN, 20));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(473, 152, 100, 34);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Gadugi", Font.PLAIN, 20));
		lblPassword.setBounds(473, 248, 100, 34);
		contentPane.add(lblPassword);
		
		JButton btnAminLogin = new JButton("Librarian Login");
		btnAminLogin.setEnabled(false);
		btnAminLogin.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnAminLogin.setBorder(UIManager.getBorder("Button.border"));
		btnAminLogin.setFont(new Font("Gadugi", Font.BOLD, 25));
		btnAminLogin.setForeground(new Color(10,10,10));
		btnAminLogin.setBackground(Color.WHITE);
		btnAminLogin.setBounds(540, 39, 228, 53);
		contentPane.add(btnAminLogin);
		
		textField = new JTextField("Enter Username");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("Enter Username")){
					textField.setText("");
					textField.setForeground(new Color(255,255,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals("")){
					textField.setText("Enter Username");
					textField.setForeground(new Color(200,200,200));
				}
			}
		});
		textField.setMargin(new Insets(2, 10, 2, 2));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setForeground(new Color(200, 200, 200));
		textField.setBorder(new LineBorder(new Color(255, 255, 255)));
		textField.setBackground(new Color(10, 10, 10));
		textField.setBounds(605, 149, 235, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user= textField.getText();
				String pass= passwordField.getText();
				
				if(user.equals("librarian") && pass.equals("librarian@123")) {
					dispose();
					NewLibrarianPage admPage= new NewLibrarianPage();
					admPage.show();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Invalid Username and Password...");
				}
			}
		});
		btnLogin.setForeground(new Color(10, 10, 10));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Gadugi", Font.BOLD, 18));
		btnLogin.setBounds(494, 359, 118, 48);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("Enter Username");
				passwordField.setText("Password");
			}
		});
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(10, 10, 10));
		btnReset.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnReset.setFont(new Font("Gadugi", Font.BOLD, 18));
		btnReset.setBounds(702, 359, 118, 48);
		contentPane.add(btnReset);
		
		passwordField = new JPasswordField("Password");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordField.getText().equals("Password")){
					passwordField.setText("");
					passwordField.setForeground(new Color(255,255,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().equals("")){
					passwordField.setText("Password");
					passwordField.setForeground(new Color(200,200,200));
				}
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBorder(new LineBorder(new Color(255, 255, 255)));
		passwordField.setForeground(new Color(200, 200, 200));
		passwordField.setBackground(new Color(10, 10, 10));
		passwordField.setBounds(605, 245, 235, 48);
		contentPane.add(passwordField);
		
		JButton btnBlack = new JButton("BACK\r\n");
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WelcomePage welcome = new WelcomePage();
				welcome.show();
			}
		});
		btnBlack.setBackground(new Color(255, 255, 255));
		btnBlack.setForeground(new Color(10,10,10));
		btnBlack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBlack.setBounds(814, 13, 94, 48);
		contentPane.add(btnBlack);
	}
}
