package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame implements ActionListener {
	JTextField textName, textFather, textAddress, textPhone, textEmail, textM10, textM12, textUserId;
    JLabel empText;
    JDateChooser cdob;
    JComboBox courseBox,departmentBox;
    JButton cancel, submit;

    Random ran = new Random();

    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L );
	
	AddStudent (){
		getContentPane().setBackground(new Color(128,176,255));

        JLabel heading = new JLabel("Thêm thông tin sinh viên");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        //Name 
        
        JLabel name = new JLabel("Tên");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200,150,150,30);
        add(textName);

        // Father name
        JLabel fname = new JLabel("Tên cha");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        textFather = new JTextField();
        textFather.setBounds(540,150,150,30);
        add(textFather);

        // Employ ID
        JLabel empID = new JLabel("Mã số sinh viên");
        empID.setBounds(50,200,200,30);
        empID.setFont(new Font("serif",Font.BOLD,20));
        add(empID);

        empText = new JLabel("1409" + f4);
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        // Day Of Birth
        JLabel dob = new JLabel("Ngày sinh");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(540,200,150,30);
        add(cdob);

        // Address
        JLabel address = new JLabel("Địa chi");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        // Phone
        JLabel phone = new JLabel("Số điện thoại");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(540,250,150,30);
        add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200,300,150,30);
        add(textEmail);

        // Class X
        JLabel M10 = new JLabel("Lớp học X (%)");
        M10.setBounds(400,300,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(540,300,150,30);
        add(textM10);

        // Class XII
        JLabel M12 = new JLabel("Lớp học XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        // Class XII
        JLabel UserId = new JLabel("Mã định danh");
        UserId.setBounds(400,350,200,30);
        UserId.setFont(new Font("serif",Font.BOLD,20));
        add(UserId);

        textUserId = new JTextField();
        textUserId.setBounds(540,350,150,30);
        add(textUserId);

        // Qualification
        JLabel qualification = new JLabel("Tiến trình");
        qualification.setBounds(50,400,200,30);
        qualification.setFont(new Font("serif",Font.BOLD,20));
        add(qualification);

        String course[] = {"Đại số", "Thể chất", "Tin học cơ bản", "Mạng", "Cơ sở sữ liệu", "Triết"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        // Department
        JLabel department = new JLabel("Nhánh");
        department.setBounds(400,400,200,30);
        department.setFont(new Font("serif",Font.BOLD,20));
        add(department);

        String Department[] = {"Khoa học máy tính", "Cơ khí", "Oto", "Điện", "Trí tuệ nhân tạo"};
        departmentBox = new JComboBox(Department);
        departmentBox.setBounds(540,400,150,30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        submit = new JButton("Nộp");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Huỷ");
        cancel.setBounds(400,550,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
            String name = textName.getText();
            String fname = textFather.getText();
            String stuid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String course = (String) courseBox.getSelectedItem();
            String branch = (String) departmentBox.getSelectedItem();
            String userId = textUserId.getText();
            try{
                String q = "insert into student values ('"+name+"', '"+fname+"','"+stuid+"','"+dob+"', '"+address+"','"+phone+"','"+email+"', '"+x+"','"+xii+"', '"+userId+"', '"+course+"', '"+branch+"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Hoàn tất");
                setVisible(false);
                System.out.println("Submit button clicked");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
	}
	public static void main(String[] args) {
		new AddStudent();
		
	}
}
