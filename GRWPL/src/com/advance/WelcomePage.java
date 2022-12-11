package com.advance;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class WelcomePage extends JFrame{
	Timer timer;
	public WelcomePage() {
		
		getContentPane().setBackground(Color.YELLOW);
		setSize(678,631);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().add(new JLabel("Welcome"));
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
					timer.stop();
				}else {
					pg.setValue(x+=4);
				}
				x+=10;
			}
			
		});
		timer.start();
	}
	public static void main(String[] args) {
		WelcomePage wp =new WelcomePage();
		wp.welcomeScreen();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wp.setVisible(true);
		
	}
	
}
