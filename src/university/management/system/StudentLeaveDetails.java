package university.management.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;


public class StudentLeaveDetails extends JFrame implements ActionListener {
	
    Choice choiceEmpID;
    JTable table;
    JButton search, print, cancel;
	StudentLeaveDetails(){
getContentPane().setBackground(new Color(250, 170, 206));
        
        JLabel heading = new JLabel("Tìm kiếm băngf ID học sinh");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        choiceEmpID = new Choice();
        choiceEmpID.setBounds(180, 20, 150, 20);
        add(choiceEmpID);
        
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while (resultSet.next()) {
                choiceEmpID.add(resultSet.getString("stuID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);
        
        search = new JButton("Tìm kiếm");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("In");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("Hủy");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);	
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search){
    		String q = "select * from studentleave where stuID = '"+choiceEmpID.getSelectedItem()+"'";
    		try {
    			Conn c =new Conn();
    			ResultSet resultdSet = c.statement.executeQuery(q);
    			table.setModel(DbUtils.resultSetToTableModel(resultdSet)); 			
    		}catch (Exception E) {
    			E.printStackTrace();
    		}
    	}else if(e.getSource()== print) {
    		try {
    			table.print();
    		}catch(Exception E) {
    			E.printStackTrace();
    		}
    	}else {
    		setVisible(false);
    	}
		
	}
	public static void main(String[]args) {
		new StudentLeaveDetails();
	}
}