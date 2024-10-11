package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener {
	Choice choice;
	JTable table;
	JButton search, print, update, add, cancel;
	TeacherDetails(){
		getContentPane().setBackground(new Color(192,164,252));
		
		JLabel heading = new JLabel("Tìm kiếm mã giảng viên");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		choice = new Choice();
		choice.setBounds(180,20,150,20);;
		add(choice);
		
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
		add(js);
		
		search = new JButton("Tìm kiếm");
		search.setBounds(20,70,90,20);
		search.addActionListener(this);
		add(search);
		
		
		print = new JButton("In");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		add = new JButton("Thêm");
		add.setBounds(220,70,80,20);
		add.addActionListener(this);
		add(add);
		
		update = new JButton("Cập nhật");
		update.setBounds(320,70,90,20);
		update.addActionListener(this);
		add(update);
		
		cancel = new JButton("Hủy bỏ");
		cancel.setBounds(420,70,90,20);
		cancel.addActionListener(this);
		add(cancel);
		
		
		setLayout(null);
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
