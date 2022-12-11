package com.Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setTitle("GRWPL Library Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPage.class.getResource("/images/Logo1.jpg")));
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		Toolkit tkt = Toolkit.getDefaultToolkit();
		int xsize = (int)tkt.getScreenSize().getWidth();
		int ysize = (int)tkt.getScreenSize().getHeight();
		*/
		setSize( 805, 628);
		setLocationRelativeTo(null);
		
		//setBounds(100, 100, 805, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddLibrarian = new JButton("ADD LIBRARIAN");
		btnAddLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLibrarian addLib = new AddLibrarian();
				addLib.show();
			}
		});
		btnAddLibrarian.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnAddLibrarian.setForeground(new Color(106, 90, 205));
		btnAddLibrarian.setBackground(new Color(255, 255, 255));
		btnAddLibrarian.setBounds(530, 165, 220, 53);
		contentPane.add(btnAddLibrarian);
		
		JButton btnViewLibrarian = new JButton("VIEW LIBRARIAN");
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLibrarian viewLib = new ViewLibrarian();
				viewLib.show();
			}
		});
		btnViewLibrarian.setForeground(new Color(106, 90, 205));
		btnViewLibrarian.setBackground(new Color(255, 255, 255));
		btnViewLibrarian.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnViewLibrarian.setBounds(530, 285, 228, 53);
		contentPane.add(btnViewLibrarian);
		
		JButton btnDeleteLibrarian = new JButton("DELETE LIBRARIAN");
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteLibrarian DelLib = new DeleteLibrarian();
				DelLib.show();
			}
		});
		btnDeleteLibrarian.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnDeleteLibrarian.setForeground(new Color(106, 90, 205));
		btnDeleteLibrarian.setBackground(new Color(255, 255, 255));
		btnDeleteLibrarian.setBounds(530, 417, 228, 53);
		contentPane.add(btnDeleteLibrarian);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLogin admLog = new AdminLogin();
				admLog.show();
			}
		});
		btnLogout.setFont(new Font("Mangal", Font.PLAIN, 18));
		btnLogout.setForeground(new Color(106, 90, 205));
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setBounds(530, 53, 220, 53);
		contentPane.add(btnLogout);
		
		JPanel panel = new JPanel();
		panel.setBounds(-361, -722, 779, 1340);
		contentPane.add(panel);
		panel.setLayout(null);
		ImageIcon img = new ImageIcon(AdminPage.class.getResource("/images/library4.jpg"));
		img.setImage(img.getImage().getScaledInstance(779, 1340, Image.SCALE_DEFAULT));
		
		JButton btnAdminPage = new JButton("ADMIN PAGE");
		btnAdminPage.setFocusTraversalKeysEnabled(false);
		btnAdminPage.setBorderPainted(false);
		btnAdminPage.setForeground(new Color(255, 255, 255));
		btnAdminPage.setBackground(new Color(106, 90, 205));
		btnAdminPage.setFont(new Font("Mangal", Font.BOLD, 25));
		btnAdminPage.setBounds(457, 964, 222, 61);
		panel.add(btnAdminPage);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(106, 90, 205));
		label.setForeground(new Color(245, 245, 220));
		label.setIcon(img);
		label.setBounds(134, 314, 706, 1199);
		panel.add(label);
	}

}
