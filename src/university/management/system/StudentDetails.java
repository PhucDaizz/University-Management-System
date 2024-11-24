package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import java.awt.Font;

public class StudentDetails extends JFrame implements ActionListener {
	Choice choice;
	JTable table;
	JButton search, print, update, add, cancel;
	StudentDetails(){
		getContentPane().setBackground(new Color(210,252,218));
		
		JLabel heading = new JLabel("Tìm kiếm MSSV");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 18));
		heading.setBounds(41,25,150,20);
		getContentPane().add(heading);
		
		choice = new Choice();
		choice.setFont(new Font("Dialog", Font.PLAIN, 16));
		choice.setBounds(197,20,150,20);;
		getContentPane().add(choice);
		
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from student");
			while(resultSet.next()) {
				choice.add(resultSet.getString("stuID"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		table = new JTable();
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from student");
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane js = new JScrollPane(table);
		js.setBounds(0,100,900,600);
		getContentPane().add(js);
		
		search = new JButton("Tìm kiếm");
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.setBounds(147,69,112,20);
		search.addActionListener(this);
		getContentPane().add(search);
		
		
		print = new JButton("In");
		print.setFont(new Font("Tahoma", Font.PLAIN, 14));
		print.setBounds(269,69,90,20);
		print.addActionListener(this);
		getContentPane().add(print);
		
		add = new JButton("Thêm");
		add.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add.setBounds(369,69,90,20);
		add.addActionListener(this);
		getContentPane().add(add);
		
		update = new JButton("Cập nhật");
		update.setFont(new Font("Tahoma", Font.PLAIN, 14));
		update.setBounds(469,69,102,20);
		update.addActionListener(this);
		getContentPane().add(update);
		
		cancel = new JButton("Hủy bỏ");
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.setBounds(585,69,102,20);
		cancel.addActionListener(this);
		getContentPane().add(cancel);
		
		
		getContentPane().setLayout(null);
		setSize(900,700);
		setLocation(300,100);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == search) {
			 String q = "select * from student where stuID = '"+choice.getSelectedItem()+"'";
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
			 new AddStudent();
		 }else if(e.getSource() == update) {
			 int row = table.getSelectedRow();
		        if(row == -1) {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần cập nhật");
		            return;
		        }
		        
		        // Lấy student ID từ dòng được chọn
		        String stuId = table.getModel().getValueAt(row, 2).toString();
		        setVisible(false);
		        new updateStudent(stuId); // Mở form cập nhật với ID đã chọn
		 }else {
			 setVisible(false);
		 }
			 
	}
	public static void main(String[] args) {
		new StudentDetails();
	}

}
