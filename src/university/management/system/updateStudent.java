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
    JButton cancel, submit;
    Choice cEMPID;

    updateStudent() {
        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Cập nhật thông tin học sinh");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel empID = new JLabel("Số báo danh");
        empID.setBounds(50, 100, 200, 20);
        empID.setFont(new Font("serif", Font.PLAIN, 20));
        add(empID);

        cEMPID = new Choice();
        cEMPID.setBounds(250, 100, 200, 20);
        add(cEMPID);

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
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200, 150, 150, 30);
        add(textName);

        // Tên cha
        JLabel fname = new JLabel("Tên cha");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel textFather = new JLabel();
        textFather.setBounds(540, 150, 150, 30);
        add(textFather);

        // Số báo danh
        JLabel stuID = new JLabel("Số báo danh");
        stuID.setBounds(50, 200, 200, 30);
        stuID.setFont(new Font("serif", Font.BOLD, 20));
        add(stuID);

        empText = new JLabel();
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        add(empText);

        // Ngày sinh
        JLabel dob = new JLabel("Ngày sinh");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        JLabel dobText = new JLabel();
        dobText.setBounds(600, 200, 150, 30);
        add(dobText);

        // Địa chỉ
        JLabel address = new JLabel("Địa chỉ");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        add(textAddress);

        // Số điện thoại
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

        // Lớp X
        JLabel class_X = new JLabel("Lớp X (%)");
        class_X .setBounds(400, 300, 200, 30);
        class_X .setFont(new Font("serif", Font.BOLD, 20));
        add(class_X );

        JLabel textM10 = new JLabel();
        textM10.setBounds(540, 300, 150, 30);
        add(textM10);

        // Lớp XII
        JLabel class_XII = new JLabel("Lớp XII (%)");
        class_XII.setBounds(50, 350, 200, 30);
        class_XII.setFont(new Font("serif", Font.BOLD, 20));
        add(class_XII);

        JLabel textM12 = new JLabel();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        // Mã định danh
        JLabel userID = new JLabel("Mã định danh");
        userID.setBounds(400, 350, 200, 30);
        userID.setFont(new Font("serif", Font.BOLD, 20));
        add(userID);

        textUserId = new JTextField();
        textUserId.setBounds(540, 350, 150, 30);
        add(textUserId);

        // Khóa học
        JLabel course = new JLabel("Khóa học");
        course.setBounds(50, 400, 200, 30);
        course.setFont(new Font("serif", Font.BOLD, 20));
        add(course);

        textCourse = new JTextField();
        textCourse.setBounds(200, 400, 150, 30);
        add(textCourse);

        // Ngành học
        JLabel branch = new JLabel("Ngành học");
        branch.setBounds(400, 400, 200, 30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        add(branch);

        textBranch = new JTextField();
        textBranch.setBounds(540, 400, 150, 30);
        add(textBranch);

        
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
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.GREEN);	
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        // Nút Huỷ
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
            setVisible(false);
        }
    }

    public static void main(String[] args) {
    	new  updateStudent();
    }
}