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
    JComboBox courseBox,departmentBox, genderChoosen;
    JButton cancel, submit;

    Random ran = new Random();

    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L );
	
	AddStudent (){
		getContentPane().setBackground(new Color(128,176,255));

        JLabel heading = new JLabel("Thêm thông tin sinh viên");
        heading.setBounds(277,35,331,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        getContentPane().add(heading);

        //Name 
        
        JLabel name = new JLabel("Tên");
        name.setBounds(92,150,100,30);
        name.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(name);

        textName = new JTextField();
        textName.setFont(new Font("Dialog", Font.PLAIN, 18));
        textName.setBounds(242,150,150,30);
        getContentPane().add(textName);

        // Father name
        JLabel fname = new JLabel("Tên cha");
        fname.setBounds(499,150,200,30);
        fname.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(fname);

        textFather = new JTextField();
        textFather.setFont(new Font("Dialog", Font.PLAIN, 18));
        textFather.setBounds(639,150,150,30);
        getContentPane().add(textFather);

        // Employ ID
        JLabel empID = new JLabel("Mã số sinh viên");
        empID.setBounds(92,200,200,30);
        empID.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(empID);

        empText = new JLabel("1409" + f4);
        empText.setBounds(242,200,150,30);
        empText.setFont(new Font("Dialog", Font.PLAIN, 18));
        getContentPane().add(empText);

        // Day Of Birth
        JLabel dob = new JLabel("Ngày sinh");
        dob.setBounds(499,200,200,30);
        dob.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(639,200,150,30);
        getContentPane().add(cdob);

        // Address
        JLabel address = new JLabel("Địa chi");
        address.setBounds(92,250,200,30);
        address.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(address);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Dialog", Font.PLAIN, 18));
        textAddress.setBounds(242,250,150,30);
        getContentPane().add(textAddress);

        // Phone
        JLabel phone = new JLabel("Số điện thoại");
        phone.setBounds(499,250,200,30);
        phone.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(phone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("Dialog", Font.PLAIN, 18));
        textPhone.setBounds(639,250,150,30);
        getContentPane().add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(92,300,200,30);
        email.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(email);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
        textEmail.setBounds(242,300,150,30);
        getContentPane().add(textEmail);

        // Class X
        JLabel M10 = new JLabel("Lớp học X (%)");
        M10.setBounds(499,300,200,30);
        M10.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(M10);

        textM10 = new JTextField();
        textM10.setFont(new Font("Dialog", Font.PLAIN, 18));
        textM10.setBounds(639,300,150,30);
        getContentPane().add(textM10);

        // Class XII
        JLabel M12 = new JLabel("Lớp học XII (%)");
        M12.setBounds(92,350,200,30);
        M12.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(M12);

        textM12 = new JTextField();
        textM12.setFont(new Font("Dialog", Font.PLAIN, 18));
        textM12.setBounds(242,350,150,30);
        getContentPane().add(textM12);

        // Class XII
        JLabel UserId = new JLabel("Mã định danh");
        UserId.setBounds(499,350,200,30);
        UserId.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(UserId);

        textUserId = new JTextField();
        textUserId.setFont(new Font("Dialog", Font.PLAIN, 18));
        textUserId.setBounds(639,350,150,30);
        getContentPane().add(textUserId);

        // Qualification
        JLabel qualification = new JLabel("Tiến trình");
        qualification.setBounds(92,400,200,30);
        qualification.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(qualification);

        String course[] = {"Đại số", "Thể chất", "Tin học cơ bản", "Mạng", "Cơ sở sữ liệu", "Triết"};
        courseBox = new JComboBox(course);
        courseBox.setFont(new Font("Dialog", Font.PLAIN, 18));
        courseBox.setBounds(242,400,150,30);
        courseBox.setBackground(Color.WHITE);
        getContentPane().add(courseBox);

        // Department
        JLabel department = new JLabel("Nhánh");
        department.setBounds(499,400,200,30);
        department.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(department);

        String Department[] = {"Khoa học máy tính", "Cơ khí", "Oto", "Điện", "Trí tuệ nhân tạo"};
        departmentBox = new JComboBox(Department);
        departmentBox.setFont(new Font("Dialog", Font.PLAIN, 18));
        departmentBox.setBounds(639,400,150,30);
        departmentBox.setBackground(Color.WHITE);
        getContentPane().add(departmentBox);

        submit = new JButton("Nộp");
        submit.setFont(new Font("Tahoma", Font.BOLD, 18));
        submit.setBounds(303,502,120,30);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        getContentPane().add(submit);

        cancel = new JButton("Huỷ");
        cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        cancel.setBounds(453,502,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        getContentPane().add(cancel);

        setSize(900, 700);
        setLocation(350,50);
        getContentPane().setLayout(null);
        
        genderChoosen = new JComboBox();
        genderChoosen.setFont(new Font("Dialog", Font.PLAIN, 18));
        genderChoosen.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
        genderChoosen.setBounds(242, 448, 150, 30);
        getContentPane().add(genderChoosen);
        
        JLabel gender = new JLabel("Giới tính");
        gender.setFont(new Font("Dialog", Font.BOLD, 18));
        gender.setBounds(92, 456, 100, 14);
        getContentPane().add(gender);
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
            String gender = (String) genderChoosen.getSelectedItem() == "Nam" ? "male": "female";
            try{
                String q = "insert into student values ('"+name+"', '"+fname+"','"+stuid+"','"+dob+"', '"+address+"','"+phone+"','"+email+"', '"+x+"','"+xii+"', '"+userId+"', '"+course+"', '"+branch+"','"+gender+"')";
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
