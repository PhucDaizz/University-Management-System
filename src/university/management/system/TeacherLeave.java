package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice choiceRollNo, choTime;
    JDateChooser selDate;
    JButton submit, cancel;
    JButton btnCpNht;

    TeacherLeave() {
        getContentPane().setBackground(new Color(210, 232, 252));

        JLabel heading = new JLabel("Xin nghỉ phép (Giáo viên)");
        heading.setBounds(60, 59, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(heading);

        JLabel RollNoSE = new JLabel("Tìm kiếm theo ID giáo viên");
        RollNoSE.setBounds(60, 100, 200, 20);
        RollNoSE.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(RollNoSE);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(60, 130, 200, 20);
        getContentPane().add(choiceRollNo);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                choiceRollNo.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Ngày");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lbldate);

        selDate = new JDateChooser();
        selDate.setBounds(60, 210, 200, 25);
        getContentPane().add(selDate);

        JLabel time = new JLabel("Khoảng thời gian");
        time.setBounds(60, 260, 200, 20);
        time.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(time);

        choTime = new Choice();
        choTime.setBounds(60, 290, 200, 20);
        choTime.add("Cả ngày");
        choTime.add("Nửa ngày");
        getContentPane().add(choTime);

        submit = new JButton("Nộp");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(new Color(51, 255, 102));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        getContentPane().add(submit);

        cancel = new JButton("Hủy bỏ");
        cancel.setBounds(311, 350, 100, 25);
        cancel.setBackground(new Color(255, 51, 51));
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        getContentPane().add(cancel);

        setSize(500, 550);
        setLocation(550, 100);
        getContentPane().setLayout(null);
        
        btnCpNht = new JButton("Câp nhật");
        btnCpNht.setForeground(Color.WHITE);
        btnCpNht.setBackground(new Color(51, 153, 255));
        btnCpNht.setBounds(187, 351, 100, 25);
        btnCpNht.addActionListener(this);
        getContentPane().add(btnCpNht);
        
        setVisible(true);
    }
    
    private boolean isOnLeave(String id, String ondate) {
		String sql = "SELECT * FROM teacherleave WHERE empId = ? AND date = ?";
		try (Connection conn = Conn.getConnection(); 
	    	PreparedStatement stmt = conn.prepareStatement(sql)) { 
			
	    	stmt.setString(1, id); 
	   		stmt.setString(2, ondate);
	   		try (ResultSet rs = stmt.executeQuery()) { 
	   			if (rs.next()) { 
	   				// Có ít nhất một bản ghi tồn tại 
	   				return true; 
	   			}
	   		}
	   	} catch (SQLException e) { 
			e.printStackTrace(); 
		}
		return false;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String rollno = choiceRollNo.getSelectedItem();
            String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time = choTime.getSelectedItem();

            if (isOnLeave(rollno, date)) { 
				JOptionPane.showMessageDialog(null, "Bạn đã xin nghỉ phép ngày này rồi!"); 
			} else { 
				String Q = "insert into teacherleave values('" + rollno + "','" + date + "', '" + time + "')"; 
				try { 
					Conn c = new Conn(); 
					c.statement.executeUpdate(Q); 
					JOptionPane.showMessageDialog(null, "Xác nhận nghỉ phép"); 
					setVisible(false); 
				} catch (Exception E) { 
					E.printStackTrace(); 
				}
			}
        } 
        else if(e.getSource() == btnCpNht) {
			String rollno = choiceRollNo.getSelectedItem();
			String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
			String time = choTime.getSelectedItem();
			if(isOnLeave(rollno, date)) {
				String sql = "UPDATE teacherleave SET time = '"+ time +"' WHERE empId = '"+ rollno +"' AND date = '"+ date +"' ";
				JOptionPane.showMessageDialog(null, "Cập nhật thành công"); 
				try { 
					Conn c = new Conn(); 
					c.statement.executeUpdate(sql);
				} catch (Exception E) { 
					E.printStackTrace(); 
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Bạn chưa xin nghỉ ngày này nên chưa thể cập nhật"); 
			}
		}
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
