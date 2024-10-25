package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudenFeeForm extends JFrame implements ActionListener {
    Choice rollNumber;
    JLabel textName, textFName, totalAmount; // Định nghĩa các JLabel ở cấp lớp
    JComboBox courseBox, departmentBox, semesterBox; 
    JButton pay, update, back;

    // Constructor
    public StudenFeeForm() {
        getContentPane().setBackground(new Color(210, 252, 251));
        // Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(410, 50, 451, 300);
        getContentPane().add(img);

        // Roll number label
        JLabel stuID = new JLabel("Mã Số:");
        stuID.setBounds(40, 60, 150, 20);
        stuID.setFont(new Font("Tahoma", Font.BOLD, 16));
        getContentPane().add(stuID);

        // Roll number choice
        rollNumber = new Choice();
        rollNumber.setBounds(200, 60, 150, 20);
        getContentPane().add(rollNumber);

        // Populate choice with roll numbers from database
        try {
            Conn c = new Conn(); // Create a connection object
            ResultSet rs = c.statement.executeQuery("select *from student"); // Query the student table

            while (rs.next()) {
                rollNumber.add(rs.getString("stuID")); // Corrected to use rollNumber
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage()); // Show error message
        	e.printStackTrace();
        }

        JLabel name = new JLabel("Tên:");
        name.setBounds(40, 100, 150, 20);
//        name.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(name);

        JLabel textName = new JLabel(); // Khởi tạo textName
        textName.setBounds(200, 100, 150, 20);
        getContentPane().add(textName);

        JLabel fname = new JLabel("Tên Cha:");
        fname.setBounds(40, 140, 150, 20);
//        fname.setFont(new Font("serif", Font.BOLD, 20));
        getContentPane().add(fname);

        JLabel textFName = new JLabel(); // Khởi tạo textFName
        textFName.setBounds(200, 140, 150, 20);
        getContentPane().add(textFName);

        
        // Qualification
        JLabel qualification = new JLabel("Khóa học");
        qualification.setBounds(40,180,150,20);
//        qualification.setFont(new Font("Tahoma",Font.BOLD,20));
        getContentPane().add(qualification);

        String course[] = {"Lịch Sử Đảng", "Đại số", "Thể chất", "Tin học cơ bản", "Mạng", "Cơ sở sữ liệu", "Triết","Lập Trình Mạng"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,180,200,30);
        courseBox.setBackground(Color.WHITE);
        getContentPane().add(courseBox);

        // Department
        JLabel department = new JLabel("Nhánh");
        department.setBounds(40,220,150,20);
//        department.setFont(new Font("serif",Font.BOLD,16));
        getContentPane().add(department);

        String Department[] = {"Khoa học máy tính", "Cơ khí", "Oto", "Điện", "Trí tuệ nhân tạo"};
        departmentBox = new JComboBox(Department);
        departmentBox.setBounds(200,220,150,20);
        departmentBox.setBackground(Color.WHITE);
        getContentPane().add(departmentBox);
        
      
        JLabel textsemester = new JLabel( "Học kì ");
        textsemester.setBounds( 40, 260, 150,  20);
        getContentPane().add(textsemester);

        String semester[] = {"Học kì 1", "Học kì 2", "Học kì 3", "Học kì 4", "Học kì 5", "Học kì 6", "Học kì 7", "Học kì 8"};
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(200, 260, 150, 20);
        getContentPane().add(semesterBox);
        
        
        JLabel total = new JLabel( "Số tiền phải trả");
        total.setBounds( 40, 330,  150, 20);
        getContentPane().add(total);

        totalAmount = new JLabel();
        totalAmount.setBounds( 200, 330,  150, 20);
        getContentPane().add(totalAmount);

        update = new JButton( "Cập nhật");
        update.setBounds( 30, 380,  100,  25);
        update.addActionListener(this);
        getContentPane().add(update);
        
        pay = new JButton( "Chi trả");
        pay.setBounds( 150, 380,  100,  25);
        pay.addActionListener(this);
        getContentPane().add(pay);
        
        back = new JButton( "Trở về");
        back.setBounds( 270, 380,  100,  25);
        back.addActionListener(this);
        getContentPane().add(back);

        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM student WHERE stuID = '" + rollNumber.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFName.setText(resultSet.getString("fname"));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        
        // Khi chọn số báo danh, lấy dữ liệu từ cơ sở dữ liệu
        rollNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "SELECT * FROM student WHERE stuID = '" + rollNumber.getSelectedItem() + "'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    

                    while (resultSet.next()) {
                
                        textName.setText(resultSet.getString("name"));
                        textFName.setText(resultSet.getString("fname"));
                        
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
              
              
        // Set up JFrame
        setSize(900, 500);
        setLocation(350, 10);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadRollNumbers() {
        // Load roll numbers from the database
        try {
            Conn c = new Conn(); // Create a connection object
            ResultSet rs = c.statement.executeQuery("select *from student"); // Query the student table

            while (rs.next()) {
                rollNumber.add(rs.getString("stuID")); // Populate roll numbers
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage()); // Show error message
        }
    }

    private void fetchStudentDetails() {
        // Fetch student details based on selected roll number
        try {
            Conn c = new Conn();
            String query = "select *from student WHERE stuID = '" + rollNumber.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            if (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFName.setText(resultSet.getString("fname"));
            } else {
                // Clear labels if no student found
                textName.setText("");
                textFName.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();

            // Xác định cột học kỳ dựa trên học kỳ đã chọn
            String semesterColumn = "";
            switch (semester) {
                case "Học kì 1": semesterColumn = "semester1"; break;
                case "Học kì 2": semesterColumn = "semester2"; break;
                case "Học kì 3": semesterColumn = "semester3"; break;
                case "Học kì 4": semesterColumn = "semester4"; break;
                case "Học kì 5": semesterColumn = "semester5"; break;
                case "Học kì 6": semesterColumn = "semester6"; break;
                case "Học kì 7": semesterColumn = "semester7"; break;
                case "Học kì 8": semesterColumn = "semester8"; break;
            }
            try {
                Conn c = new Conn();
                String query = "SELECT " + semesterColumn + " FROM fee WHERE course='" + course + "'";
                ResultSet rs = c.statement.executeQuery(query);

                if (rs.next()) {
                    totalAmount.setText(rs.getString(semesterColumn));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if( e.getSource() == pay){
        	String stuID = rollNumber.getSelectedItem();
        	String course = (String)courseBox.getSelectedItem();
        	String semester = (String)semesterBox.getSelectedItem();
        	String Department = (String)departmentBox.getSelectedItem();
        	String total = totalAmount.getText();
        	try {
        		Conn c = new Conn();

        		// Tạo câu lệnh chèn dữ liệu
        		String Q = "INSERT INTO feecollege VALUES('" + stuID + "','" + course + "','" + Department + "','" + semester + "','" + total + "')";

        		// Thực thi câu lệnh
        		c.statement.executeUpdate(Q);

        		// Hiển thị thông báo thành công
        		JOptionPane.showMessageDialog(null, "Fee Submitted successfully");
        	}catch (Exception ex) {
        		ex.printStackTrace();
        	}
        	
        }else {
        	setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudenFeeForm(); 
    }
}