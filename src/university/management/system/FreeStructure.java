package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils; // Import DbUtils để xử lý ResultSet thành TableModel

public class FreeStructure extends JFrame implements ActionListener {
    // Constructor
    FreeStructure() {
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(430, 13, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JTable table = new JTable();

        // Thêm bảng vào JScrollPane để có thể cuộn
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 100, 800, 500); // Thiết lập vị trí và kích thước cho bảng
        add(sp);

       
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
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện ở đây
    }

    public static void main(String[] args) {
        new FreeStructure();
    }
}