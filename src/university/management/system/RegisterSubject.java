package university.management.system;

import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;


public class RegisterSubject extends JFrame{

	RegisterSubject(){
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lbRegisterSub = new JLabel("Đăng ký môn học");
		lbRegisterSub.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbRegisterSub.setBounds(413, 11, 238, 39);
		getContentPane().add(lbRegisterSub);
		
		JComboBox Semester = new JComboBox();
		Semester.setBackground(Color.WHITE);
		Semester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Semester.setModel(new DefaultComboBoxModel(new String[] {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"}));
		Semester.setBounds(669, 78, 273, 31);
		getContentPane().add(Semester);
		
		JLabel lbChoosenSemester = new JLabel("Chọn học kỳ bạn muốn đăng ký ");
		lbChoosenSemester.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbChoosenSemester.setBounds(256, 78, 296, 31);
		getContentPane().add(lbChoosenSemester);
		
		String[] idList = Student.getAllId();
		JComboBox StudentID = new JComboBox();
		StudentID.setBackground(Color.WHITE);
		StudentID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StudentID.setModel(new DefaultComboBoxModel(idList));
		StudentID.setBounds(669, 142, 273, 31);
		getContentPane().add(StudentID);
		
		JLabel lbStudentID = new JLabel("MSSV");
		lbStudentID.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbStudentID.setBounds(256, 142, 264, 31);
		getContentPane().add(lbStudentID);
		
		
		// lấy toàn bộ môn học 
		String[] subs = Fee.getAllSub();
		
		JButton btnNewButton = new JButton("Xác nhận đăng ký");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(111, 554, 244, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnHu = new JButton("Huỷ");
		btnHu.setBackground(new Color(255, 99, 71));
		btnHu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHu.setBounds(766, 554, 244, 39);
		getContentPane().add(btnHu);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setBackground(new Color(176, 224, 230));
		btnCpNht.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCpNht.setBounds(442, 554, 244, 39);
		getContentPane().add(btnCpNht);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(0, 0, 1114, 67);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder());
		panel_1.setBounds(179, 184, 763, 346);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
				JComboBox sub1 = new JComboBox();
				sub1.setBounds(407, 22, 273, 31);
				panel_1.add(sub1);
				sub1.setBackground(new Color(255, 255, 255));
				sub1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				sub1.setModel(new DefaultComboBoxModel(subs));
				
				JComboBox sub2 = new JComboBox();
				sub2.setBackground(Color.WHITE);
				sub2.setBounds(407, 79, 273, 31);
				panel_1.add(sub2);
				sub2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				sub2.setModel(new DefaultComboBoxModel(subs));
				
				JComboBox sub3 = new JComboBox();
				sub3.setBackground(Color.WHITE);
				sub3.setBounds(407, 145, 273, 31);
				panel_1.add(sub3);
				sub3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				sub3.setModel(new DefaultComboBoxModel(subs));
				
				JComboBox sub4 = new JComboBox();
				sub4.setBackground(Color.WHITE);
				sub4.setBounds(407, 209, 273, 31);
				panel_1.add(sub4);
				sub4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				sub4.setModel(new DefaultComboBoxModel(subs));
				
				JComboBox sub5 = new JComboBox();
				sub5.setBackground(Color.WHITE);
				sub5.setBounds(407, 271, 273, 31);
				panel_1.add(sub5);
				sub5.setFont(new Font("Tahoma", Font.PLAIN, 20));
				sub5.setModel(new DefaultComboBoxModel(subs));
				
				JLabel lbSub5 = new JLabel("Môn học 5:");
				lbSub5.setBounds(129, 274, 129, 25);
				panel_1.add(lbSub5);
				lbSub5.setFont(new Font("Tahoma", Font.BOLD, 20));
				
				JLabel lbSub4 = new JLabel("Môn học 4:");
				lbSub4.setBounds(129, 215, 129, 25);
				panel_1.add(lbSub4);
				lbSub4.setFont(new Font("Tahoma", Font.BOLD, 20));
				
				JLabel lbSub3 = new JLabel("Môn học 3:");
				lbSub3.setBounds(129, 148, 129, 25);
				panel_1.add(lbSub3);
				lbSub3.setFont(new Font("Tahoma", Font.BOLD, 20));
				
				JLabel lbSub2 = new JLabel("Môn học 2:");
				lbSub2.setBounds(129, 85, 129, 25);
				panel_1.add(lbSub2);
				lbSub2.setFont(new Font("Tahoma", Font.BOLD, 20));
				
				JLabel lbSub1 = new JLabel("Môn học 1:");
				lbSub1.setBounds(129, 28, 129, 25);
				panel_1.add(lbSub1);
				lbSub1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		setSize(1128, 688);  
        setLocation(300, 150);
		setVisible(true);
		
		
//		Xử lý sự kiện
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stuId = (String) StudentID.getSelectedItem();
				String semester = (String) Semester.getSelectedItem();
				String subA = (String) sub1.getSelectedItem();
				String subB = (String) sub2.getSelectedItem();
				String subC = (String) sub3.getSelectedItem();
				String subD = (String) sub4.getSelectedItem();
				String subE = (String) sub5.getSelectedItem();
				
				if(!Student.checkStudentInSemester(stuId, semester)) {
					Student.addRegister(stuId, semester, subA, subB, subC, subD, subE);			
				}
				else {
					JOptionPane.showMessageDialog(null, "BẠn đã đăng ký này rồi, bạn chỉ có thể chỉnh sửa lại môn khi chưa bắt đầu học kỳ!");
				}
			}
		});
		
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stuId = (String) StudentID.getSelectedItem();
				String semester = (String) Semester.getSelectedItem();
				String subA = (String) sub1.getSelectedItem();
				String subB = (String) sub2.getSelectedItem();
				String subC = (String) sub3.getSelectedItem();
				String subD = (String) sub4.getSelectedItem();
				String subE = (String) sub5.getSelectedItem();
				if(Student.checkStudentInSemester(stuId, semester)) {
					Student.updateRegister(stuId, semester, subA, subB, subC, subD, subE);  // chỉnh lại					
				}
				else {
					JOptionPane.showMessageDialog(null, "BẠn đã đăng ký này rồi, bạn chỉ có thể chỉnh sửa lại môn khi chưa bắt đầu học kỳ!");
				}
				
			}
		});
	}
	
	
	public class Student {
		public static String[] getAllId() {
	        ArrayList<String> idList = new ArrayList<>();
	        try (Connection conn = Conn.getConnection()) { // Sử dụng kết nối từ Conn
	            String sql = "SELECT stuID FROM student";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                idList.add(rs.getString("stuID"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        // Chuyển danh sách thành mảng chuỗi
	        return idList.toArray(new String[0]);
	    }
		
		
		public static void addRegister(String stuId, String semester, String subA, String subB, String subC, String subD, String subE) {
			try (Connection conn = Conn.getConnection()) {
	            String sql = "INSERT INTO subject (stuID, semester, subj1, subj2, subj3, subj4, sbj5) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, stuId);
	            stmt.setString(2, semester);
	            stmt.setString(3, subA);
	            stmt.setString(4, subB);
	            stmt.setString(5, subC);
	            stmt.setString(6, subD);
	            stmt.setString(7, subE);
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Đăng ký thành công");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		public static boolean checkStudentInSemester(String stuID, String semester) {
			try (Connection conn = Conn.getConnection()) {
	            String sql = "SELECT COUNT(*) FROM subject WHERE stuID = ? AND semester = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
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
	        }
			return false;
		}
		
		public static void updateRegister(String stuID, String semester, String subA, String subB, String subC, String subD, String subE) { 
			String sql = "UPDATE subject SET subj1 = ?, subj2 = ?, subj3 = ?, subj4 = ?, sbj5 = ? WHERE stuID = ? AND semester = ?"; 
			try (
					Connection conn = Conn.getConnection(); 
					PreparedStatement stmt = conn.prepareStatement(sql)) { 
					stmt.setString(1, subA); 
					stmt.setString(2, subB); 
					stmt.setString(3, subC); 
					stmt.setString(4, subD); 
					stmt.setString(5, subE); 
					stmt.setString(6, stuID); 
					stmt.setString(7, semester); 
					stmt.executeUpdate(); 
					JOptionPane.showMessageDialog(null, "Cập nhật môn học thành công!");
					} 
			catch (SQLException e) { 
				e.printStackTrace(); 
			} 
		}
		
		
		
		
	}
	
	public class Fee{
		public static String[] getAllSub() {
			ArrayList<String> subList = new ArrayList<>();
			 try (Connection conn = Conn.getConnection()) { // Sử dụng kết nối từ Conn
		            String sql = "SELECT course FROM `fee`";
		            PreparedStatement stmt = conn.prepareStatement(sql);
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		            	subList.add(rs.getString("course"));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
			return subList.toArray(new String[0]);
		}
	}
	
	public static void main(String[] args) {
		new RegisterSubject();
		
	}
}
