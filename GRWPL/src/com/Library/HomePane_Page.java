package com.Library;

import java.awt.*;
import javax.swing.*;

public class HomePane_Page  {
	
	private JPanel homePane;
	HomePane_Page(JPanel homePane){
		this.homePane=homePane;
		this.homePane.setLayout(new BorderLayout());
		JLabel home_lbl=new JLabel("	Home Page");
		home_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		home_lbl.setFont(new Font("Mangal", Font.BOLD, 32));
		this.homePane.add(home_lbl,BorderLayout.WEST);
	}
}