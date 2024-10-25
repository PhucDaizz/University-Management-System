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
		heading.setBounds(60, 50,300,30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(heading);
		
		JLabel RollNoSE = new JLabel("Tìm kiếm MSSV");
		RollNoSE.setBounds(60,100,200,20);
		RollNoSE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(RollNoSE);
		
		choiceRollNo = new Choice();
		choiceRollNo.setFont(new Font("Dialog", Font.PLAIN, 14));
		choiceRollNo.setBounds(60,135,200,20);
		getContentPane().add(choiceRollNo);
		
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from student");
			while (resultSet.next()) {
				choiceRollNo.add(resultSet.getString("stuID"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lbldate = new JLabel("Ngày tháng năm");
		lbldate.setBounds(60, 180, 200, 20);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lbldate);
		
		selDate = new JDateChooser();
		selDate.setBounds(60, 210, 200, 25);
		getContentPane().add(selDate);
		
		JLabel time = new JLabel("Khoảng thời gian");
		time.setBounds(60, 260, 200, 20);
		time.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(time);
		
		choTime = new Choice();
		choTime.setFont(new Font("Dialog", Font.PLAIN, 14));
		choTime.setBounds(60, 290, 200, 20);
		choTime.add("Full Day");
		choTime.add("Half Day");
		getContentPane().add(choTime);
		
		submit = new JButton("Chấp nhận");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		submit.setBounds(60, 350, 118, 25);
		submit.setBackground(Color.GREEN);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		getContentPane().add(submit);
		
		cancel = new JButton("Hủy bỏ");
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.setBounds(200, 350, 118, 25);
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		getContentPane().add(cancel);
		
		
		
		setSize(500,550);
		setLocation(550,100);
		getContentPane().setLayout(null);
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
