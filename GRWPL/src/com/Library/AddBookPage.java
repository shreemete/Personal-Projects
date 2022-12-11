package com.Library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookPage extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookPage frame = new AddBookPage();
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
	private JPanel panel_head,panel_side,panel_center,panel_add,panel_lbl,panel_waste1,panel_waste2,panel_waste3;
	private JLabel lbl_head,lblBookId,label,label_1,label_2,label_3,label_4,label_5;
	private JTextField txtBookId,txtBookName,txtAuthorName,txtBookEdition,txtDepatment,txtQuantity,txtDate;
	private JComboBox dep;
	private JButton btn_submit,btn_reset;
	String sid;
	JFrame frame;
	
	//private JLabel lbl_head;
	public AddBookPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomePage.class.getResource("/images/Logo1.jpg")));
		setTitle("GRWPL Library Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1750, 1000);
		setLocationRelativeTo(null);
		setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_head=new JPanel();
		new PanelHeadPage(panel_head,this);
		panel_side=new JPanel();
		//AddBookPage add = new AddBookPage();
		frame=this;
		new PanelSidePage(panel_side,"addBooks",frame);
		JScrollPane scrollPane1= new JScrollPane(panel_side, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_center=new JPanel();
		panel_center.setBorder(new LineBorder(new Color(200,200,200), 10));
		panel_center.setBackground(Color.WHITE);
		
		panel_center.setLayout(new BorderLayout(0,0) );
		panel_lbl= new JPanel();
		panel_lbl.setLayout(new BorderLayout(0,0));
		Font font = new Font("Arial",Font.BOLD,35);
		lbl_head=new JLabel("ADD BOOKS");
		lbl_head.setFont(font);
		lbl_head.setBounds(150,60,250,45);
		lbl_head.setBorder(new EmptyBorder(30,100,30,50));
		panel_lbl.add(lbl_head,BorderLayout.WEST);
		panel_lbl.setBackground(Color.WHITE);
		
		panel_add= new JPanel();
		panel_add.setBackground(Color.WHITE);
		panel_add.setBounds(135, 155, 1401, 736);
		panel_add.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		panel_add.setLayout(grid);
		
		Font font1 = new Font("Arial",Font.BOLD,22);
		Font font2 = new Font("Arial",Font.PLAIN,18);

		lblBookId = new JLabel("Book ID ");
		lblBookId.setFont(font1);
		//panel_add.add(lblBookId);
		
		
		
		
		label = new JLabel("Book Name ");
		label.setFont(new Font("Arial", Font.BOLD, 22));
		//label.setBorder(new EmptyBorder(0, 0, 0, 20));
		//panel_add.add(label);
		
		label_1 = new JLabel("Author Name ");
		label_1.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_1);
		
		label_2 = new JLabel("Book Edition ");
		label_2.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_2);
		
		label_3 = new JLabel("Department ");
		label_3.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_3);
		
		label_4 = new JLabel("Quantity ");
		label_4.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_4);
		
		label_5 = new JLabel("Date ");
		label_5.setFont(new Font("Arial", Font.BOLD, 22));
		//panel_add.add(label_5);
		
		CreateBookID id = new CreateBookID();
		sid = id.bookID();
		
		txtBookId = new JTextField(sid);
		txtBookId.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookId.setFont(font2);
		txtBookId.setEditable(false);
		
		txtBookName = new JTextField();
		//txtBookName.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookName.setFont(font2);
		
		txtAuthorName = new JTextField();
		//txtAuthorName.setHorizontalAlignment(SwingConstants.CENTER);
		txtAuthorName.setFont(font2);
		
		txtBookEdition = new JTextField();
		//txtBookEdition.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookEdition.setFont(font2);
		
		/*txtDepatment = new JTextField();
		//txtDepatment.setHorizontalAlignment(SwingConstants.CENTER);
		txtDepatment.setFont(font2);*/
		
		String s[] = {"Select","Computer Science","Other"};
		dep= new JComboBox(s);
		dep.setSelectedIndex(0);
		dep.setFont(font2);
		
		txtQuantity = new JTextField();
		//txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantity.setFont(font2);
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis); 
		
		txtDate = new JTextField(String.valueOf(date));
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setFont(font2);
		txtDate.setEditable(false);
		
		//button
		btn_submit= new JButton("ADD");
		btn_submit.setFont(font2);
		btn_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(sid);
				AddBookDB add = new AddBookDB(txtBookId.getText(), txtBookName.getText(), txtAuthorName.getText(), txtBookEdition.getText(), (String) dep.getSelectedItem(), txtQuantity.getText(), txtDate.getText());
				boolean f = add.insertedDB();
				
				if(f) {
					JOptionPane.showMessageDialog(contentPane, "Book Added Successfully");
					CreateBookID id = new CreateBookID();
					sid = id.bookID();
					txtBookId.setText(sid);
					txtBookName.setText(null);
					txtAuthorName.setText("");
					txtBookEdition.setText("");
					dep.setSelectedIndex(0);
					txtQuantity.setText("");
					long millis=System.currentTimeMillis();  
					java.sql.Date date = new java.sql.Date(millis); 
					txtDate.setText(String.valueOf(date));
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Failed to add book, try agian");
				}
				
				
			}
		});
		btn_reset= new JButton("RESET");
		btn_reset.setFont(font2);
		btn_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
					int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");  
					if(a==0) {
						txtBookName.setText(null);
						txtAuthorName.setText("");
						txtBookEdition.setText("");
						dep.setSelectedIndex(0);
						txtQuantity.setText("");
					}
				
				
				
			}
		});
		
		// book id
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=0;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(lblBookId,gbc);
		
		// text book id
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=200;
		gbc.ipady=30;
		gbc.gridx=2; 
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.insets = new Insets(20,30,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtBookId,gbc);
		
		// book name
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=1;
		gbc.insets = new Insets(0,0,10,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label,gbc);
		
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=700;
		gbc.ipady=30;
		gbc.gridx=2; 
		gbc.gridy=1;
		gbc.gridwidth=5;
		gbc.insets = new Insets(20,30,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtBookName,gbc);
		
		// author name
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=2;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_1,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=600;
		gbc.ipady=30;
		gbc.gridx=2; 
		gbc.gridy=2;
		gbc.gridwidth=5;
		gbc.insets = new Insets(20,30,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtAuthorName,gbc);
		
		//  book edition
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=3;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_2,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=600;
		gbc.ipady=30;
		gbc.gridx=2; 
		gbc.gridy=3;
		gbc.gridwidth=5;
		gbc.insets = new Insets(20,30,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtBookEdition,gbc);
		
		// Department
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=80;
		gbc.gridx=0; 
		gbc.gridy=4;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_3,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=300;
		gbc.ipady=30;
		gbc.gridx=2; 
		gbc.gridy=4;
		gbc.gridwidth=2;
		gbc.insets = new Insets(20,30,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(dep,gbc);
		
		//  quantity
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=80;
		gbc.gridx=5; 
		gbc.gridy=4;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_4,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=30;
		gbc.gridx=6; 
		gbc.gridy=4;
		gbc.gridwidth=1;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(txtQuantity,gbc);
		
		//  date
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=100;
		gbc.ipady=80;
		gbc.gridx=5; 
		gbc.gridy=0;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(label_5,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=200;
		gbc.ipady=30;
		gbc.gridx=6; 
		gbc.gridy=0;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.CENTER;
		gbc.gridwidth = 1;
		panel_add.add(txtDate,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=30;
		gbc.gridx=0; 
		gbc.gridy=5;
		gbc.gridwidth=2;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(btn_submit,gbc);
		
		//gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=150;
		gbc.ipady=30;
		gbc.gridx=6; 
		gbc.gridy=5;
		gbc.gridwidth=1;
		gbc.insets = new Insets(20,0,20,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add.add(btn_reset,gbc);
		

		panel_waste1= new JPanel();
		panel_waste1.setBorder(new EmptyBorder(70,100,30,50));
		panel_waste1.setBackground(Color.WHITE);
		
		panel_waste2= new JPanel();
		panel_waste2.setBorder(new EmptyBorder(70,100,30,50));
		panel_waste2.setBackground(Color.WHITE);
		
		panel_waste3= new JPanel();
		panel_waste3.setBorder(new EmptyBorder(40,50,30,50));
		panel_waste3.setBackground(Color.WHITE);
		
		panel_center.add(panel_lbl,BorderLayout.NORTH);
		panel_center.add(panel_add,BorderLayout.CENTER);
		panel_center.add(panel_waste1,BorderLayout.WEST);
		panel_center.add(panel_waste2,BorderLayout.EAST);
		panel_center.add(panel_waste3,BorderLayout.SOUTH);
		
		JScrollPane scrollPane= new JScrollPane(panel_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		contentPane.add(scrollPane1,BorderLayout.WEST);
		contentPane.add(panel_head,BorderLayout.NORTH);
		contentPane.add(scrollPane,BorderLayout.CENTER);
	}
}
