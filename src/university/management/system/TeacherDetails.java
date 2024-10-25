package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.Font;

public class TeacherDetails extends JFrame implements ActionListener {
	Choice choice;
	JTable table;
	JButton search, print, update, add, cancel;
	TeacherDetails(){
		getContentPane().setBackground(new Color(192,164,252));
		
		JLabel heading = new JLabel("Tìm kiếm mã giảng viên");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 16));
		heading.setBounds(20,20,180,20);
		getContentPane().add(heading);
		
		choice = new Choice();
		choice.setFont(new Font("Dialog", Font.PLAIN, 14));
		choice.setBounds(220,22,150,20);;
		getContentPane().add(choice);
		
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from teacher");
			while(resultSet.next()) {
				choice.add(resultSet.getString("empID"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		table = new JTable();
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from teacher");
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane js = new JScrollPane(table);
		js.setBounds(0,100,900,600);
		getContentPane().add(js);
		
		search = new JButton("Tìm kiếm");
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.setBounds(20,70,112,20);
		search.addActionListener(this);
		getContentPane().add(search);
		
		
		print = new JButton("In");
		print.setFont(new Font("Tahoma", Font.PLAIN, 14));
		print.setBounds(157,69,80,20);
		print.addActionListener(this);
		getContentPane().add(print);
		
		add = new JButton("Thêm");
		add.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add.setBounds(257,69,80,20);
		add.addActionListener(this);
		getContentPane().add(add);
		
		update = new JButton("Cập nhật");
		update.setFont(new Font("Tahoma", Font.PLAIN, 14));
		update.setBounds(362,69,112,20);
		update.addActionListener(this);
		getContentPane().add(update);
		
		cancel = new JButton("Hủy bỏ");
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.setBounds(498,70,90,20);
		cancel.addActionListener(this);
		getContentPane().add(cancel);
		
		
		getContentPane().setLayout(null);
		setSize(900,700);
		setLocation(300,100);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == search) {
			 String q = "select*from teacher where empID = '" + choice.getSelectedItem()+"'";
			 try {
				 Conn c = new Conn();
				 ResultSet resultSet = c.statement.executeQuery(q);
				 table.setModel(DbUtils.resultSetToTableModel(resultSet));
				 
			 }catch (Exception E) {
				 E.printStackTrace();
				 
			 }
		 }else if (e.getSource() == print) {
			 try {
				 table.print();
			 }catch (Exception E) {
				 E.printStackTrace();
			 }
		 }else if(e.getSource() == add) {
			 setVisible(false);
			 new AddFaculty();
		 }else if(e.getSource() == update) {
			 
		 }else {
			 setVisible(false);
		 }
	}
	public static void main(String[] args) {
		new TeacherDetails();
			
	}	
}
