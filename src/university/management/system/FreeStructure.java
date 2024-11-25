package university.management.system;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.DbUtils; // Import DbUtils để xử lý ResultSet thành TableModel

public class FreeStructure extends JFrame implements ActionListener {
    // Constructor
	JTable table;
	JButton btnUpdate, btnDelete;
	String selectedCourse = null;
	JButton btnAdd;
	JButton btnCancel;
	
    FreeStructure() {
        getContentPane().setBackground(new Color(153, 255, 204));

        JLabel heading = new JLabel("Chi phí môn học");
        heading.setBounds(340, 22, 258, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        getContentPane().add(heading);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));

        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        selectedCourse = table.getValueAt(selectedRow, 0).toString(); // Giả sử cột 0 là cột course
                    }
                }
            }
        });
        
        // Thêm bảng vào JScrollPane để có thể cuộn
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(52, 73, 886, 537); // Thiết lập vị trí và kích thước cho bảng
        getContentPane().add(sp);

       
        try {
            Conn c = new Conn();    
            ResultSet resultSet = c.statement.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet)); // Sử dụng DbUtils để thiết lập mô hình bảng

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Thiết lập kích thước và vị trí cho JFrame
        setSize(1000, 700);
        setLocation(250, 50);
        getContentPane().setLayout(null);
        
        btnUpdate = new JButton("Cập nhật");
        btnUpdate.setBackground(Color.CYAN);
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnUpdate.setBounds(369, 621, 127, 23);
        btnUpdate.addActionListener(this);
        getContentPane().add(btnUpdate);
        
        btnDelete = new JButton("Xoá");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setBackground(Color.RED);
        btnDelete.setBounds(533, 621, 127, 23);
        btnDelete.addActionListener(this);
        getContentPane().add(btnDelete);
        
        btnAdd = new JButton("Thêm");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdd.setBackground(Color.GREEN);
        btnAdd.setBounds(204, 621, 127, 23);
        btnAdd.addActionListener(this);
        getContentPane().add(btnAdd);
        
        btnCancel = new JButton("Huỷ");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancel.setBackground(new Color(255, 127, 80));
        btnCancel.setBounds(688, 621, 127, 23);
        btnCancel.addActionListener(this);
        getContentPane().add(btnCancel);
        
        setVisible(true);
    }
    
    private void deleteCourse(String course) {
        String query = "DELETE FROM fee WHERE course = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, course);
            
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
            	JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } else {
            	JOptionPane.showMessageDialog(this, "Bạn chưa chọn khoá học để xoá.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnUpdate) {
            if (selectedCourse != null) {
                new EditFeeStructure(selectedCourse);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một khoá học để cập nhật");
            }
        }
    	else if(e.getSource() == btnDelete) {
    		deleteCourse(selectedCourse);
    	}
    	else if(e.getSource() == btnAdd) {
    		new AddCourse();
    	}
    	else if(e.getSource() == btnCancel){
    		setVisible(false);
    	}
    }

    public static void main(String[] args) {
        new FreeStructure();
    }
}