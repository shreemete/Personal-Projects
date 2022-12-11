package com.Library;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.Library.BookDetails.ButtonEditor;
import com.Library.BookDetails.ButtonRenderer;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reports extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
	private JPanel panel_head,panel_side,panel_center;
	JButton button = new JButton();
	JTable table;
	/*String date=null;*/
	Date date = new Date();
	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
	
	public Reports() {
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
		new PanelSidePage(panel_side,"report",this);
		JScrollPane scrollPane1= new JScrollPane(panel_side, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_center=new JPanel();
		panel_center.setBorder(new LineBorder(new Color(200,200,200), 10));
		panel_center.setBackground(Color.WHITE);
				
		panel_center.setLayout(new BorderLayout(0,0) );
		JPanel panel_lbl= new JPanel();
		panel_lbl.setLayout(new BorderLayout(0,0));
		Font font = new Font("Arial",Font.BOLD,35);
		JLabel lbl_head=new JLabel("REPORT");
		lbl_head.setFont(font);
		lbl_head.setBounds(150,60,250,45);
		lbl_head.setBorder(new EmptyBorder(30,100,30,50));
		panel_lbl.add(lbl_head,BorderLayout.WEST);
		panel_lbl.setBackground(Color.WHITE);
		
		JPanel panel_add= new JPanel();
		panel_add.setBackground(Color.WHITE);
		panel_add.setBounds(135, 155, 1401, 736);
		panel_add.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel_add.setLayout(new BorderLayout(0,0));
		
		try {
			Connection con = Connector.getCon();
			
			String q="select count(enroll) from issuebook where date1='"+modifiedDate+"';";
			PreparedStatement pstmt = con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int n1 = rs.getInt(1);
			String q1="select count(date2) from issuebook where date2='"+modifiedDate+"'";
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			ResultSet rs1 = pstmt1.executeQuery();
			rs1.next();
			int n2 = rs1.getInt(1);
			int n=n1+n2;
			
			String q2="select * from issuebook where date1='"+modifiedDate+"';";
			PreparedStatement pstmt2 = con.prepareStatement(q2);
			ResultSet rs2 = pstmt2.executeQuery();
			
			String data[][]=new String[n][6];
			int j=0;
			
			String[] col = {"Sr. No.","Enroll No.","Student Name","Book ID","Book Name","Action"};
			while(rs2.next()) {
				data[j][0]=String.valueOf(j+1);
				data[j][1]=rs2.getString(1);
				
				String q3="select name from student_details where enroll='"+data[j][1]+"';";
				PreparedStatement pstmt3 = con.prepareStatement(q3);
				ResultSet rs3 = pstmt3.executeQuery();
				rs3.next();
				data[j][2]=rs3.getString(1);
				
				data[j][3]=rs2.getString(2);
				
				String q4="select book_name from book_details where book_id='"+data[j][3]+"';";
				PreparedStatement pstmt4 = con.prepareStatement(q4);
				ResultSet rs4 = pstmt4.executeQuery();
				rs4.next();
				data[j][4]=rs4.getString(1);
				
				data[j][5]=rs2.getString(5);
				
				j++;
			}
			
			String q5="select * from issuebook where date2='"+modifiedDate+"';";
			PreparedStatement pstmt5 = con.prepareStatement(q5);
			ResultSet rs5 = pstmt5.executeQuery();
			
			
			while(rs5.next()) {
				data[j][0]=String.valueOf(j+1);
				data[j][1]=rs5.getString(1);
				
				String q3="select name from student_details where enroll='"+data[j][1]+"';";
				PreparedStatement pstmt3 = con.prepareStatement(q3);
				ResultSet rs3 = pstmt3.executeQuery();
				rs3.next();
				data[j][2]=rs3.getString(1);
				
				data[j][3]=rs5.getString(5);
				
				String q4="select book_name from book_details where book_id='"+data[j][3]+"';";
				PreparedStatement pstmt4 = con.prepareStatement(q4);
				ResultSet rs4 = pstmt4.executeQuery();
				rs4.next();
				data[j][4]=rs4.getString(1);
				
				data[j][5]=rs5.getString(9);
				
				
				j++;
			}
			
			
			//======================================================
			table = new JTable(data,col);
			table.setEnabled(true);
			
			table.setBackground(Color.white);
			table.setOpaque(true);
			table.setForeground(Color.BLACK);
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for (int i = 0 ; i<6;i++) {
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			}
			
			JTableHeader header = table.getTableHeader();
		    header.setBackground(Color.black);
		    header.setForeground(Color.WHITE);
		      
		    table.setSelectionBackground(new Color(200,200,200));
			table.setSelectionForeground(Color.white);
			table.setFont(new Font("Tahoma",Font.PLAIN,18));
			table.setRowHeight(30);
			table.setDefaultEditor(Object.class, null);
			table.setAutoCreateRowSorter(true);
			
		    JScrollPane pane= new JScrollPane(table);
		    panel_add.add(pane,BorderLayout.CENTER);
		    
		    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		    
		    
		}catch(Exception e) {
			/*System.out.println("ai ehth ahe");*/
			e.printStackTrace();
		}
		
		
		
		
		JPanel panel_waste1= new JPanel();
		panel_waste1.setBorder(new EmptyBorder(70,100,30,50));
		panel_waste1.setBackground(Color.WHITE);
		
		JPanel panel_waste2= new JPanel();
		panel_waste2.setBorder(new EmptyBorder(70,100,30,50));
		panel_waste2.setBackground(Color.WHITE);
		
		JPanel panel_waste3= new JPanel();
		panel_waste3.setBorder(new EmptyBorder(40,50,30,50));
		panel_waste3.setBackground(Color.WHITE);
		
		JButton btn_print=new JButton(" Print ");
		btn_print.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btn_print.setFont(new Font("Tahoma",Font.PLAIN,24));
		btn_print.setBounds(150,60,250,45);
		
		btn_print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String path="E:\\";
				com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream(path+"GRWPL"+" "+"Report"+" "+modifiedDate+".pdf"));
					doc.open();
					Paragraph paragraph1 = new Paragraph("\t\t\t\tGRWPL LIBRARY MANAGEMENT SYSTEM\n\t\t\t\tReports\n\n");
					doc.add(paragraph1);
					PdfPTable tbl = new PdfPTable(6);
					tbl.setTotalWidth(1000);
					tbl.addCell("Sr No.");
					tbl.addCell("Enroll No.");
					tbl.addCell("Student Name");
					tbl.addCell("Book ID");
					tbl.addCell("Book Name");
					tbl.addCell("Action");
					
					for(int i=0;i<table.getRowCount();i++) {
						tbl.addCell(String.valueOf(i+1));
						tbl.addCell(table.getValueAt(i, 1).toString());
						tbl.addCell(table.getValueAt(i, 2).toString());
						tbl.addCell(table.getValueAt(i, 3).toString());
						tbl.addCell(table.getValueAt(i, 4).toString());
						tbl.addCell(table.getValueAt(i, 5).toString());
						
					}
					doc.add(tbl);
					doc.close();
					JOptionPane.showMessageDialog(contentPane, "Successfully saved at E folder ...");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "Something went wrong...");
					e1.printStackTrace();
				}
			}
		});
		
		
		panel_waste3.add(btn_print,BorderLayout.EAST);
		
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
