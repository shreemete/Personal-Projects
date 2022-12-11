package com.Library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.Library.ViewLibrarian.ButtonEditor;
import com.Library.ViewLibrarian.ButtonRenderer;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	JButton button = new JButton();
	JScrollPane pane ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	boolean f;
	private JPanel panel_head,panel_side,panel_center;
	int issb=0;
	int due=0;
	long millis1=0;
	long millis2=0;
	String enroll=null;
	String issuedbook,date1=null,date2=null;
	boolean tc=false;
	public ReturnBook() {
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
		new PanelSidePage(panel_side,"returnBooks",this);
		JScrollPane scrollPane1= new JScrollPane(panel_side, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_center=new JPanel();
		panel_center.setBorder(new LineBorder(new Color(200,200,200), 10));
		panel_center.setBackground(Color.WHITE);
				
		panel_center.setLayout(new BorderLayout(0,0) );
		JPanel panel_lbl= new JPanel();
		panel_lbl.setLayout(new BorderLayout(0,0));
		Font font = new Font("Arial",Font.BOLD,35);
		JLabel lbl_head=new JLabel("RETURN BOOK");
		lbl_head.setFont(font);
		lbl_head.setBounds(150,60,250,45);
		lbl_head.setBorder(new EmptyBorder(30,100,30,50));
		panel_lbl.add(lbl_head,BorderLayout.WEST);
		panel_lbl.setBackground(Color.WHITE);
		
		JPanel panel_add= new JPanel();
		panel_add.setBackground(Color.WHITE);
		panel_add.setBounds(135, 155, 1401, 736);
		panel_add.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel_add.setLayout(new BorderLayout());
		
		JPanel panel_add_1= new JPanel();
		panel_add_1.setBackground(Color.WHITE);
		panel_add_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		Font font1 = new Font("Arial",Font.BOLD,22);
		Font font2 = new Font("Arial",Font.PLAIN,20);
		
		JLabel lblRollNo = new JLabel("ROLL NO.");
		lblRollNo.setFont(font1);
		
		JTextField txtRoll= new JTextField();
		txtRoll.setFont(font2);
		
		JLabel lblClass = new JLabel("CLASS");
		lblClass.setFont(font1);
		
		String s[] = {" Select","C01","C02","C03","CE1","CE2","CE3","DD1","DD2","DD3","E&TC1","E&TC2","E&TC3","MU1","MU2","MU3"};
		JComboBox txtClass= new JComboBox(s);
		txtClass.setSelectedIndex(0);
		txtClass.setFont(font2);
		
		JButton btn_search = new JButton("Search");
		btn_search.setFont(font2);
		
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbc1 = new GridBagConstraints();
		panel_add_1.setLayout(grid);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=20;
		gbc.gridx=0; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,20);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(lblRollNo,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=100;
		gbc.ipady=20;
		gbc.gridx=1; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(txtRoll,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=0;
		gbc.ipady=20;
		gbc.gridx=2; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,20);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(lblClass,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=100;
		gbc.ipady=20;
		gbc.gridx=3; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,150);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(txtClass,gbc);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipadx=100;
		gbc.ipady=20;
		gbc.gridx=4; 
		gbc.gridy=0;
		gbc.insets = new Insets(30,0,30,100);
		gbc.anchor =GridBagConstraints.WEST;
		panel_add_1.add(btn_search,gbc);
		
		panel_add.add(panel_add_1,BorderLayout.NORTH);
		
		JPanel panel_add_2= new JPanel();
		panel_add_2.setBackground(Color.WHITE);
		panel_add_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		panel_add_2.setLayout(new BorderLayout(0,0));
		
		JPanel panel_add_2_name= new JPanel();
		panel_add_2_name.setBackground(Color.WHITE);
		
		panel_add_2_name.setLayout(grid);
		
		JLabel lblStdName = new JLabel("Name ");
		lblStdName.setFont(font1);
		
		gbc1.ipadx=0;
		gbc1.ipady=20;
		gbc1.gridx=0; 
		gbc1.gridy=0;
		/*gbc1.gridwidth=7;*/
		gbc1.insets = new Insets(30,0,0,30);
		gbc1.anchor =GridBagConstraints.CENTER;
		panel_add_2_name.add(lblStdName,gbc1);
		
		JTextField txtStdName= new JTextField();
		txtStdName.setFont(font2);
		txtStdName.setEditable(false);
		
		gbc1.ipadx=600; 
		gbc1.ipady=20;
		gbc1.gridx=1; 
		gbc1.gridy=0;
		gbc1.gridwidth=5;
		gbc1.insets = new Insets(30,0,0,100);
		gbc1.anchor =GridBagConstraints.CENTER;
		panel_add_2_name.add(txtStdName,gbc1);
		
		JLabel lblIssuedBook = new JLabel("Issued Book");
		lblIssuedBook.setFont(font1);
		
		gbc1.ipadx=0;
		gbc1.ipady=20;
		gbc1.gridx=6; 
		gbc1.gridy=0;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(30,0,0,30);
		gbc1.anchor =GridBagConstraints.CENTER;
		panel_add_2_name.add(lblIssuedBook,gbc1);
		
		JTextField txtIssuedBook = new JTextField();
		txtIssuedBook.setFont(font2);
		txtIssuedBook.setHorizontalAlignment(SwingConstants.CENTER);
		txtIssuedBook.setEditable(false);
		
		gbc1.ipadx=100;
		gbc1.ipady=20;
		gbc1.gridx=7; 
		gbc1.gridy=0;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(30,0,0,100);
		gbc1.anchor =GridBagConstraints.CENTER;
		panel_add_2_name.add(txtIssuedBook,gbc1);
		
		JPanel panel_add_2_table= new JPanel();
		panel_add_2_table.setBackground(Color.WHITE);
		panel_add_2_table.setLayout(new BorderLayout(0,0));
		panel_add_2_table.setBorder(new LineBorder(new Color(255, 255, 255), 35));
		
		returnB rb = new returnB();
		
		JTable jt=new JTable();
		Object[] columns = {"Sr. No.","Book ID","Book Name","Author Name","Book Edition"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		jt.setModel(model);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		JTableHeader header = jt.getTableHeader();
		header.setBackground(Color.black);
	    header.setForeground(Color.white);
	      
	    jt.setSelectionBackground(new Color(200,200,200));
		jt.setSelectionForeground(Color.black);
	    jt.setDefaultEditor(Object.class, null);
	    for (int i = 0 ; i<5;i++) {
			jt.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
	    header.setFont(new Font("Tahoma",Font.PLAIN,18));
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    jt.setFont(new Font("Tahoma",Font.PLAIN,18));
	    jt.setRowHeight(30);
	    
		JScrollPane scrollPane2 = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    
		panel_add_2_table.add(scrollPane2,BorderLayout.CENTER);
		
		String[] id = new String[2];
		JPanel panel_add_2_button= new JPanel();
		panel_add_2_button.setBackground(Color.WHITE);
		panel_add_2_button.setLayout(grid);
		JButton btn_return=new JButton("RETURN");
		btn_return.setFont(font2);
		btn_return.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a =jt.getSelectedRow();
				/*System.out.println("=============");*/
				Date d2 = new Date();
				SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
				String da= sdf3.format(d2);
				Date Da=null;
				try {
					
					Da = sdf3.parse(da);
					
				} catch (ParseException e2) {
					
					e2.printStackTrace();
				}
				long millis = Da.getTime();
				/*long millis=System.currentTimeMillis();*/
				System.out.println("*******************");
				System.out.println(millis);
				System.out.println("*******************");
				String q =null;
				int r=0;
				if(a==0) {
					
					 q = "update issuebook set issuedbook1=? ,date1=?, action1=?, due=? where enroll=?;";
					r=(int) ((millis -millis1)/86400000 - 7);
					System.out.println(r);
					
				}else {
					 q = "update issuebook set issuedbook2=?, date2=?, action2=?, due=? where enroll=?;";
					 r=(int) ((millis-millis2)/86400000 - 7);
					 System.out.println(r);
				}
				System.out.println(r);
				System.out.println("*******************");
				try {
					Connection con = Connector.getCon();
					PreparedStatement pstmt = con.prepareStatement(q);
					pstmt.setString(1,id[a]);
					issuedbook=id[a];
					
					pstmt.setString(2,da);
					pstmt.setString(3, "return");
					
					if(r>0) {
						due += r;
					}
					
					pstmt.setInt(4, due);
					pstmt.setString(5, enroll);
					pstmt.executeUpdate();
					
					f=quantityDB();
					if(f) {
						JOptionPane.showMessageDialog(contentPane, "Book returned successfully ...");
					}
					model.removeRow(a);
					issb-=1;
					txtIssuedBook.setText(String.valueOf(issb));
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		gbc1.ipadx=100;
		gbc1.ipady=20;
		gbc1.gridx=0; 
		gbc1.gridy=0;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(0,0,10,800);
		gbc1.anchor =GridBagConstraints.CENTER;
		panel_add_2_button.add(btn_return,gbc1);
		
		JButton btn_renew=new JButton("RENEW");
		btn_renew.setFont(font2);
		btn_renew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					int a=jt.getSelectedRow();
					/*if(a==0) {
					String q="select due_date1,due from issuebook where enroll=? ";
					}else {
						String q="select due_date2,due from issuebook where enroll=? ";
					}*/
					//========================================
					
					Date d2 = new Date();
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
					String da= sdf3.format(d2);
					Date Da=null;
					try {
						
						Da = sdf3.parse(da);
						
					} catch (ParseException e2) {
						
						e2.printStackTrace();
					}
					long millis = Da.getTime();
					/*long millis=System.currentTimeMillis();*/
					System.out.println("*******************");
					System.out.println(millis);
					System.out.println("*******************");
					String q1 =null;
					int r=0;
					if(a==0) {
						
						 q1 = "update issuebook set date1=?, due_date1=?, due=? where enroll=?;";
						r=(int) ((millis -millis1)/86400000 - 7);
						System.out.println(r);
						
					}else {
						 q1 = "update issuebook set date2=?, due_date2=?, due=? where enroll=?;";
						 r=(int) ((millis-millis2)/86400000 - 7);
						 System.out.println(r);
					}
					System.out.println(r);
					System.out.println("*******************");
					try {
						Connection con = Connector.getCon();
						PreparedStatement pstmt = con.prepareStatement(q1);
						
						issuedbook=id[a];
						
						pstmt.setString(1,da);
						java.sql.Date date1 = new java.sql.Date(millis+604800000); 
						pstmt.setString(2, String.valueOf(date1));
						
						if(r>0) {
							due += r;
						}
						
						pstmt.setInt(3, due);
						pstmt.setString(4, enroll);
						pstmt.executeUpdate();
						
						/*f=quantityDB();*/
						if(f) {
							JOptionPane.showMessageDialog(contentPane, "Book renewed successfully ...");
						}
						
						/*issb-=1;
						txtIssuedBook.setText(String.valueOf(issb));
					*/
				
					}catch(Exception e1) {
						e1.printStackTrace();
					}}
		});
		
		gbc1.ipadx=100;
		gbc1.ipady=20;
		gbc1.gridx=1; 
		gbc1.gridy=0;
		gbc1.gridwidth=1;
		gbc1.insets = new Insets(0,0,10,0);
		gbc1.anchor =GridBagConstraints.CENTER;
		panel_add_2_button.add(btn_renew,gbc1);
		
		panel_add_2.add(panel_add_2_name,BorderLayout.NORTH);
		panel_add_2.add(panel_add_2_table,BorderLayout.CENTER);
		panel_add_2.add(panel_add_2_button,BorderLayout.SOUTH);
		
		btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String roll=txtRoll.getText();
				String Class=(String) txtClass.getSelectedItem();
				try {
					Connection con= Connector.getCon();
					String q1 ="select name,enroll from student_details where rollno='"+roll+"' and class='"+Class+"';";
					PreparedStatement pstmt1 = con.prepareStatement(q1);
					ResultSet rs1=pstmt1.executeQuery();
					rs1.next();
					/*System.out.println(rs1.getString(1));*/
					txtStdName.setText("  "+rs1.getString(1));
					enroll=rs1.getString(2);
					String q ="select count(enroll) from issuebook where enroll='"+rs1.getString(2)+"' ; ";
					PreparedStatement pstmt = con.prepareStatement(q);
					ResultSet rs=pstmt.executeQuery();
					rs.next();
					int a = rs.getInt(1);
					System.out.println(a);
					if(a==1) {
						String q2 ="select count(issuedbook1) from issuebook where enroll='"+rs1.getString(2)+"' and action1='issued';";
						PreparedStatement pstmt2 = con.prepareStatement(q2);
						ResultSet rs2=pstmt2.executeQuery();
						rs2.next();
						issb+=rs2.getInt(1);
						System.out.println(issb);
						String q3 ="select count(issuedbook2) from issuebook where enroll='"+rs1.getString(2)+"' and action2='issued';";
						PreparedStatement pstmt3 = con.prepareStatement(q3);
						ResultSet rs3=pstmt3.executeQuery();
						rs3.next();
						issb+=rs3.getInt(1);
						System.out.println(issb);
					}
					
					txtIssuedBook.setText(String.valueOf(issb));
					
					try {
						String book1=null,book2=null;
						
						String q4 ="select issuedbook1,due_date1 from issuebook where enroll='"+enroll+"'and action1='issued';";
						PreparedStatement pstmt4 = con.prepareStatement(q4);
						ResultSet rs4=pstmt4.executeQuery();
						if(rs4.next()) {
							 book1=rs4.getString(1);
							 date1=rs4.getString(2);
						}
						
						String qa ="select issuedbook2,due_date2 from issuebook where enroll='"+enroll+"'and action2='issued';";
						PreparedStatement pstmta = con.prepareStatement(qa);
						ResultSet rsa=pstmta.executeQuery();
						if(rsa.next()) {
							 book2=rsa.getString(1);
							 date2=rsa.getString(1);
						}
						
						
						System.out.println("date1 "+date1);
						System.out.println("date2 "+date2);
						if(date1!=null) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(date1);
						millis1 = date.getTime();
						}if(date2!=null) {
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
							Date Date1 = sdf1.parse(date2);
							millis2 = Date1.getTime();
						}
						String qn ="select due from issuebook where enroll='"+enroll+"' ;";
						
						PreparedStatement pstmtn = con.prepareStatement(qn);
						
						ResultSet rsn=pstmtn.executeQuery();
						rsn.next();
						due=rsn.getInt(1);
						
						String q5 ="select book_id,book_name,book_author, book_edition from book_details where book_id='"+book1+"' or book_id='"+book2+"' ;";
						PreparedStatement pstmt5 = con.prepareStatement(q5);
						
						ResultSet rs5=pstmt5.executeQuery();
						int j=0;
						Object[] row = new Object[5];
						while(rs5.next()) {
							row[0]=String.valueOf(j+1);
							row[1]=rs5.getString(1);
							row[2]=rs5.getString(2);
							row[3]=rs5.getString(3);
							row[4]=rs5.getString(4);
							id[j]=rs5.getString(1);
							model.addRow(row);
							j++;
						}
					}catch (Exception e1) {
							e1.printStackTrace();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "Student is not present ");
				}
			}
		});
		
		panel_add.add(panel_add_2,BorderLayout.CENTER);

		JPanel panel_waste1= new JPanel();
		panel_waste1.setBorder(new EmptyBorder(70,100,30,50));
		panel_waste1.setBackground(Color.WHITE);
		
		JPanel panel_waste2= new JPanel();
		panel_waste2.setBorder(new EmptyBorder(70,100,30,50));
		panel_waste2.setBackground(Color.WHITE);
		
		JPanel panel_waste3= new JPanel();
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
	private boolean quantityDB() {
		try {
			
			Connection con= Connector.getCon();
			String q1 ="select quantity from book_details where book_id=?;";
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			pstmt1.setString(1, issuedbook);
			ResultSet rs1 = pstmt1.executeQuery();
			rs1.next();
			int qt=rs1.getInt(1);
			String q="update book_details set quantity=? where book_id=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1,qt+1);
			pstmt.setString(2, issuedbook);
			pstmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

