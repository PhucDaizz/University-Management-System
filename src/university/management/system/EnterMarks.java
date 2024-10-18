package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
	Choice choicerollno;
	JComboBox comboBox;
	JTextField sub1, sub2, sub3, sub4, sub5, mrk1, mrk2, mrk3, mrk4, mrk5;
    JButton submit, cancel;
	EnterMarks() {
        // Thiết lập màu nền
        getContentPane().setBackground(new Color(252, 245, 210));

        // Thêm hình ảnh
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500, 40, 400, 300);
        
        // Thiết lập layout trước khi thêm thành phần
        setLayout(null);
        add(img);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel rollno = new JLabel("Select Roll Number");
        rollno.setBounds(50,70,150,20);
        add(rollno);

        
        choicerollno = new Choice();
        choicerollno.setBounds(200,70,150,20);
        add(choicerollno);
        
        try {
        	Conn c = new Conn();
        	ResultSet resultSet = c.statement.executeQuery("select * from student");
        	while(resultSet.next()) {
        		choicerollno.add(resultSet.getString("stuID"));
        
        	}
        }catch (Exception e) {
        	e.printStackTrace();
        }
        JLabel sem = new JLabel("Select Semester");
        sem.setBounds(50,110,150,20);
        add(sem);
        
        String semester[] = {"Học kì 1","Học kì 2","Học kì 3","Học kì 4","Học kì 5"};
        comboBox = new JComboBox(semester);
        comboBox.setBounds(200,110,150,20);
        comboBox.setBackground(Color.WHITE);
        add(comboBox);
        
        JLabel entersub = new JLabel("Enter subject");
        entersub.setBounds(100,150,200,40);
        add(entersub);
        
        JLabel entermarks = new JLabel("Enter marks");
        entermarks.setBounds(320,150,200,40);
        add(entermarks);
        
        sub1 = new JTextField();
        sub1.setBounds(50,200,200,20);
        add(sub1);
        
        sub2 = new JTextField();
        sub2.setBounds(50,230,200,20);
        add(sub2);
        
        sub3 = new JTextField();
        sub3.setBounds(50,260,200,20);
        add(sub3);
        
        sub4 = new JTextField();
        sub4.setBounds(50,290,200,20);
        add(sub4);
        
        sub5 = new JTextField();
        sub5.setBounds(50,320,200,20);
        add(sub5);
        
        mrk1 = new JTextField();
        mrk1.setBounds(250,200,200,20);
        add(mrk1);
        
        mrk2 = new JTextField();
        mrk2.setBounds(250,230,200,20);
        add(mrk2);
        
        mrk3 = new JTextField();
        mrk3.setBounds(250,260,200,20);
        add(mrk3);
        
        mrk4 = new JTextField();
        mrk4.setBounds(250,290,200,20);
        add(mrk4);
        
        mrk5 = new JTextField();
        mrk5.setBounds(250,320,200,20);
        add(mrk5);
        
        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        // Thiết lập kích thước và vị trí cửa sổ
        setSize(1000, 500);  // Tăng chiều cao cửa sổ
        setLocation(300, 150);
        setVisible(true);
    }
    

    public void actionPerformed(ActionEvent e) {
        // Xử lý hành động
    	if (e.getSource()== submit) {
    		String Q1 = "insert into subject values('"+choicerollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
			String Q2 = "insert into marks values('"+choicerollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+mrk1.getText()+"','"+mrk2.getText()+"','"+mrk3.getText()+"','"+mrk4.getText()+"','"+mrk5.getText()+"')";
			
    		try {
    			Conn c = new Conn();
    			c.statement.executeUpdate(Q1);
    			c.statement.executeUpdate(Q2);
                JOptionPane.showMessageDialog(null, "Successfull");
                setVisible(false);
                
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
}