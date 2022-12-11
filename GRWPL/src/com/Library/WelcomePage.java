package com.Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JWindow;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class WelcomePage extends JFrame {

	private JPanel contentPane;
	Timer timer;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
					frame.welcomeScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    private void welcomeScreen() {
		
		JWindow w = new JWindow(this);
		w.setSize(800,500);
		w.getContentPane().setBackground(Color.RED);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		
		
		((JComponent) w.getContentPane()).setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		JProgressBar pg = new JProgressBar(0,100);
		w.getContentPane().add(BorderLayout.PAGE_END,pg);
		
		timer = new Timer(100,new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = pg.getValue();
				if(x==100) {
					w.dispose();
					WelcomePage.this.setVisible(true);
					timer.stop();
				}else {
					pg.setValue(x+=4);
				}
				x+=10;
			}
			
		});
		timer.start();
	}

	/**
	 * Create the frame.
	 */
	public WelcomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomePage.class.getResource("/images/Logo1.jpg")));
		setTitle("GRWPL Library Management System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setSize( 1069, 670);
		
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnWelcomeToGrwpl = new JTextPane();
		txtpnWelcomeToGrwpl.setEditable(false);
		txtpnWelcomeToGrwpl.setForeground(Color.WHITE);
		txtpnWelcomeToGrwpl.setBackground(new Color(100,100,100));
		txtpnWelcomeToGrwpl.setFont(new Font("MS UI Gothic", Font.PLAIN, 39));
		txtpnWelcomeToGrwpl.setText("\r\n\tWelcome to GRWPL Library Management System");
		txtpnWelcomeToGrwpl.setBounds(48, 121, 961, 132);
		contentPane.add(txtpnWelcomeToGrwpl);
		
		JButton btnLibrarianLogin = new JButton("Librarian Login");
		btnLibrarianLogin.setBorder(new LineBorder(new Color(100,100,100), 5));
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LibrarianLogin libLog= new LibrarianLogin();
				libLog.show();
				dispose();
			}
		});
		btnLibrarianLogin.setForeground(new Color(10, 10, 10));
		btnLibrarianLogin.setBackground(new Color(255, 255, 255));
		btnLibrarianLogin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));
		btnLibrarianLogin.setBounds(434, 381, 203, 60);
		contentPane.add(btnLibrarianLogin);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setIcon(new ImageIcon(WelcomePage.class.getResource("/images/library6.jpg")));
		label.setBounds(-2410, -964, 3475, 1602);
		contentPane.add(label);
	}
}
