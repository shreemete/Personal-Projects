package com.advance;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Window {

	private JFrame frame;
	private JPanel homePane,addBooksPane,addStudentsPane;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	private JSplitPane splitPane;
	//private JFrame frame;
	//private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JPanel panel_center;
	private void initialize() {
		frame = new JFrame();
		frame.setSize(1784, 1055);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_menu_Flow = new JPanel();
		panel_menu_Flow.setLayout(new BorderLayout(0, 0));
		JLabel lblGrwplLibraryManagement=new JLabel("   GRWPL Library Management System");
		lblGrwplLibraryManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrwplLibraryManagement.setFont(new Font("Mangal", Font.BOLD, 32));
		panel_menu_Flow.add(lblGrwplLibraryManagement, BorderLayout.WEST);
		
		
		lbl1=new JLabel("HOME");
		lbl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl1.setForeground(new Color(255, 127, 80));
				//lbl1.setBackground(new Color(255, 255, 255));
				//lbl1.setText( String.format( "<html><u>%s</u></html>") );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//lbl1.setText( String.format( "<html><u>%s</u><</html>" ) );
				lbl1.setForeground( new Color(0, 0, 0) );
				//lbl1.setBackground(new Color(255, 127, 80));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				homePane.show();
			}
		});
		lbl1.setFont(new Font("Mangal", Font.BOLD, 18));
		lbl2=new JLabel("ADD BOOK");
		lbl2.setFont(new Font("Mangal", Font.BOLD, 18));
		lbl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl2.setForeground(new Color(255, 127, 80));
				//lbl2.setBackground(new Color(255, 255, 255));
				//lbl1.setText( String.format( "<html><u>%s</u></html>") );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//lbl1.setText( String.format( "<html><u>%s</u><</html>" ) );
				lbl2.setForeground( new Color(0, 0, 0) );
				//lbl2.setBackground(new Color(255, 127, 80));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBooksPane.show();
			}
		});
		lbl3=new JLabel("ADD STUDENT");
		lbl3.setFont(new Font("Mangal", Font.BOLD, 18));
		lbl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl3.setForeground(new Color(255, 127, 80));
				//lbl1.setBackground(new Color(255, 255, 255));
				//lbl1.setText( String.format( "<html><u>%s</u></html>") );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//lbl1.setText( String.format( "<html><u>%s</u><</html>" ) );
				lbl3.setForeground( new Color(0, 0, 0) );
				//lbl1.setBackground(new Color(255, 127, 80));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addStudentsPane.show();
			}
		});
		lbl4=new JLabel("ISSUE");
		lbl4.setFont(new Font("Mangal", Font.BOLD, 18));
		lbl4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl4.setForeground(new Color(255, 127, 80));
				//lbl1.setBackground(new Color(255, 255, 255));
				//lbl1.setText( String.format( "<html><u>%s</u></html>") );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//lbl1.setText( String.format( "<html><u>%s</u><</html>" ) );
				lbl4.setForeground( new Color(0, 0, 0) );
				//lbl1.setBackground(new Color(255, 127, 80));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addStudentsPane.show();
			}
		});
		
		lbl5=new JLabel("RETURN");
		lbl5.setFont(new Font("Mangal", Font.BOLD, 18));
		lbl5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl5.setForeground(new Color(255, 127, 80));
				//lbl1.setBackground(new Color(255, 255, 255));
				//lbl1.setText( String.format( "<html><u>%s</u></html>") );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//lbl1.setText( String.format( "<html><u>%s</u><</html>" ) );
				lbl5.setForeground( new Color(0, 0, 0) );
				//lbl1.setBackground(new Color(255, 127, 80));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addStudentsPane.show();
			}
		});
		
		lbl6=new JLabel("REPORT");
		lbl6.setFont(new Font("Mangal", Font.BOLD, 18));
		lbl6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl6.setForeground(new Color(255, 127, 80));
				//lbl1.setBackground(new Color(255, 255, 255));
				//lbl1.setText( String.format( "<html><u>%s</u></html>") );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//lbl1.setText( String.format( "<html><u>%s</u><</html>" ) );
				lbl6.setForeground( new Color(0, 0, 0) );
				//lbl1.setBackground(new Color(255, 127, 80));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addStudentsPane.show();
			}
		});
		
		JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
		toolBar.setFont(new Font("Mangal", Font.BOLD, 18));
		//frame.getContentPane().add(toolBar, BorderLayout.WEST);
		//toolBar.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		toolBar.setFloatable(false);
		toolBar.setMargin(new Insets(10, 5, 5, 5));
		
		toolBar.add(lbl1);
		toolBar.add(lbl2);
		toolBar.add(lbl3);
		toolBar.add(lbl4);
		toolBar.add(lbl5);
		toolBar.add(lbl6);
		
		
		
		//JPanel panel_menu = new JPanel();
		frame.getContentPane().add(panel_menu_Flow, BorderLayout.NORTH);
		
		panel_center = new JPanel();
		//frame.getContentPane().add(panel_center, BorderLayout.CENTER);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toolBar, panel_center);
	    splitPane.setOneTouchExpandable(true);
	    splitPane.setDividerLocation(0.2);
	    splitPane.setDividerSize(3);
	    
	    Dimension minimumSize = new Dimension(150, 150);
        toolBar.setMinimumSize(minimumSize);
        Dimension maximumSize = new Dimension(750, 150);
        panel_center.setMinimumSize(maximumSize);
        panel_center.setLayout(new CardLayout(0, 0));
        
        homePane = new JPanel();
        //homePane.add();
        panel_center.add(homePane, "name_11746247826100");
        
        addBooksPane = new JPanel();
        //addBooksPane.add();
        panel_center.add(addBooksPane, "name_11754984695000");
        
        addStudentsPane = new JPanel();
        //addStudentsPane.add();
        panel_center.add(addStudentsPane, "name_11729135786800");
		
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
	}

}
