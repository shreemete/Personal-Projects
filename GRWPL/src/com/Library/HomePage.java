package com.Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1388, 746);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		JButton button1 = new JButton("Button One");
		JButton button2 = new JButton("Button Two");
		JButton button3 = new JButton("Button Three");
		JButton button4 = new JButton("Button Four");
		JButton button5 = new JButton("Button Five");
		JButton button6 = new JButton("Button Six");
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=200;
		gbc.ipady=150;
		//Adding the button1 to 0th x-coordinate of 0th column, at WEST
		gbc.gridx=0; 
		gbc.gridy=0;
		gbc.anchor =GridBagConstraints.WEST;
		gbl_contentPane.setConstraints(button1,gbc);


		//Adding the button2 to 1st x-coordinate of 0th column, at EAST
		gbc.gridx=2; 
		gbc.gridy=0;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0,10,0,0);
		gbc.anchor =GridBagConstraints.EAST; 
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbl_contentPane.setConstraints(button2, gbc);

		//Padding with vertical space of 50 pixels around the next added buttons
		gbc.ipady=100;


		//Adding button3 to 0th x-coordinate of 1st column, at CENTER
		gbc.gridx=0; 
		gbc.gridy=1;
		gbc.anchor =GridBagConstraints.CENTER; 
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbl_contentPane.setConstraints(button3,gbc);


		gbc.ipady=0;
		//Adding button5 to 0th x-coordinate of 2nd column, at WEST
		gbc.gridx=0; 
		gbc.gridy=2;
		gbc.fill= GridBagConstraints.NONE;
		gbc.anchor =GridBagConstraints.WEST; 
		gbl_contentPane.setConstraints(button4,gbc);


		//Adding button6 to 1st x-coordinate of 2nd column, at CENTER
		gbc.gridx=1; 
		gbc.gridy=2;
		gbc.anchor =GridBagConstraints.CENTER; 
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbl_contentPane.setConstraints(button5,gbc);


		//Adding button7 to 2nd x-coordinate of 2nd column, at EAST
		gbc.gridx=2; 
		gbc.gridy=2;
		gbc.anchor =GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbl_contentPane.setConstraints(button6,gbc);
		
		
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(button4);
		contentPane.add(button5);
		contentPane.add(button6);
		
		contentPane.setLayout(gbl_contentPane);
	}

}
