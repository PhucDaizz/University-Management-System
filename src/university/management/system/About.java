package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        // Set up image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(279, 0, 397, 138); // Set position and size for the image
        getContentPane().add(img);

        // Set up heading
        JLabel heading = new JLabel("<html>Đại Học GTVT<br>Thành Phố HCM</html>");
        heading.setBounds(31, 11, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        getContentPane().add(heading);

        // Set up name label
        JLabel name = new JLabel("Đồ án quản lý đại học");
        name.setForeground(new Color(128, 255, 255));
        name.setBounds(31, 155, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        getContentPane().add(name);

        // Set up contact information
        JLabel contact = new JLabel("Nguyễn Phúc Đại ");
        contact.setBounds(31, 206, 550, 40);
        contact.setFont(new Font("Tahoma", Font.BOLD, 22));
        getContentPane().add(contact);

        // Set frame properties
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(new Color(252, 228, 210)); // Background color
        getContentPane().setLayout(null);
        
        JLabel contact1 = new JLabel("Nguyễn Cao Thành Đạt ");
        contact1.setFont(new Font("Tahoma", Font.BOLD, 22));
        contact1.setBounds(31, 257, 550, 40);
        getContentPane().add(contact1);
        
        JLabel contact2 = new JLabel("Trần Minh Hoàng");
        contact2.setFont(new Font("Tahoma", Font.BOLD, 22));
        contact2.setBounds(31, 308, 550, 40);
        getContentPane().add(contact2);
        
        JLabel contact3 = new JLabel("Trần Văn Tài");
        contact3.setFont(new Font("Tahoma", Font.BOLD, 22));
        contact3.setBounds(31, 359, 550, 40);
        getContentPane().add(contact3);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
