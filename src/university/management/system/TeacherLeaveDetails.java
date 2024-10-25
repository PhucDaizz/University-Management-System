package university.management.system;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice choiceEmpID;
    JTable table;
    JButton search, print, cancel;

    TeacherLeaveDetails() {
        getContentPane().setBackground(new Color(250, 170, 206));
        JLabel heading = new JLabel("Tìm kiếm bằng ID Giáo viên");
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        heading.setBounds(20, 20, 208, 20);
        getContentPane().add(heading);
        
        choiceEmpID = new Choice();
        choiceEmpID.setFont(new Font("Dialog", Font.PLAIN, 14));
        choiceEmpID.setBounds(234, 20, 150, 20);
        getContentPane().add(choiceEmpID);
        
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                choiceEmpID.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        getContentPane().add(scrollPane);
        
        search = new JButton("Tìm kiếm");
        search.setFont(new Font("Tahoma", Font.PLAIN, 14));
        search.setBounds(20,70,104,20);
        search.addActionListener(this);
        getContentPane().add(search);
        
        print = new JButton("In");
        print.setFont(new Font("Tahoma", Font.PLAIN, 14));
        print.setBounds(146,70,80,20);
        print.addActionListener(this);
        getContentPane().add(print);
        
        cancel = new JButton("Hủy");
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cancel.setBounds(250,69,80,20);
        cancel.addActionListener(this);
        getContentPane().add(cancel);
        
        
        setSize(900, 700);
        setLocation(300, 100);
        getContentPane().setLayout(null);	
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == search){
    		String q = "select * from teacherleave where empId = '"+choiceEmpID.getSelectedItem()+"'";
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

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
