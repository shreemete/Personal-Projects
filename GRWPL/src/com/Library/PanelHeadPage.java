package com.Library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelHeadPage extends JFrame{
	private JPanel panel;
	private JLabel lbl1,lbl2;
	public PanelHeadPage(JPanel panel,JFrame delframe) {
		this.panel=panel;
		panel.setBackground(new Color(100,100,100));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0,0));
		
		lbl1=new JLabel("GRWPL Library Management");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				delframe.dispose();
				LibrarianLogin lb = new LibrarianLogin();
				lb.setVisible(true);
			}
		});
		
		button.setFont(new Font("Mangal", Font.PLAIN, 24));
		lbl1.setFont(new Font("Mangal", Font.BOLD, 32));
		lbl1.setForeground(Color.white);
		button.setForeground(Color.white);
		button.setBackground(new Color(100,100,100));
		button.setBorder(new EmptyBorder(0, 25, 0, 25));
		panel.add(lbl1,BorderLayout.WEST);
		panel.add(button,BorderLayout.EAST);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(Color.white);
				button.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(100,100,100));
				button.setForeground(Color.white);
			}
		});
	}
}
