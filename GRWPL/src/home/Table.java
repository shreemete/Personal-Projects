package home;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,809,521);
		
		JTable table = new JTable();
		Object[] columns = {"First Name","Lats Name","Job Position","Phone Number"};
		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columns);
		frame.getContentPane().setLayout(null);
		
		table.setModel(model);
		table.setRowHeight(30);
		table.setSize(200,200);
		table.setBackground(Color.white);
		table.setAutoCreateRowSorter(false);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 791, 326);
		pane.setBackground(Color.white);
		c.add(pane);
		
		textField = new JTextField();
		textField.setBounds(49, 361, 219, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(454, 361, 219, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(49, 396, 219, 22);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(454, 396, 219, 22);
		frame.getContentPane().add(textField_3);
		
		Object[] row = new Object [4];
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(99, 436, 97, 25);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				row[0]=textField.getText();
				row[1]=textField_1.getText();
				row[2]=textField_2.getText();
				row[3]=textField_3.getText();
				
				model.addRow(row);
			}
		});
		
		frame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(517, 436, 97, 25);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i=table.getSelectedRow();
				
				if(i>=0) {
					model.removeRow(i);
				}else {
					JOptionPane.showMessageDialog(c, "Delete error");
				}
			}
		});
		
		
		frame.getContentPane().add(btnDelete);
		
		frame.setVisible(true);
	}
}
