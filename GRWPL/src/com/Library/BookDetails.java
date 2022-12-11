package com.Library;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.Library.ViewLibrarian.ButtonEditor;
import com.Library.ViewLibrarian.ButtonRenderer;
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

public class BookDetails extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookDetails frame = new BookDetails();
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
	private JLabel lbl_book1 ,lbl_book2,lbl_book3,lbl_book4;
	private JLabel lbl_student1 ,lbl_student2,lbl_student3,lbl_student4;
	private JLabel lbl_issue_book1 ,lbl_issue_book2,lbl_issue_book3,lbl_issue_book4;
	private JLabel lbl_return_book1 ,lbl_return_book2,lbl_return_book3,lbl_return_book4;
	private JTable table;
	JButton button=new JButton();
	String date=null;
	public BookDetails() {
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
		new PanelSidePage(panel_side,"bookDetails",this);
		JScrollPane scrollPane1= new JScrollPane(panel_side, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel_center=new JPanel();
		panel_center.setBorder(new LineBorder(new Color(200,200,200), 10));
		panel_center.setBackground(Color.WHITE);
				
		panel_center.setLayout(new BorderLayout(0,0) );
		JPanel panel_lbl= new JPanel();
		panel_lbl.setLayout(new BorderLayout(0,0));
		Font font = new Font("Arial",Font.BOLD,35);
		JLabel lbl_head=new JLabel("BOOK DETAILS");
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
			String q="select count(book_id) from book_details";
			PreparedStatement pstmt = con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int n = rs.getInt(1);
			
			String q1="select * from book_details";
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			ResultSet rs1 = pstmt1.executeQuery();
			String data[][]=new String[n][8];
			int j=0;
			String[] book_id=new String[n];
			String[] book_name=new String[n];
			String[] quantity=new String[n];
			String[] col = {"Book ID","Book Name","Book Author","Book Edition","Department","Quantity","Added Date","Action"};
			while(rs1.next()) {
				data[j][0]=rs1.getString(1);
				data[j][1]=rs1.getString(2);
				data[j][2]=rs1.getString(3);
				data[j][3]=rs1.getString(4);
				data[j][4]=rs1.getString(5);
				data[j][5]=String.valueOf(rs1.getLong(6));
				
				data[j][6]=rs1.getString(7);
				date=rs1.getString(7);
				book_id[j]=rs1.getString(1);
				book_name[j]=rs1.getString(2);
				quantity[j]=String.valueOf(rs1.getInt(6));
				j++;
			}
			table = new JTable(data,col);
			table.setEnabled(true);
			
			table.setBackground(Color.white);
			table.setOpaque(true);
			table.setForeground(Color.BLACK);
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for (int i = 0 ; i<8;i++) {
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			}
			
			JTableHeader header = table.getTableHeader();
			header.setBackground(Color.black);
		    header.setForeground(Color.white);
		      
		    table.setSelectionBackground(new Color(200,200,200));
			table.setSelectionForeground(Color.black);
			table.setFont(new Font("Tahoma",Font.PLAIN,18));
			table.setRowHeight(30);
			table.setDefaultEditor(Object.class, null);
			table.setAutoCreateRowSorter(true);
			table.getColumn("Action").setCellRenderer( new ButtonRenderer());
		    table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
		    JScrollPane pane= new JScrollPane(table);
		    panel_add.add(pane,BorderLayout.CENTER);
		    
		    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		    button.setFont(new Font("Tahoma",Font.PLAIN,18));
		    button.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent event)
		        {
		        	AddQuantity aqt;
		          //table.getValueAt(1, 5);
				    int row=table.getSelectedRow();
				    //System.out.print(row+" "+col1);
				
					try {
						
						AddQuantity.details(book_id[row],book_name[row],quantity[row]);
						aqt=new AddQuantity();
						aqt.setVisible(true);
						
						aqt.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
								if(book.add_status==1)
								{
									updatedRow(table,row);
								}
							}

						
						});
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("ai ehthl ahe");
						e.printStackTrace();
					}
		        }
		      }
		    );
		    
		}catch(Exception e) {
			System.out.println("ai ehth ahe");
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
					PdfWriter.getInstance(doc, new FileOutputStream(path+"GRWPL"+" "+"Book Details"+" "+date+".pdf"));
					doc.open();
					Paragraph paragraph1 = new Paragraph("\t\t\t\tGRWPL LIBRARY MANAGEMENT SYSTEM\n\t\t\t\tBook Details\n\n");
					doc.add(paragraph1);
					PdfPTable tbl = new PdfPTable(8);
					tbl.setTotalWidth(1000);
					tbl.addCell("Sr No.");
					tbl.addCell("Book ID");
					tbl.addCell("Book Name");
					tbl.addCell("Book Author");
					tbl.addCell("Book Edition");
					tbl.addCell("Department");
					tbl.addCell("Quantity");
					tbl.addCell("Added Date");
					for(int i=0;i<table.getRowCount();i++) {
						tbl.addCell(String.valueOf(i+1));
						tbl.addCell(table.getValueAt(i, 0).toString());
						tbl.addCell(table.getValueAt(i, 1).toString());
						tbl.addCell(table.getValueAt(i, 2).toString());
						tbl.addCell(table.getValueAt(i, 3).toString());
						tbl.addCell(table.getValueAt(i, 4).toString());
						tbl.addCell(table.getValueAt(i, 5).toString());
						tbl.addCell(table.getValueAt(i, 6).toString());
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
	
	class ButtonRenderer extends JButton implements TableCellRenderer 
	  {
	    public ButtonRenderer() {
	      setOpaque(true);
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value,
	    boolean isSelected, boolean hasFocus, int row, int column) {
	      setText((value == null) ? "Add Quantity" : value.toString());
	      return this;
	    }
	  }

	  class ButtonEditor extends DefaultCellEditor 
	  {
	    private String label;
	    
	    public ButtonEditor(JCheckBox checkBox)
	    {
	      super(checkBox);
	    }

	    public Component getTableCellEditorComponent(JTable table, Object value,
	    boolean isSelected, int row, int column) 
	    {
	      label = (value == null) ? "Add Quantity" : value.toString();
	      button.setText(label);
	      return button;
	    }

	    public Object getCellEditorValue() 
	    {
	      return new String(label);
	    }
	  }

	  
	  public static void updatedRow(JTable t ,int  index) {
		  t.setValueAt(book.qty, index, 5);
		  
	  }

}
