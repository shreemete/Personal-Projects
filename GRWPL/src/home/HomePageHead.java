package home;

import java.awt.*;
import javax.swing.*;

public class HomePageHead  {
	
	private JPanel homePane;
	public HomePageHead(JPanel homePane,String head){
		this.homePane=homePane;
		JLabel home_lbl=new JLabel(head);
		home_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		home_lbl.setFont(new Font("Mangal", Font.BOLD, 32));
		this.homePane.add(home_lbl);
	}
}
