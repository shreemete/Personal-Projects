package com.Library;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;    
public class TableSample {    
    JFrame f;    
    private JTable table;
    TableSample(){    
    f=new JFrame(); 
    f.setBounds(300,300,600,300);
    f.setVisible(true);
    f.getContentPane().setLayout(null);
    
    table = new JTable();
    table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"due date", "book author", "book name", "book id", "sr"}) {
    	boolean[] columnEditables = new boolean[] {
    		true, true, false, true, true
    	};
    	public boolean isCellEditable(int row, int column) {
    		return columnEditables[column];
    	}
    });
    table.setBounds(19, 56, 365, 159);
    JScrollPane sp = new JScrollPane();
    sp.setBounds(0, 0, 582, 253);
    sp.add(table);
    f.getContentPane().add(sp);
       
}     
public static void main(String[] args) {    
	new TableSample();   
}    
}  