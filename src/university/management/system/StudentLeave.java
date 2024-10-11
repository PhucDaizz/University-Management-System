package university.management.system;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class StudentLeave extends JFrame implements ActionListener {
	Choice choiceRollNo, choTime;
	JDateChooser selDate;
	
	JButton submit, cancel;
	StudentLeave() {
		
		getContentPane().setBackground(new Color(210,232,252));
		
		JLabel heading = new JLabel("Đơn xin nghỉ phép (Sinh viên)");
		heading.setBounds(40, 50,300,30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(heading);
		
		JLabel RollNoSE = new JLabel("Tìm kiếm MSSV");
		RollNoSE.setBounds(60,100,200,20);
		RollNoSE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(RollNoSE);
		
		choiceRollNo = new Choice();
		choiceRollNo.setBounds(60,130,200,20);
		add(choiceRollNo);
		
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from student");
			while (resultSet.next()) {
				choiceRollNo.add(resultSet.getString("rollno"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lbldate = new JLabel("Ngày tháng năm");
		lbldate.setBounds(60, 180, 200, 20);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbldate);
		
		selDate = new JDateChooser();
		selDate.setBounds(60, 210, 200, 25);
		add(selDate);
		
		JLabel time = new JLabel("Khoảng thời gian");
		time.setBounds(60, 260, 200, 20);
		time.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(time);
		
		choTime = new Choice();
		choTime.setBounds(60, 290, 200, 20);
		choTime.add("Full Day");
		choTime.add("Half Day");
		add(choTime);
		
		submit = new JButton("Chấp nhận");
		submit.setBounds(60, 350, 100, 25);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Hủy bỏ");
		cancel.setBounds(200, 350, 100, 25);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		
		
		setSize(500,550);
		setLocation(550,100);
		setLayout(null);
		setVisible(true);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			String rollno = choiceRollNo.getSelectedItem();
			String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
			String time = choTime.getSelectedItem();
			
			String Q = "insert into studentLeave values('"+rollno+"','"+date+"', '"+time+"')";
			try {
				Conn c = new Conn();
				c.statement.executeUpdate(Q);
				JOptionPane.showMessageDialog(null, "Xác nhận nghỉ phép");
				setVisible(false);
				
				
			}catch (Exception E) {
				E.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new StudentLeave();
	}

}
