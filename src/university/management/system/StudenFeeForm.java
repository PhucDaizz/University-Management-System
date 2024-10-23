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
    JLabel textName, textFName; // Định nghĩa các JLabel ở cấp lớp
    JComboBox courseBox, departmentBox, semesterBox; 

    // Constructor
    public StudenFeeForm() {
        getContentPane().setBackground(new Color(210, 252, 251));

        // Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 50, 500, 30);
        add(img);

        // Roll number label
        JLabel stuID = new JLabel("Mã Số:");
        stuID.setBounds(40, 60, 150, 20);
        stuID.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(stuID);

        // Roll number choice
        rollNumber = new Choice();
        rollNumber.setBounds(200, 60, 150, 20);
        add(rollNumber);

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
        add(name);

        JLabel textName = new JLabel(); // Khởi tạo textName
        textName.setBounds(200, 100, 150, 20);
        add(textName);

        JLabel fname = new JLabel("Tên Cha:");
        fname.setBounds(40, 140, 150, 20);
//        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel textFName = new JLabel(); // Khởi tạo textFName
        textFName.setBounds(200, 140, 150, 20);
        add(textFName);

        
        // Qualification
        JLabel qualification = new JLabel("Tiến trình");
        qualification.setBounds(40,180,150,20);
//        qualification.setFont(new Font("Tahoma",Font.BOLD,20));
        add(qualification);

        String course[] = {"Đại số", "Thể chất", "Tin học cơ bản", "Mạng", "Cơ sở sữ liệu", "Triết"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,180,200,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        // Department
        JLabel department = new JLabel("Nhánh");
        department.setBounds(40,220,150,20);
//        department.setFont(new Font("serif",Font.BOLD,16));
        add(department);

        String Department[] = {"Khoa học máy tính", "Cơ khí", "Oto", "Điện", "Trí tuệ nhân tạo"};
        departmentBox = new JComboBox(Department);
        departmentBox.setBounds(200,220,150,20);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);
        
      
        JLabel textsemester = new JLabel( "Học kì ");
        textsemester.setBounds( 40, 260, 150,  20);
        add(textsemester);

        String semester[] = {"Học kì 1", "Học kì 2", "Học kì 3", "Học kì 4", "Học kì 5", "Học kì 6", "Học kì 7", "Học kì 8"};
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(200, 260, 150, 20);
        add(semesterBox);
        
        
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
        setLayout(null);
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
        // Handle action events here if needed
    }

    public static void main(String[] args) {
        new StudenFeeForm(); 
    }
}