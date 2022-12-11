package com.Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewLibrarian extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JButton button = new JButton();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLibrarian frame = new ViewLibrarian();
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
	@SuppressWarnings("null")
	public ViewLibrarian() {
		setTitle("GRWPL Library Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewLibrarian.class.getResource("/images/Logo1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setSize( 1378, 816);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW LIBRARIAN");
		lblNewLabel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Mangal", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 27, 259, 69);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				/*AdminPage ad = new AdminPage();
				ad.setVisible(true);*/
			}
		});
		btnBack.setForeground(new Color(106, 90, 205));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Mangal", Font.BOLD, 18));
		btnBack.setBounds(1190, 43, 90, 41);
		contentPane.add(btnBack);
		
		
		try {
			
			Connection con= Connector.getCon();
			String q1 ="select COUNT(name) from librarian_table;";
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			ResultSet rs1=pstmt1.executeQuery();
			rs1.next();
			int n = rs1.getInt(1);
			String q ="select * from librarian_table;";
			PreparedStatement pstmt = con.prepareStatement(q);
		
			ResultSet rs=pstmt.executeQuery();
			int j=0;
			String[][] data = new String[n][7];
			
			String [] email = new String[n];
			while(rs.next()) {
				data[j][0]=String.valueOf(j+1);
				data[j][1]=rs.getString(1);
				data[j][2]=rs.getString(2);
				data[j][3]=rs.getString(3);
				data[j][4]=rs.getString(4);
				data[j][5]=rs.getString(5);
				email[j]=rs.getString(2);
				
				j++;
			}
			
			String [] col = {"Sr.No.","Name","Email","Mobile","Address","Password","Action"};
			table = new JTable(data,col);
			table.setEnabled(true);
			
			table.setBackground(new Color(153, 153, 255));
			table.setForeground(Color.black);
			table.setBounds(48, 146, 1232, 555);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			for (int i = 0 ; i<6;i++) {
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			}
			JTableHeader header = table.getTableHeader();
		      header.setBackground(Color.black);
		      header.setForeground(Color.yellow);
			table.setBackground(Color.white);
			table.setOpaque(true);
			table.setForeground(Color.BLACK);
			table.setSelectionBackground(Color.red);
			table.setSelectionForeground(Color.white);
			table.setFont(new Font("Tahoma",Font.PLAIN,18));
			table.setRowHeight(30);
			table.setRowHeight(30);
			table.setDefaultEditor(Object.class, null);
			table.setAutoCreateRowSorter(true);
			table.getColumn("Action").setCellRenderer( new ButtonRenderer());
		    table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
		    JScrollPane pane= new JScrollPane(table);
		    contentPane.add(pane,BorderLayout.CENTER);  
		    
		    //int row = table.getSelectedRow();
		    /*
		    
		   table.getValueAt(1, 5);
		    int row=table.getSelectedRow();
		    int col1 =table.getSelectedColumn();
		    System.out.print(row+" "+col1);*/
		    
		    
		    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		    button.addActionListener(
		      new ActionListener()
		      {
		        public void actionPerformed(ActionEvent event)
		        {
		        	UpdateLibrarian up;
		          //table.getValueAt(1, 5);
				    int row=table.getSelectedRow();
				    //System.out.print(row+" "+col1);
				
					try {
						up = new UpdateLibrarian(email[row]);
						up.setVisible(true);
						up.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								if(librarian.update_status==1)
								{
									updatedRow(table,row);
								}
							}
						});
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		      }
		    );
			
			
			pane.setBackground(new Color(138, 43, 226));
			pane.setBounds(48,138,1232,515);
			this.getContentPane().add(pane);
			
			
		} 
		catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		
	}

	class ButtonRenderer extends JButton implements TableCellRenderer 
	  {
	    public ButtonRenderer() {
	      setOpaque(true);
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value,
	    boolean isSelected, boolean hasFocus, int row, int column) {
	      setText((value == null) ? "UPDATE" : value.toString());
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
	      label = (value == null) ? "UPDATE" : value.toString();
	      button.setText(label);
	      return button;
	    }

	    public Object getCellEditorValue() 
	    {
	      return new String(label);
	    }
	  }

	  
	  public static void updatedRow(JTable t ,int  index) {
		  t.setValueAt(librarian.name, index, 1);
		  t.setValueAt(librarian.email, index, 2);
		  t.setValueAt(librarian.mobile, index, 3);
		  t.setValueAt(librarian.address, index, 4);
	  }
}
