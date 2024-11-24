package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class updateStudent extends JFrame implements ActionListener {
    JTextField textAddress, textPhone, textEmail, textUserId, textCourse, textBranch;
    JLabel empText;
    JLabel textName, textFather, dobText, textM10, textM12;
    JButton cancel, submit;
    Choice cEMPID;
    String selectedStuId;

    updateStudent() {
    	getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Cập nhật thông tin học sinh");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        getContentPane().add(heading);

        JLabel empID = new JLabel("Số báo danh");
        empID.setBounds(50, 100, 130, 20);
        empID.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(empID);

        cEMPID = new Choice();
        cEMPID.setFont(new Font("Dialog", Font.PLAIN, 16));
        cEMPID.setBounds(200, 100, 200, 20);
        getContentPane().add(cEMPID);

        // Kết nối cơ sở dữ liệu và lấy danh sách số báo danh
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()) {
                cEMPID.add(rs.getString("stuID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tên
        JLabel name = new JLabel("Tên");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(name);

        textName = new JLabel();
        textName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textName.setBounds(200, 150, 150, 30);
        getContentPane().add(textName);

        // Tên cha
        JLabel fname = new JLabel("Họ");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(fname);

        textFather = new JLabel();
        textFather.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textFather.setBounds(540, 150, 150, 30);
        getContentPane().add(textFather);

        // Số báo danh
        JLabel stuID = new JLabel("Số báo danh");
        stuID.setBounds(50, 200, 200, 30);
        stuID.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(stuID);

        empText = new JLabel();
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("Serif", Font.BOLD, 16));
        getContentPane().add(empText);

        // Ngày sinh
        JLabel dob = new JLabel("Ngày sinh");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(dob);

        dobText = new JLabel();
        dobText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        dobText.setBounds(540, 200, 150, 30);
        getContentPane().add(dobText);

        // Địa chỉ
        JLabel address = new JLabel("Địa chỉ");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(address);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textAddress.setBounds(200, 250, 150, 30);
        getContentPane().add(textAddress);

        // Số điện thoại
        JLabel phone = new JLabel("Số điện thoại");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(phone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textPhone.setBounds(540, 250, 150, 30);
        getContentPane().add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(email);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textEmail.setBounds(200, 300, 150, 30);
        getContentPane().add(textEmail);

        // Lớp X
        JLabel class_X = new JLabel("Lớp X (%)");
        class_X .setBounds(400, 300, 200, 30);
        class_X .setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(class_X );

        textM10 = new JLabel();
        textM10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textM10.setBounds(540, 300, 150, 30);
        getContentPane().add(textM10);

        // Lớp XII
        JLabel class_XII = new JLabel("Lớp XII (%)");
        class_XII.setBounds(50, 350, 200, 30);
        class_XII.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(class_XII);

        textM12 = new JLabel();
        textM12.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textM12.setBounds(200, 350, 150, 30);
        getContentPane().add(textM12);

        // Mã định danh
        JLabel userID = new JLabel("Mã định danh");
        userID.setBounds(400, 350, 200, 30);
        userID.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(userID);

        textUserId = new JTextField();
        textUserId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textUserId.setBounds(540, 350, 150, 30);
        getContentPane().add(textUserId);

        // Khóa học
        JLabel course = new JLabel("Khóa học");
        course.setBounds(50, 400, 200, 30);
        course.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(course);

        textCourse = new JTextField();
        textCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textCourse.setBounds(200, 400, 150, 30);
        getContentPane().add(textCourse);

        // Ngành học
        JLabel branch = new JLabel("Ngành học");
        branch.setBounds(400, 400, 200, 30);
        branch.setFont(new Font("Dialog", Font.BOLD, 20));
        getContentPane().add(branch);

        textBranch = new JTextField();
        textBranch.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textBranch.setBounds(540, 400, 150, 30);
        getContentPane().add(textBranch);

        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM student WHERE stuID = '" + cEMPID.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("fname"));
                dobText.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_X"));
                textM12.setText(resultSet.getString("class_XII"));
                textUserId.setText(resultSet.getString("userId"));
                empText.setText(resultSet.getString("stuID"));
                textCourse.setText(resultSet.getString("course"));
                textBranch.setText(resultSet.getString("branch"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        
        // Khi chọn số báo danh, lấy dữ liệu từ cơ sở dữ liệu
        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "SELECT * FROM student WHERE stuID = '" + cEMPID.getSelectedItem() + "'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    

                    while (resultSet.next()) {
                
                        textName.setText(resultSet.getString("name"));
                        textFather.setText(resultSet.getString("fname"));
                        dobText.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                        textM10.setText(resultSet.getString("class_X"));
                        textM12.setText(resultSet.getString("class_XII"));
                        textUserId.setText(resultSet.getString("userID"));
                        empText.setText(resultSet.getString("stuID"));
                        textCourse.setText(resultSet.getString("course"));
                        textBranch.setText(resultSet.getString("branch"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Nút Nộp
        submit = new JButton("Nộp");
        submit.setBounds(280, 550, 120, 30);
        submit.setBackground(Color.GREEN);	
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        getContentPane().add(submit);

        // Nút Huỷ
        cancel = new JButton("Huỷ");
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cancel.setBounds(480, 547, 120, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        getContentPane().add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    updateStudent(String stuId) {
        this();  // Gọi constructor gốc
        this.selectedStuId = stuId;
        // Load dữ liệu của sinh viên được chọn
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM student WHERE stuID = '" + selectedStuId + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            if (resultSet.next()) {
            	textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("fname"));
                dobText.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_X"));
                textM12.setText(resultSet.getString("class_XII"));
                textUserId.setText(resultSet.getString("userId"));
                empText.setText(resultSet.getString("stuID"));
                textCourse.setText(resultSet.getString("course"));
                textBranch.setText(resultSet.getString("branch"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String empid = empText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String course = textCourse.getText();
            String branch = textBranch.getText();
            try {
                Conn c = new Conn();
                String query = "UPDATE student SET address = '" + address + "', phone = '" + phone + "', email = '" + email + "', course = '" + course + "', branch = '" + branch + "' WHERE stuID = '" + empid + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thông tin đã được cập nhật!");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
        	dispose();
        }
    }

    public static void main(String[] args) {
    	new  updateStudent();
    }
}