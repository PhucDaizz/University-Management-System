package university.management.system;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class AddCourse extends JFrame implements ActionListener{
	private JTextField subject;
	private JTextField semester1;
	private JTextField semester2;
	private JTextField semester3;
	private JTextField semester4;
	private JTextField semester5;
	private JTextField semester6;
	private JTextField semester7;
	private JTextField semester8;
	JButton btnAdd, btnCancel;
	
	AddCourse(){
		getContentPane().setBackground(new Color(152, 251, 152));
		
		setSize(922, 587);
        setLocation(350, 50);
        getContentPane().setLayout(null);
        
        JLabel lblThmMnHc = new JLabel("Thêm môn học");
        lblThmMnHc.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblThmMnHc.setBounds(367, 31, 224, 66);
        getContentPane().add(lblThmMnHc);
        
        JLabel lblSubject = new JLabel("Môn học");
        lblSubject.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSubject.setBounds(103, 104, 105, 31);
        getContentPane().add(lblSubject);
        
        subject = new JTextField();
        subject.setColumns(10);
        subject.setBounds(218, 108, 170, 31);
        getContentPane().add(subject);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(84, 150, 753, 304);
        getContentPane().add(panel);
        
        JLabel lblSemester1 = new JLabel("Học kỳ 1");
        lblSemester1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSemester1.setBounds(44, 24, 81, 34);
        panel.add(lblSemester1);
        
        JLabel lblSemester2 = new JLabel("Học kỳ 2");
        lblSemester2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSemester2.setBounds(44, 92, 81, 34);
        panel.add(lblSemester2);
        
        JLabel lblSemester3 = new JLabel("Học kỳ 3");
        lblSemester3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSemester3.setBounds(44, 159, 81, 34);
        panel.add(lblSemester3);
        
        JLabel lblSemester4 = new JLabel("Học kỳ 4");
        lblSemester4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSemester4.setBounds(44, 231, 81, 34);
        panel.add(lblSemester4);
        
        semester1 = new JTextField();
        semester1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        semester1.setColumns(10);
        semester1.setBounds(130, 24, 180, 30);
        panel.add(semester1);
        
        semester2 = new JTextField();
        semester2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        semester2.setColumns(10);
        semester2.setBounds(130, 92, 180, 30);
        panel.add(semester2);
        
        semester3 = new JTextField();
        semester3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        semester3.setColumns(10);
        semester3.setBounds(130, 163, 180, 30);
        panel.add(semester3);
        
        semester4 = new JTextField();
        semester4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        semester4.setColumns(10);
        semester4.setBounds(130, 231, 180, 30);
        panel.add(semester4);
        
        JLabel lblSemester5 = new JLabel("Học kỳ 5");
        lblSemester5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSemester5.setBounds(427, 24, 81, 34);
        panel.add(lblSemester5);
        
        semester5 = new JTextField();
        semester5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        semester5.setColumns(10);
        semester5.setBounds(513, 24, 180, 30);
        panel.add(semester5);
        
        JLabel lblSemester6 = new JLabel("Học kỳ 6");
        lblSemester6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSemester6.setBounds(427, 92, 81, 34);
        panel.add(lblSemester6);
        
        semester6 = new JTextField();
        semester6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        semester6.setColumns(10);
        semester6.setBounds(513, 92, 180, 30);
        panel.add(semester6);
        
        JLabel lblSemester7 = new JLabel("Học kỳ 7");
        lblSemester7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSemester7.setBounds(427, 159, 81, 34);
        panel.add(lblSemester7);
        
        semester7 = new JTextField();
        semester7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        semester7.setColumns(10);
        semester7.setBounds(513, 163, 180, 30);
        panel.add(semester7);
        
        JLabel lblSemester8 = new JLabel("Học kỳ 8");
        lblSemester8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblSemester8.setBounds(427, 231, 81, 34);
        panel.add(lblSemester8);
        
        semester8 = new JTextField();
        semester8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        semester8.setColumns(10);
        semester8.setBounds(513, 231, 180, 30);
        panel.add(semester8);
        
        btnAdd = new JButton("Thêm ");
        btnAdd.setBackground(Color.GREEN);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdd.setBounds(331, 479, 107, 31);
        btnAdd.addActionListener(this);
        getContentPane().add(btnAdd);
        
        btnCancel = new JButton("Huỷ");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancel.setBackground(Color.RED);
        btnCancel.setBounds(484, 479, 107, 31);
        btnCancel.addActionListener(this);
        getContentPane().add(btnCancel);
		setVisible(true);
	}
	
	private boolean isExisting(String subject) {
	    String query = "SELECT COUNT(*) FROM fee WHERE LOWER(course) = LOWER(?)";
	    try (Connection conn = Conn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        
	        stmt.setString(1, subject);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next() && rs.getInt(1) > 0) {
	                return true; // Môn học đã tồn tại
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false; // Môn học không tồn tại
	}
	
	private boolean isNumeric(String str) { 
		if (str == null || str.trim().isEmpty()) { 
			return false; 
		} 
		try { 
			Long.parseLong(str); 
			return true; 
		} catch (NumberFormatException e) { 
			return false; 
		}
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			String semester1Value = semester1.getText();
	        String semester2Value = semester2.getText();
	        String semester3Value = semester3.getText();
	        String semester4Value = semester4.getText();
	        String semester5Value = semester5.getText();
	        String semester6Value = semester6.getText();
	        String semester7Value = semester7.getText();
	        String semester8Value = semester8.getText();
	        String subjectValue = subject.getText();
	        
	        if (!isNumeric(semester1Value) || !isNumeric(semester2Value) || !isNumeric(semester3Value) || 
	        	!isNumeric(semester4Value) || !isNumeric(semester5Value) || !isNumeric(semester6Value) || 
	        	!isNumeric(semester7Value) || !isNumeric(semester8Value)) { 
	        		JOptionPane.showMessageDialog(null, "Ở các học kỳ bạn đang nhập nhập định dạng không đúng định dạng số hoặc bị bỏ trống!"); 
	        		return;
	        }
	        
	        if (isExisting(subjectValue)) { 
	        	JOptionPane.showMessageDialog(null, "Môn học này đã tồn tại!"); 
	        } else { 
	        	String query = "INSERT INTO fee VALUES ('" + subjectValue + "', '" + semester1Value + "', '" + semester2Value + "', '" + semester3Value + "', '" + semester4Value + "', '" + semester5Value + "', '" + semester6Value + "', '" + semester7Value + "','" + semester8Value + "')"; 
	        	try { 
	        		Conn c = new Conn(); 
	        		c.statement.executeUpdate(query); 
	        		JOptionPane.showMessageDialog(null, "Thêm thành công"); 
	        	} catch (Exception ex) { 
	        		ex.printStackTrace(); 
	        	}
	        }
		}
		else if(e.getSource() == btnCancel) {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddCourse();
	}
}
