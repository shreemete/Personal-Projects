package home;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomePageCenter {
	private JPanel pane_center;
	public HomePageCenter(JPanel pane_center) {
		this.pane_center=pane_center;
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		JButton button1 = new JButton("Button One");
		JButton button2 = new JButton("Button Two");
		JButton button3 = new JButton("Button Three");
		JButton button4 = new JButton("Button Four");
		JButton button5 = new JButton("Button Five");
		//JButton button6 = new JButton("Button Six");
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=200;
		gbc.ipady=150;
		gbc.insets = new Insets(100,0,10,0);
		//Adding the button1 to 0th x-coordinate of 0th column, at WEST
		gbc.gridx=0; 
		gbc.gridy=0;
		gbc.anchor =GridBagConstraints.WEST;
		grid.setConstraints(button1,gbc);


		//Adding the button2 to 1st x-coordinate of 0th column, at EAST
		gbc.gridx=1; 
		gbc.gridy=0;
		
		gbc.insets = new Insets(100,50,10,0);
		gbc.anchor =GridBagConstraints.WEST; 
		//gbc.gridwidth = GridBagConstraints.WEST;
		grid.setConstraints(button2, gbc);

		//Padding with vertical space of 50 pixels around the next added buttons
		//gbc.ipady=100;


		//Adding button3 to 0th x-coordinate of 1st column, at CENTER
		gbc.gridx=2; 
		gbc.gridy=0;
		gbc.insets = new Insets(100,50,10,0);
		gbc.anchor =GridBagConstraints.WEST; 
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		grid.setConstraints(button3,gbc);


		//gbc.ipady=0;
		//Adding button5 to 0th x-coordinate of 2nd column, at WEST
		gbc.gridx=3; 
		gbc.gridy=0;
		gbc.insets = new Insets(100,50,10,0);
		//gbc.fill= GridBagConstraints.NONE;
		gbc.anchor =GridBagConstraints.WEST; 
		grid.setConstraints(button4,gbc);

		gbc.ipady=400;
		//gbc.ipadx=1000;
		//Adding button6 to 1st x-coordinate of 2nd column, at CENTER
		gbc.gridx=0; 
		gbc.gridy=1;
		gbc.anchor =GridBagConstraints.WEST; 
		gbc.gridwidth = 4;
		grid.setConstraints(button5,gbc);


		

		this.pane_center.add(button1);
		this.pane_center.add(button2);
		this.pane_center.add(button3);
		this.pane_center.add(button4);
		this.pane_center.add(button5);
		//this.pane_center.add(button6);
		
		this.pane_center.setLayout(grid);
	}
}
