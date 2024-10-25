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
        img.setBounds(350, 0, 300, 200); // Set position and size for the image
        add(img);

        // Set up heading
        JLabel heading = new JLabel("<html>Đại Học GTVT<br>Technical University</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        // Set up name label
        JLabel name = new JLabel("Techcoder A.V");
        name.setBounds(60, 260, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);

        // Set up contact information
        JLabel contact = new JLabel("2251120351@gmail.com");
        contact.setBounds(70, 340, 550, 40);
        contact.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(contact);

        // Set frame properties
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(new Color(252, 228, 210)); // Background color
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
