package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

        String semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(200, 260, 150, 20);
        getContentPane().add(semesterBox);
        semesterBox.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) { 
        		String stuId = (String) rollNumber.getSelectedItem(); 
        		String semester = (String) semesterBox.getSelectedItem(); 
        		updateCourseBox(stuId, semester); 
        		} 
        	});
        
        
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
    
    private void updateCourseBox(String stuId, String semester) { 
    	String[] subjects = getSubjects(stuId, semester); 
    	courseBox.removeAllItems(); 
    	for (String subject : subjects) { 
    		courseBox.addItem(subject); 
    	} 
    }
	

    private void loadRollNumbers() {
        try {
            Conn c = new Conn(); 
            ResultSet rs = c.statement.executeQuery("select *from student"); 

            while (rs.next()) {
                rollNumber.add(rs.getString("stuID")); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage()); 
        }
    }

    private void fetchStudentDetails() {
        try {
            Conn c = new Conn();
            String query = "select *from student WHERE stuID = '" + rollNumber.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            if (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFName.setText(resultSet.getString("fname"));
            } else {
                textName.setText("");
                textFName.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private String[] getSubjects(String stuID, String semester) {
    	String sql = "SELECT subj1, subj2, subj3, subj4, sbj5 FROM subject WHERE stuID = ? AND semester = ?"; 
    	String[] subjects = new String[5];
    	try (Connection conn = Conn.getConnection(); 
    		PreparedStatement stmt = conn.prepareStatement(sql)) { 
    		
    		stmt.setString(1, stuID); 
    		stmt.setString(2, semester);
    		
    		try (ResultSet rs = stmt.executeQuery()) { 
    			if (rs.next()) { 
    				subjects[0] = rs.getString("subj1"); 
    				subjects[1] = rs.getString("subj2"); 
    				subjects[2] = rs.getString("subj3"); 
    				subjects[3] = rs.getString("subj4"); 
    				subjects[4] = rs.getString("sbj5"); 
    				} 
    			} 
    		} catch (SQLException e) { 
    			e.printStackTrace(); 
    		} return subjects;
    }
    
    private boolean isPay(String stuID, String semester, String course) {
    	String querry = "SELECT COUNT(*) FROM feecollege WHERE stuID = ? AND semester = ? AND course = ?";
    	try (Connection conn = Conn.getConnection(); 
        	PreparedStatement stmt = conn.prepareStatement(querry)) { 
        		
        	stmt.setString(1, stuID); 
        	stmt.setString(2, semester);
        	stmt.setString(3, course);
        		
        	try (ResultSet rs = stmt.executeQuery()) { 
        		if (rs.next()) { 
        			int count = rs.getInt(1); 
        			return count > 0;
        		}
        	} 
        } catch (SQLException e) { 
      		e.printStackTrace(); 
        }
    	return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();

            // Xác định cột học kỳ dựa trên học kỳ đã chọn
//            String semesterColumn = "";
//            switch (semester) {
//                case "Học kì 1": semesterColumn = "semester1"; break;
//                case "Học kì 2": semesterColumn = "semester2"; break;
//                case "Học kì 3": semesterColumn = "semester3"; break;
//                case "Học kì 4": semesterColumn = "semester4"; break;
//                case "Học kì 5": semesterColumn = "semester5"; break;
//                case "Học kì 6": semesterColumn = "semester6"; break;
//                case "Học kì 7": semesterColumn = "semester7"; break;
//                case "Học kì 8": semesterColumn = "semester8"; break;
//            }
            try {
                Conn c = new Conn();
                String query = "SELECT " + semester + " FROM fee WHERE course='" + course + "'";
                ResultSet rs = c.statement.executeQuery(query);

                if (rs.next()) {
                    totalAmount.setText(rs.getString(semester));
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
        		if(isPay(stuID,semester,course)) {
        			JOptionPane.showMessageDialog(null, "Bạn đã thanh toán môn học này rồi!");
        		}
        		else {
        			if(total == null || total.isEmpty()) {
        				JOptionPane.showMessageDialog(null, "Bạn cần cập nhật giá trước để thanh toán!");
        			}
        			else {
        				Conn c = new Conn();
        				String Q = "INSERT INTO feecollege VALUES('" + stuID + "','" + course + "','" + Department + "','" + semester + "','" + total + "')";
        				c.statement.executeUpdate(Q);
        				JOptionPane.showMessageDialog(null, "Thanh toán thành công");        			        				
        			}
        		}
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