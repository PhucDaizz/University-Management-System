package university.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marks extends JFrame implements ActionListener {

    String stuID;
    JButton cancel, showMarks;
    JComboBox<String> choiceSemester; // ComboBox để chọn học kỳ
    JLabel sub1, sub2, sub3, sub4, sub5, lblsemester;
    
    private JTable markTable;
    private JScrollPane scrollPane;

    Marks(String stuID) {
        this.stuID = stuID;
        
        // Tạo bảng với các cột
        String[] columnNames = {"Môn học", "Điểm"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        markTable = new JTable(model);

        // Tùy chỉnh giao diện bảng
        markTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        markTable.setRowHeight(30);
        markTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
        markTable.getTableHeader().setBackground(new Color(32, 136, 203));
        markTable.getTableHeader().setForeground(Color.WHITE);
        
        // Tạo thanh cuộn cho bảng
        scrollPane = new JScrollPane(markTable);
        scrollPane.setBounds(60, 200, 580, 200);
        getContentPane().add(scrollPane);
        
        // Ẩn bảng ban đầu
        scrollPane.setVisible(false);
        
        setSize(500, 600);
        setLocation(500, 100);
        getContentPane().setLayout(null);

        getContentPane().setBackground(new Color(210, 252, 248));
        getContentPane().setLayout(null);

        JLabel heading = new JLabel("Bảng điểm học tập");
        heading.setBounds(60, 31, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 23));
        getContentPane().add(heading);

        JLabel subheading = new JLabel("Kết quả thi");
        subheading.setBounds(60, 67, 171, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        getContentPane().add(subheading);

        JLabel lblstuID = new JLabel("Roll Number " + stuID);
        lblstuID.setBounds(250, 67, 500, 20);
        lblstuID.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblstuID);

        lblsemester = new JLabel();
        lblsemester.setBounds(60, 134, 251, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(lblsemester);

        sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(sub1);

        sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(sub2);

        sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(sub3);

        sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(sub4);

        sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(sub5);

        // ComboBox để chọn học kỳ
        choiceSemester = new JComboBox<>(new String[]{"Học kỳ 1", "Học kỳ 2", "Học kỳ 3", "Học kỳ 4", "Học kỳ 5"}); // Các học kỳ có thể chọn
        choiceSemester.setBounds(60, 98, 171, 22);
        getContentPane().add(choiceSemester);

        // Nút để hiển thị điểm
        showMarks = new JButton("Hiển thị điểm");
        showMarks.setBounds(250, 98, 150, 25);
        showMarks.setBackground(Color.BLACK);
        showMarks.setForeground(Color.WHITE);
        showMarks.addActionListener(this);
        showMarks.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(showMarks);

        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(cancel);

        setVisible(true);
        setSize(700, 600);
        setLocation(300, 100);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancel) {
            setVisible(false); // Đóng cửa sổ khi nhấn nút "Back"
        } else if (ae.getSource() == showMarks) {
            // Lấy học kỳ mà người dùng đã chọn
            String selectedSemester = (String) choiceSemester.getSelectedItem();
            // Hiển thị điểm dựa trên học kỳ được chọn
            showMarksBySemester(selectedSemester);
        }
    }
    
    
    private void showMarksBySemester(String semester) {
    	ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            Conn c = new Conn();
            DefaultTableModel model = (DefaultTableModel) markTable.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ
            
            // Lấy tên môn học
            String query1 = "select * from subject where stuID = '" + stuID + "' and semester = '" + semester + "'";
            rs1 = c.statement.executeQuery(query1);
            
            // Lưu tên môn học
            List<String> subjects = new ArrayList<>();
            if (rs1.next()) {
                subjects.add(rs1.getString("subj1"));
                subjects.add(rs1.getString("subj2"));
                subjects.add(rs1.getString("subj3"));
                subjects.add(rs1.getString("subj4"));
                subjects.add(rs1.getString("sbj5"));
            }
            
            // Lấy điểm số
            String query2 = "select * from marks where stuID = '" + stuID + "' and semester = '" + semester + "'";
            rs2 = c.statement.executeQuery(query2);
            
            if (rs2.next()) {
                String[] marks = {
                    rs2.getString("mrk1"),
                    rs2.getString("mrk2"),
                    rs2.getString("mrk3"),
                    rs2.getString("mrk4"),
                    rs2.getString("mrk5")
                };
                
                // Thêm dữ liệu vào bảng
                for (int i = 0; i < subjects.size(); i++) {
                    model.addRow(new Object[]{subjects.get(i), marks[i]});
                }
                
                lblsemester.setText(semester);
                scrollPane.setVisible(true);
                
                // Tính và hiển thị điểm trung bình
                double average = Arrays.stream(marks)
                    .filter(mark -> mark != null && !mark.isEmpty())  // kiểm tra null/empty
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(0.0);
                
                // Thêm dòng điểm trung bình
                model.addRow(new Object[]{"Điểm trung bình", String.format("%.2f", average)});
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy dữ liệu điểm cho " + semester, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
                scrollPane.setVisible(false);
            }

            // Căn chỉnh cột và tự động điều chỉnh độ rộng cột (giữ nguyên như cũ)

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Lỗi khi tải dữ liệu: " + e.getMessage(), 
                "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng ResultSet để tránh rò rỉ tài nguyên
            try {
                if (rs1 != null) rs1.close();
                if (rs2 != null) rs2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    private void showMarksBySemester(String semester) {
//        try {
//            Conn c = new Conn();
//
//            // Xóa các giá trị cũ
//            sub1.setText("");
//            sub2.setText("");
//            sub3.setText("");
//            sub4.setText("");
//            sub5.setText("");
//            lblsemester.setText("");
//
//            // Truy vấn điểm theo học kỳ đã chọn
//            ResultSet rs1 = c.statement.executeQuery("select * from subject where stuID = '" + stuID + "' and semester = '" + semester + "'");
//            while (rs1.next()) {
//                sub1.setText(rs1.getString("subj1"));
//                sub2.setText(rs1.getString("subj2"));
//                sub3.setText(rs1.getString("subj3"));
//                sub4.setText(rs1.getString("subj4"));
//                sub5.setText(rs1.getString("sbj5"));
//            }
//
//            ResultSet rs2 = c.statement.executeQuery("select * from marks where stuID = '" + stuID + "' and semester = '" + semester + "'");
//            while (rs2.next()) {
//                sub1.setText(sub1.getText() + "------------" + rs2.getString("mrk1"));
//                sub2.setText(sub2.getText() + "------------" + rs2.getString("mrk2"));
//                sub3.setText(sub3.getText() + "------------" + rs2.getString("mrk3"));
//                sub4.setText(sub4.getText() + "------------" + rs2.getString("mrk4"));
//                sub5.setText(sub5.getText() + "------------" + rs2.getString("mrk5"));
//                lblsemester.setText("Semester " + rs2.getString("semester"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        new Marks(""); // Thay giá trị này bằng ID sinh viên cụ thể
    }
}
