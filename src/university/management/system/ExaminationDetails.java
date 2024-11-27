package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener {
    
    JTextField search;
    JButton result, back;
    JTable table;

    ExaminationDetails() {
        
        getContentPane().setBackground(new Color(241, 252, 218));
        
        JLabel heading = new JLabel("Xem kết quả");
        heading.setBounds(390, 11, 170, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        getContentPane().add(heading);
        
        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Dialog", Font.PLAIN, 16)); // Sửa lại đây
        getContentPane().add(search);
        
        result = new JButton("Tìm");
        result.setFont(new Font("Dialog", Font.BOLD, 16));
        result.setBounds(300, 90, 120, 30);
        result.setBackground(Color.black);
        result.setForeground(Color.white);
        result.addActionListener(this);
        getContentPane().add(result);
        
        back = new JButton("Thoát");
        back.setFont(new Font("Dialog", Font.BOLD, 16));
        back.setBounds(440, 90, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        getContentPane().add(back);
        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 130, 1000, 310);
        getContentPane().add(scrollPane);
        
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        setSize(1000, 475);
        setLocation(300, 100);
        getContentPane().setLayout(null);
        setVisible(true);
    }
    
    private boolean isExisting(String stuId) {
    	String query = "SELECT COUNT(*) FROM student where stuID = ?";
    	try (Connection conn = Conn.getConnection();
   	         PreparedStatement stmt = conn.prepareStatement(query)) {
   	        
   	        stmt.setString(1, stuId);
   	        try (ResultSet rs = stmt.executeQuery()) {
   	            if (rs.next() && rs.getInt(1) > 0) {
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
        // Xử lý sự kiện cho nút Result và Back ở đây
        if (e.getSource() == result) {
        	if(isExisting(search.getText())) {
        		setVisible(false);
        		new Marks(search.getText());        		
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại. Vui lòng kiểm tra lại!");
        	}
        } else 
            // Thực hiện hành động khi nhấn nút Back
        	setVisible(false);
        }

    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
