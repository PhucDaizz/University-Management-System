package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField textAddress, textPhone, textEmail, textUserId, textcourse, textbranch;
    JLabel empText;
    JLabel textName, textFather, dobText, textM10, textM12;
    JButton cancel, submit;
    Choice cEMPID;
    String selectedEmpId;

    UpdateTeacher() {
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Cập nhật thông tin về giáo viên");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        getContentPane().add(heading);

        JLabel empID = new JLabel("Mã nhân viên");
        empID.setBounds(50, 100, 128, 20);
        empID.setFont(new Font("Serif", Font.BOLD, 20));
        getContentPane().add(empID);

        cEMPID = new Choice();
        cEMPID.setFont(new Font("Dialog", Font.PLAIN, 16));
        cEMPID.setBounds(200, 102, 200, 20);
        getContentPane().add(cEMPID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from teacher");
            while (rs.next()) {
                cEMPID.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Name
        JLabel name = new JLabel("Tên");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(name);

        textName = new JLabel();
        textName.setFont(new Font("Dialog", Font.PLAIN, 16));
        textName.setBounds(200, 150, 150, 30);
        getContentPane().add(textName);

        // Father name
        JLabel fname = new JLabel("Tên cha");
        fname.setBounds(400, 150, 128, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(fname);

        textFather = new JLabel();
        textFather.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textFather.setBounds(540, 150, 150, 30);
        getContentPane().add(textFather);

        // Employee ID
        JLabel EMPIDD = new JLabel("Mã giảng viên");
        EMPIDD.setBounds(50, 200, 200, 30);
        EMPIDD.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(EMPIDD);

        empText = new JLabel();
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("Dialog", Font.PLAIN, 16));
        getContentPane().add(empText);

        // Date of Birth
        JLabel dob = new JLabel("Ngày sinh");
        dob.setBounds(400, 200, 120, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(dob);

        dobText = new JLabel();
        dobText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        dobText.setBounds(550, 200, 150, 30);
        getContentPane().add(dobText);

        // Address
        JLabel address = new JLabel("Địa chỉ");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(address);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
        textAddress.setBounds(200, 250, 150, 30);
        getContentPane().add(textAddress);

        // Phone
        JLabel phone = new JLabel("Số điện thoại");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(phone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textPhone.setBounds(540, 250, 150, 30);
        getContentPane().add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(email);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Dialog", Font.PLAIN, 16));
        textEmail.setBounds(200, 300, 150, 30);
        getContentPane().add(textEmail);

        // Class X
        JLabel class_X = new JLabel("Lớp học X (%)");
        class_X.setBounds(400, 300, 200, 30);
        class_X.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(class_X);

        textM10 = new JLabel();
        textM10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textM10.setBounds(540, 300, 150, 30);
        getContentPane().add(textM10);

        // Class XII
        JLabel class_XII = new JLabel("Lớp học XII (%)");
        class_XII.setBounds(50, 350, 200, 30);
        class_XII.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(class_XII);

        textM12 = new JLabel();
        textM12.setFont(new Font("Dialog", Font.PLAIN, 16));
        textM12.setBounds(200, 350, 150, 30);
        getContentPane().add(textM12);

        // User ID
        JLabel userId = new JLabel("Mã định danh");
        userId.setBounds(400, 350, 200, 30);
        userId.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(userId);

        textUserId = new JTextField();
        textUserId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textUserId.setBounds(540, 350, 150, 30);
        getContentPane().add(textUserId);

        // Education
        JLabel education = new JLabel("Trình độ");
        education.setBounds(50, 400, 200, 30);
        education.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(education);

        textcourse = new JTextField();
        textcourse.setFont(new Font("Dialog", Font.PLAIN, 16));
        textcourse.setBounds(200, 400, 150, 30);
        getContentPane().add(textcourse);

        // Department
        JLabel department = new JLabel("Khoa");
        department.setBounds(400, 400, 200, 30);
        department.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(department);

        textbranch = new JTextField();
        textbranch.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textbranch.setBounds(540, 400, 150, 30);
        getContentPane().add(textbranch);

        try {
            Conn c = new Conn();
            String query = "select * from teacher where empId = '" + cEMPID.getSelectedItem() + "'";
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
                empText.setText(resultSet.getString("empId"));
                textcourse.setText(resultSet.getString("education"));
                textbranch.setText(resultSet.getString("department"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "SELECT * FROM teacher WHERE empId = '" + cEMPID.getSelectedItem() + "'";
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
                        empText.setText(resultSet.getString("empId"));
                        textcourse.setText(resultSet.getString("education"));
                        textbranch.setText(resultSet.getString("department"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        submit = new JButton("Nộp");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBounds(305, 534, 120, 30);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        getContentPane().add(submit);

        cancel = new JButton("Huỷ");
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cancel.setBounds(455, 534, 120, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        getContentPane().add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    UpdateTeacher(String empId) {
        this();  // Gọi constructor gốc
        this.selectedEmpId = empId;
        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM teacher WHERE empId = '" + selectedEmpId + "'";
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
                empText.setText(resultSet.getString("empId"));
                textcourse.setText(resultSet.getString("education"));
                textbranch.setText(resultSet.getString("department"));
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
            String education = textcourse.getText();
            String department = textbranch.getText();
            
            try {
                Conn c = new Conn();
                String query = "UPDATE teacher SET address = '" + address + "', phone = '" + phone + 
                             "', email = '" + email + "', education = '" + education + 
                             "', department = '" + department + "' WHERE empId = '" + empid + "'";
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
        new UpdateTeacher();
    }
}