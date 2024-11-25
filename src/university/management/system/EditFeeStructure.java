package university.management.system;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class EditFeeStructure extends JFrame implements ActionListener {
	private JTextField subject;
	private JTextField semester1;
	private JTextField semester2;
	private JTextField semester3;
	private JTextField semester4;
	private JTextField semester5;
	private JTextField semester6;
	private JTextField semester7;
	private JTextField semester8;
	
	JButton btnCancel, btnUpdate;

	EditFeeStructure(String course){
		getContentPane().setBackground(new Color(153, 204, 204));
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Điều chỉnh học phí môn học");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitle.setBounds(259, 11, 418, 66);
		getContentPane().add(lblTitle);
		
		JLabel lblSubject = new JLabel("Môn học");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubject.setBounds(91, 94, 105, 31);
		getContentPane().add(lblSubject);
		
		subject = new JTextField();
		subject.setBounds(201, 92, 170, 31);
		getContentPane().add(subject);
		subject.setColumns(10);
		subject.setText(course);
		subject.setEditable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(87, 148, 753, 304);
		getContentPane().add(panel);
		panel.setLayout(null);
		
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
		semester1.setBounds(130, 24, 180, 30);
		panel.add(semester1);
		semester1.setColumns(10);
		
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
		
		btnUpdate = new JButton("Cập nhật");
		btnUpdate.setForeground(new Color(51, 153, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnUpdate.setBounds(234, 463, 201, 31);
		btnUpdate.addActionListener(this);
		getContentPane().add(btnUpdate);
		
		btnCancel = new JButton("Huỷ");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnCancel.setBounds(486, 463, 201, 31);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);
		
		// Load dữ liệu của khoá học
	    try {
	        Conn c = new Conn();
	        ResultSet rs = c.statement.executeQuery("SELECT * FROM fee WHERE course = '" + course + "'");
	        
	        if(rs.next()) {
	            semester1.setText(rs.getString("semester1"));
	            semester2.setText(rs.getString("semester2")); 
	            semester3.setText(rs.getString("semester3"));
	            semester4.setText(rs.getString("semester4"));
	            semester5.setText(rs.getString("semester5"));
	            semester6.setText(rs.getString("semester6"));
	            semester7.setText(rs.getString("semester7"));
	            semester8.setText(rs.getString("semester8"));
	        }
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu: " + e.getMessage());
	    }
		
		
		setSize(922, 587);
        setLocation(350, 50);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnUpdate) {
	        String semester1Value = semester1.getText();
	        String semester2Value = semester2.getText();
	        String semester3Value = semester3.getText();
	        String semester4Value = semester4.getText();
	        String semester5Value = semester5.getText();
	        String semester6Value = semester6.getText();
	        String semester7Value = semester7.getText();
	        String semester8Value = semester8.getText();
	        String subjectValue = subject.getText();

	        String query = "UPDATE fee SET semester1 = ?, semester2 = ?, semester3 = ?, semester4 = ?, semester5 = ?, semester6 = ?, semester7 = ?, semester8 = ? WHERE course = ?";
	        
	        Conn c = new Conn();
	        try {
	        	PreparedStatement stmt = c.connection.prepareStatement(query);
	        	
	            stmt.setString(1, semester1Value);
	            stmt.setString(2, semester2Value);
	            stmt.setString(3, semester3Value);
	            stmt.setString(4, semester4Value);
	            stmt.setString(5, semester5Value);
	            stmt.setString(6, semester6Value);
	            stmt.setString(7, semester7Value);
	            stmt.setString(8, semester8Value);
	            stmt.setString(9, subjectValue);

	            int rowsUpdated = stmt.executeUpdate();
	            if (rowsUpdated > 0) {
	                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
	            } else {
	                JOptionPane.showMessageDialog(null, "Không có bản ghi nào được cập nhật");
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Lỗi cập nhật: " + ex.getMessage());
	        }
	    } else if (e.getSource() == btnCancel) {
	        setVisible(false);
	    }
	}

	
	 public static void main(String[] args) {
		 new EditFeeStructure("");
	 }
}
