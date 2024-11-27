package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName, textFather, textAddress, textPhone, textEmail, textM10, textM12, textUserId;
    JLabel empText;
    JDateChooser cdob;
    JComboBox departmentBox;
    JButton cancel, submit;
    JComboBox<String> courseBox;
    Random ran = new Random();

    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L );
    AddFaculty() {
    	getContentPane().setFont(new Font("Dialog", Font.BOLD, 18));

        getContentPane().setBackground(new Color(166,164,252));

        JLabel heading = new JLabel("Thêm thông tin giảng viên");
        heading.setVerticalAlignment(SwingConstants.TOP);
        heading.setBounds(268,31,339,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        getContentPane().add(heading);

        // Name
        JLabel name = new JLabel("Tên");
        name.setBounds(78,150,100,30);
        name.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(name);

        textName = new JTextField();
        textName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textName.setBounds(241,150,150,30);
        getContentPane().add(textName);

        // Father name
        JLabel fname = new JLabel("Họ ");
        fname.setBounds(505,150,200,30);
        fname.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(fname);

        textFather = new JTextField();
        textFather.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textFather.setBounds(645,150,150,30);
        getContentPane().add(textFather);

        // Employ ID
        JLabel empID = new JLabel("Mã giảng viên");
        empID.setBounds(78,200,200,30);
        empID.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(empID);

        empText = new JLabel("1409" + f4);
        empText.setBounds(241,200,150,30);
        empText.setFont(new Font("Dialog", Font.PLAIN, 18));
        getContentPane().add(empText);

        // Day Of Birth
        JLabel dob = new JLabel("Ngày sinh");
        dob.setBounds(505,200,200,30);
        dob.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(645,200,150,30);
        getContentPane().add(cdob);

        // Address
        JLabel address = new JLabel("Địa chi");
        address.setBounds(78,250,200,30);
        address.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(address);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Dialog", Font.PLAIN, 18));
        textAddress.setBounds(241,250,150,30);
        getContentPane().add(textAddress);

        // Phone
        JLabel phone = new JLabel("Số điện thoại");
        phone.setBounds(505,250,200,30);
        phone.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(phone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textPhone.setBounds(645,250,150,30);
        getContentPane().add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(78,300,200,30);
        email.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(email);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
        textEmail.setBounds(241,300,150,30);
        getContentPane().add(textEmail);

        // Class X
        JLabel M10 = new JLabel("Lớp học X (%)");
        M10.setBounds(505,300,200,30);
        M10.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(M10);

        textM10 = new JTextField();
        textM10.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textM10.setBounds(645,300,150,30);
        getContentPane().add(textM10);

        // Class XII
        JLabel M12 = new JLabel("Lớp học XII (%)");
        M12.setBounds(78,350,200,30);
        M12.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(M12);

        textM12 = new JTextField();
        textM12.setFont(new Font("Dialog", Font.PLAIN, 18));
        textM12.setBounds(241,350,150,30);
        getContentPane().add(textM12);

        // Class XII
        JLabel UserId = new JLabel("Mã định danh");
        UserId.setBounds(505,350,200,30);
        UserId.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(UserId);

        textUserId = new JTextField();
        textUserId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textUserId.setBounds(645,350,150,30);
        getContentPane().add(textUserId);

        // Qualification
        JLabel qualification = new JLabel("T.độ chuyên môn");
        qualification.setBounds(78,400,200,30);
        qualification.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(qualification);

        courseBox = new JComboBox<>(); 
        courseBox.setFont(new Font("Dialog", Font.PLAIN, 18)); 
        courseBox.setBounds(241, 400, 150, 30); 
        courseBox.setBackground(Color.WHITE);
        
        ArrayList<String> courses = getCoursesFromDatabase(); 
        for (String course : courses) { 
        	courseBox.addItem(course);
        }
        
        getContentPane().add(courseBox);

        // Department
        JLabel department = new JLabel("Khoa");
        department.setBounds(505,400,200,30);
        department.setFont(new Font("Dialog", Font.BOLD, 18));
        getContentPane().add(department);

        String Department[] = {"Khoa học máy tính", "Cơ khí", "Oto", "Điện", "Trí tuệ nhân tạo","Logistic", "Ngôn ngữ anh", "Xây dựng"};
        departmentBox = new JComboBox(Department);
        departmentBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        departmentBox.setBounds(645,400,150,30);
        departmentBox.setBackground(Color.WHITE);
        getContentPane().add(departmentBox);

        submit = new JButton("Nộp");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBounds(322,511,120,30);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        getContentPane().add(submit);

        cancel = new JButton("Huỷ");
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cancel.setBounds(472,511,120,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        getContentPane().add(cancel);

        setSize(900, 700);
        setLocation(350,50);
        getContentPane().setLayout(null);
        setVisible(true);
    }
    
    public static ArrayList<String> getCoursesFromDatabase() { 
    	ArrayList<String> courses = new ArrayList<>(); 
    	try (Connection conn = Conn.getConnection(); 
    		Statement stmt = conn.createStatement(); 
    		ResultSet rs = stmt.executeQuery("SELECT course FROM fee")) { 
    		
    		while (rs.next()) { 
    			courses.add(rs.getString("course")); 
    		} 
    	} catch (Exception e) { 
    		e.printStackTrace(); 
    	} 
    	return courses;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            String name = textName.getText();
            String fname = textFather.getText();
            String empid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();
            String userId = textUserId.getText();
            try{
                String q = "insert into teacher values ('"+name+"', '"+fname+"','"+empid+"','"+dob+"', '"+address+"','"+phone+"','"+email+"', '"+x+"','"+xii+"', '"+userId+"', '"+course+"', '"+department+"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Hoàn tất");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddFaculty();
    }
}
