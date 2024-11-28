package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnterMarks extends JFrame implements ActionListener {
	Choice choicerollno;
	JComboBox comboBox;
	JTextField sub1, sub2, sub3, sub4, sub5, mrk1, mrk2, mrk3, mrk4, mrk5;
    JButton submit, cancel, update;
	EnterMarks() {
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 14));
        // Thiết lập màu nền
        getContentPane().setBackground(new Color(252, 245, 210));

        // Thêm hình ảnh
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(549, 42, 400, 300);
        
        // Thiết lập layout trước khi thêm thành phần
        getContentPane().setLayout(null);
        getContentPane().add(img);
        
        JLabel heading = new JLabel("Nhâp điểm cho sinh viên");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        getContentPane().add(heading);
        
        JLabel rollno = new JLabel("Mã sinh viên");
        rollno.setFont(new Font("Tahoma", Font.BOLD, 14));
        rollno.setBounds(50,70,150,20);
        getContentPane().add(rollno);

        
        choicerollno = new Choice();
        choicerollno.setBounds(200,70,150,20);
        getContentPane().add(choicerollno);
        
        try {
        	Conn c = new Conn();
        	ResultSet resultSet = c.statement.executeQuery("select * from student");
        	while(resultSet.next()) {
        		choicerollno.add(resultSet.getString("stuID"));
        
        	}
        }catch (Exception e) {
        	e.printStackTrace();
        }
        JLabel sem = new JLabel("Học kỳ");
        sem.setFont(new Font("Tahoma", Font.BOLD, 14));
        sem.setBounds(50,110,150,20);
        getContentPane().add(sem);
        
        String semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        comboBox = new JComboBox(semester);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox.setBounds(200,110,150,20);
        comboBox.setBackground(Color.WHITE);
        getContentPane().add(comboBox);
        comboBox.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		String stuId = (String) choicerollno.getSelectedItem(); 
        		String semester = (String) comboBox.getSelectedItem(); 
        		getSubjects(stuId, semester);
        		getMarks(stuId, semester);
        		} 
        	});
        
        JLabel entersub = new JLabel("Nhập tên môn học");
        entersub.setFont(new Font("Tahoma", Font.BOLD, 14));
        entersub.setBounds(85,150,135,40);
        getContentPane().add(entersub);
        
        JLabel entermarks = new JLabel("Nhập số điểm");
        entermarks.setFont(new Font("Tahoma", Font.BOLD, 14));
        entermarks.setBounds(304,150,95,40);
        getContentPane().add(entermarks);
        
        sub1 = new JTextField();
        sub1.setFont(new Font("Dialog", Font.PLAIN, 14));
        sub1.setBounds(50,200,200,20);
        getContentPane().add(sub1);
        
        sub2 = new JTextField();
        sub2.setFont(new Font("Dialog", Font.PLAIN, 14));
        sub2.setBounds(50,230,200,20);
        getContentPane().add(sub2);
        
        sub3 = new JTextField();
        sub3.setFont(new Font("Dialog", Font.PLAIN, 14));
        sub3.setBounds(50,260,200,20);
        getContentPane().add(sub3);
        
        sub4 = new JTextField();
        sub4.setFont(new Font("Dialog", Font.PLAIN, 14));
        sub4.setBounds(50,290,200,20);
        getContentPane().add(sub4);
        
        sub5 = new JTextField();
        sub5.setFont(new Font("Dialog", Font.PLAIN, 14));
        sub5.setBounds(50,320,200,20);
        getContentPane().add(sub5);
        
        mrk1 = new JTextField();
        mrk1.setFont(new Font("Dialog", Font.PLAIN, 14));
        mrk1.setBounds(250,200,200,20);
        getContentPane().add(mrk1);
        
        mrk2 = new JTextField();
        mrk2.setFont(new Font("Dialog", Font.PLAIN, 14));
        mrk2.setBounds(250,230,200,20);
        getContentPane().add(mrk2);
        
        mrk3 = new JTextField();
        mrk3.setFont(new Font("Dialog", Font.PLAIN, 14));
        mrk3.setBounds(250,260,200,20);
        getContentPane().add(mrk3);
        
        mrk4 = new JTextField();
        mrk4.setFont(new Font("Dialog", Font.PLAIN, 14));
        mrk4.setBounds(250,290,200,20);
        getContentPane().add(mrk4);
        
        mrk5 = new JTextField();
        mrk5.setFont(new Font("Dialog", Font.PLAIN, 14));
        mrk5.setBounds(250,320,200,20);
        getContentPane().add(mrk5);
        
        submit = new JButton("Nộp");
        submit.setFont(new Font("Dialog", Font.BOLD, 14));
        submit.setBounds(50,360,150,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        getContentPane().add(submit);
        
        
        cancel = new JButton("Huỷ");
        cancel.setFont(new Font("Dialog", Font.BOLD, 14));
        cancel.setBounds(400,360,150,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        getContentPane().add(cancel);
        
        update = new JButton("Cập nhật");
        update.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Dialog", Font.BOLD, 14));
        update.setBackground(Color.BLACK);
        update.setBounds(221, 360, 150, 25);
        update.addActionListener(this);
        getContentPane().add(update);
        
        // Thiết lập kích thước và vị trí cửa sổ
        setSize(1000, 500);  // Tăng chiều cao cửa sổ
        setLocation(300, 150);
        setVisible(true);
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
	                // Hiển thị các giá trị lên các ô nhập liệu
	                sub1.setText(subjects[0]);
	                sub2.setText(subjects[1]);
	                sub3.setText(subjects[2]);
	                sub4.setText(subjects[3]);
	                sub5.setText(subjects[4]);
	            } else {
	                // Nếu không có kết quả nào được tìm thấy, đặt các ô nhập liệu về trống
	            	JOptionPane.showMessageDialog(null, "Học kỳ này sinh viên chưa đăng ký môn học vui lòng không nhập");
	                sub1.setText("");
	                sub2.setText("");
	                sub3.setText("");
	                sub4.setText("");
	                sub5.setText("");
	            }
	        }
	    } catch (SQLException e) { 
	        e.printStackTrace(); 
	    }
	    return subjects;
	}

	
	private void getMarks(String stuID, String semester) {
		String sql = "SELECT mrk1, mrk2, mrk3, mrk4, mrk5 FROM marks WHERE stuID = ? AND semester = ?";
		try (Connection conn = Conn.getConnection(); 
	    	PreparedStatement stmt = conn.prepareStatement(sql)) { 
	    		
	    	stmt.setString(1, stuID); 
	    	stmt.setString(2, semester);
	    		
	    	try (ResultSet rs = stmt.executeQuery()) { 
	    		if (rs.next()) { 
	                mrk1.setText(rs.getString("mrk1")); 
	                mrk2.setText(rs.getString("mrk2")); 
	                mrk3.setText(rs.getString("mrk3")); 
	                mrk4.setText(rs.getString("mrk4")); 
	                mrk5.setText(rs.getString("mrk5"));
	            } else {
	                // Nếu không có kết quả nào được tìm thấy, đặt các ô nhập điểm về trống
	                mrk1.setText("");
	                mrk2.setText("");
	                mrk3.setText("");
	                mrk4.setText("");
	                mrk5.setText("");
	            }
	    	} 
	    } catch (SQLException e) { 
	    	e.printStackTrace(); 
	    }
	}
	
	private boolean isValidMarks(String marks) {
        try {
            double mark = Double.parseDouble(marks);
            return mark >= 0 && mark <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	public boolean isEnterPoint(String stuID, String semester) {
		String querry = "SELECT COUNT(*) FROM marks where stuID = ? AND semester = ?";
		try (Connection conn = Conn.getConnection(); 
	    		PreparedStatement stmt = conn.prepareStatement(querry)) { 
	    		
	    		stmt.setString(1, stuID); 
	    		stmt.setString(2, semester);
	    		
	    		try (ResultSet rs = stmt.executeQuery()) { 
	    			if (rs.next()) { 
	    				int count = rs.getInt(1); 
	    				return count > 0;
	    			} 
	    		} 
	    } catch (SQLException e) { 
	    	e.printStackTrace(); 
	    } return false;
	}
    

    public void actionPerformed(ActionEvent e) {
        // Xử lý hành động
    	if (e.getSource()== submit) {
    		
    		// Kiểm tra tính hợp lệ của điểm
            if (!isValidMarks(mrk1.getText()) || !isValidMarks(mrk2.getText()) || 
                !isValidMarks(mrk3.getText()) || !isValidMarks(mrk4.getText()) || 
                !isValidMarks(mrk5.getText())) {
                JOptionPane.showMessageDialog(null, "Điểm phải là số từ 0 đến 10", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
    		
			String Q2 = "insert into marks values('"+choicerollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+mrk1.getText()+"','"+mrk2.getText()+"','"+mrk3.getText()+"','"+mrk4.getText()+"','"+mrk5.getText()+"')";
			
    		try {
    			if(isEnterPoint(choicerollno.getSelectedItem(),(String)comboBox.getSelectedItem())) {
    				JOptionPane.showMessageDialog(null, "Điểm đã được nhập ở kỳ này rồi");
    			}
    			else {
    				Conn c = new Conn();
    				c.statement.executeUpdate(Q2);
    				JOptionPane.showMessageDialog(null, "Nhập điểm thành công");
    				setVisible(false);    				
    			}
    			
            } catch (Exception E) {
                E.printStackTrace();
            }
    	}
    	else if(e.getSource()== update)	{
    		
    		if (!isValidMarks(mrk1.getText()) || !isValidMarks(mrk2.getText()) || 
                    !isValidMarks(mrk3.getText()) || !isValidMarks(mrk4.getText()) || 
                    !isValidMarks(mrk5.getText())) {
                    JOptionPane.showMessageDialog(null, "Điểm phải là số từ 0 đến 10", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
            }
    		
    		String sql = "UPDATE marks SET mrk1 = '"+mrk1.getText()+"', mrk2 = '"+mrk2.getText()+"', mrk3 = '"+mrk3.getText()+"', mrk4 = '"+mrk4.getText()+"', mrk5 = '"+mrk5.getText()+"' WHERE stuID = '"+choicerollno.getSelectedItem()+"' AND semester = '"+comboBox.getSelectedItem()+"'";
    		try {
    			if(isEnterPoint(choicerollno.getSelectedItem(),(String)comboBox.getSelectedItem())) {
    				Conn c = new Conn();
    				c.statement.executeUpdate(sql);
    				JOptionPane.showMessageDialog(null, "Cập nhật điểm thành công");
    				setVisible(true);   
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Điểm chưa được nhập không thể update");
    			}
    			
                
            } catch (Exception E) {
                E.printStackTrace();
            }
    	}
         else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
}
