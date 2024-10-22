package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class updateStudent extends JFrame implements ActionListener {
	JTextField textAddress, textPhone, textEmail, textUserId, textcourse, textbranch;
    JLabel empText;
    JButton cancel, submit;
    Choice cEMPID;
	 updateStudent(){
		 getContentPane().setBackground(new Color(230, 210, 252));

	        JLabel heading = new JLabel("Cập nhật thông tin học sinh");
	        heading.setBounds(50, 10, 500, 50);
	        heading.setFont(new Font("serif", Font.BOLD, 30));
	        add(heading);

	        JLabel empID = new JLabel(" Mã học sinh");
	        empID.setBounds(50, 100, 200, 20);
	        empID.setFont(new Font("serif", Font.PLAIN, 20));
	        add(empID);

	        cEMPID = new Choice();
	        cEMPID.setBounds(250, 100, 200, 20);
	        add(cEMPID);

	        try {
	            Conn c = new Conn();
	            ResultSet rs = c.statement.executeQuery("select * from student");
	            while (rs.next()) {
	                cEMPID.add(rs.getString("rollno"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // Name
	        JLabel name = new JLabel("Tên");
	        name.setBounds(50, 150, 100, 30);
	        name.setFont(new Font("serif", Font.BOLD, 20));
	        add(name);

	        JLabel textName = new JLabel();
	        textName.setBounds(200, 150, 150, 30);
	        add(textName);

	        // Father name
	        JLabel fname = new JLabel("Tên cha");
	        fname.setBounds(400, 150, 200, 30);
	        fname.setFont(new Font("serif", Font.BOLD, 20));
	        add(fname);

	        JLabel textFather = new JLabel();
	        textFather.setBounds(540, 150, 150, 30);
	        add(textFather);

	        // Employ ID
	        JLabel EMPIDD = new JLabel("Mã học sinh");
	        EMPIDD.setBounds(50, 200, 200, 30);
	        EMPIDD.setFont(new Font("serif", Font.BOLD, 20));
	        add(EMPIDD);

	        empText = new JLabel();
	        empText.setBounds(200, 200, 150, 30);
	        empText.setFont(new Font("serif", Font.BOLD, 20));
	        add(empText);

	        // Day Of Birth
	        JLabel dob = new JLabel("Ngày sinh");
	        dob.setBounds(400, 200, 200, 30);
	        dob.setFont(new Font("serif", Font.BOLD, 20));
	        add(dob);

	        JLabel dobdob = new JLabel();
	        dobdob.setBounds(600, 200, 150, 30);
	        add(dobdob);

	        // Address
	        JLabel address = new JLabel("Địa chỉ");
	        address.setBounds(50, 250, 200, 30);
	        address.setFont(new Font("serif", Font.BOLD, 20));
	        add(address);

	        textAddress = new JTextField();
	        textAddress.setBounds(200, 250, 150, 30);
	        add(textAddress);

	        // Phone
	        JLabel phone = new JLabel("Số điện thoại");
	        phone.setBounds(400, 250, 200, 30);
	        phone.setFont(new Font("serif", Font.BOLD, 20));
	        add(phone);

	        textPhone = new JTextField();
	        textPhone.setBounds(540, 250, 150, 30);
	        add(textPhone);

	        // Email
	        JLabel email = new JLabel("Email");
	        email.setBounds(50, 300, 200, 30);
	        email.setFont(new Font("serif", Font.BOLD, 20));
	        add(email);

	        textEmail = new JTextField();
	        textEmail.setBounds(200, 300, 150, 30);
	        add(textEmail);

	        // Class X
	        JLabel M10 = new JLabel("Lớp học X (%)");
	        M10.setBounds(400, 300, 200, 30);
	        M10.setFont(new Font("serif", Font.BOLD, 20));
	        add(M10);

	        JLabel textM10 = new JLabel();
	        textM10.setBounds(540, 300, 150, 30);
	        add(textM10);

	        // Class XII
	        JLabel M12 = new JLabel("Lớp học XII (%)");
	        M12.setBounds(50, 350, 200, 30);
	        M12.setFont(new Font("serif", Font.BOLD, 20));
	        add(M12);

	        JLabel textM12 = new JLabel();
	        textM12.setBounds(200, 350, 150, 30);
	        add(textM12);

	        // User ID
	        JLabel UserId = new JLabel("Mã định danh");
	        UserId.setBounds(400, 350, 200, 30);
	        UserId.setFont(new Font("serif", Font.BOLD, 20));
	        add(UserId);

	        textUserId = new JTextField();
	        textUserId.setBounds(540, 350, 150, 30);
	        add(textUserId);

	        // Qualification
	        JLabel Qualification = new JLabel("Khóa học ");
	        Qualification.setBounds(50, 400, 200, 30);
	        Qualification.setFont(new Font("serif", Font.BOLD, 20));
	        add(Qualification);
	        
	        textcourse = new JTextField();
	        textcourse.setBounds(200, 400, 150, 30);
	        add(textcourse);

	        // Department
	        JLabel department = new JLabel("Lớp");
	        department.setBounds(400, 400, 200, 30);
	        department.setFont(new Font("serif", Font.BOLD, 20));
	        add(department);

	        textbranch = new JTextField();
	        textbranch.setBounds(540, 400, 150, 30);
	        add(textbranch);
	        
	        try {
	        	Conn c = new Conn();
	        	String query = "select * from student where rollno = '"+cEMPID.getSelectedItem() +"'";
	        	ResultSet resultSet =c.statement.executeQuery(query);
	        	while (resultSet.next()) {
	        		textName.setText(resultSet.getString("Tên"));
	        		textFather.setText(resultSet.getString("Tên cha"));
	        		dobdob.setText(resultSet.getString("Ngày sinh"));
	        		textAddress.setText(resultSet.getString("Địa chỉ"));
	        		textPhone.setText(resultSet.getString("Số điện thoại"));
	        		textEmail.setText(resultSet.getString("Email"));
	        		textM10.setText(resultSet.getString("Lớp học X (%)"));
	        		textM12.setText(resultSet.getString("Lớp học XII (%)"));
	        		textUserId.setText(resultSet.getString("Mã định danh"));
	        		empText.setText(resultSet.getString("rollno"));
	        		textcourse.setText(resultSet.getString("Khóa học"));
	        		textbranch.setText(resultSet.getString("Lớp"));
	        	}
	        }catch(Exception E) {
	        	E.printStackTrace();
	        }
	       
	        cEMPID.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                try {
	                    Conn c = new Conn();
	                    String query = "SELECT * FROM student WHERE rollno = '" + cEMPID.getSelectedItem() + "'";
	                    ResultSet resultSet = c.statement.executeQuery(query);
	                    while (resultSet.next()) {
	                		textName.setText(resultSet.getString("Tên"));
	                		textFather.setText(resultSet.getString("Tên cha"));
	                		dobdob.setText(resultSet.getString("Ngày sinh"));
	                		textAddress.setText(resultSet.getString("Địa chỉ"));
	                		textPhone.setText(resultSet.getString("Số điện thoại"));
	                		textEmail.setText(resultSet.getString("Email"));
	                		textM10.setText(resultSet.getString("Lớp học X (%)"));
	                		textM12.setText(resultSet.getString("Lớp học XII (%)"));
	                		textUserId.setText(resultSet.getString("Mã định danh"));
	                		empText.setText(resultSet.getString("rollno"));
	                		textcourse.setText(resultSet.getString("Khóa học"));
	                		textbranch.setText(resultSet.getString("Lớp"));
	                	}
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });


	        submit = new JButton("Nộp");
	        submit.setBounds(250, 550, 120, 30);
	        submit.setBackground(Color.GREEN);
	        submit.setForeground(Color.WHITE);
	        submit.addActionListener(this);
	        add(submit);

	        cancel = new JButton("Huỷ");
	        cancel.setBounds(400, 550, 120, 30);
	        cancel.setBackground(Color.RED);
	        cancel.setForeground(Color.WHITE);
	        cancel.addActionListener(this);
	        add(cancel);

	        setSize(900, 700);
	        setLocation(350, 50);
	        setLayout(null);
	        setVisible(true);
	 }
	 @Override
	    public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == submit) {
	            String empid =empText.getText();
	            String address =textAddress.getText();
	            String phone = textPhone.getText();
	            String email = textEmail.getText();
	            String course = textcourse.getText();
	            String branch = textbranch.getText();
	            try {
	            	String Q = "update student set Địa chỉ = '" + address + "', Số điện thoại = '" + phone + "', email = '" + email + "', Khóa học = '" + course + "',Lớp = '" + branch  +"',WHERE rollno = '" +  empid + "'" ;
	            	JOptionPane.showMessageDialog(null, "Submitted!");
	            	setVisible(false);
	            }catch(Exception E) {
	            	E.printStackTrace();
	            }
	            
	        } else {
	        	
	            setVisible(false);
	        }
		 
	 }
	 public static void main(String[] args) {
		new  updateStudent();
	 }
}
