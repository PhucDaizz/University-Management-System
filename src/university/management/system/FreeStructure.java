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
        getContentPane().setBackground(new Color(153, 255, 204));

        JLabel heading = new JLabel("Chi phí môn học");
        heading.setBounds(340, 22, 258, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        getContentPane().add(heading);

        JTable table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));

        // Thêm bảng vào JScrollPane để có thể cuộn
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(52, 73, 886, 550); // Thiết lập vị trí và kích thước cho bảng
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