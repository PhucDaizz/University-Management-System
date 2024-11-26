package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, back, register;
    Login() {
        
        register = new JButton("Đăng ký"); 
        register.setFont(new Font("Tahoma", Font.BOLD, 15)); 
        register.setBounds(107, 200, 121, 37); 
        register.addActionListener(this); 
        getContentPane().add(register);

        JLabel labelName = new JLabel("Username : ");
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelName.setBounds(40, 49,100,20);
        getContentPane().add(labelName);

        textFieldName = new JTextField();
        textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textFieldName.setBounds(150,49,150,20);
        getContentPane().add(textFieldName);

        JLabel labelPassword = new JLabel("Password : ");
        labelPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelPassword.setBounds(40, 99,100,20);
        getContentPane().add(labelPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField.setBounds(150,99,150,20);
        getContentPane().add(passwordField);

        login = new JButton("Đăng nhập");
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        login.setBounds(40,145,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        getContentPane().add(login);

        back = new JButton("Trở về");
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBounds(201,145,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        getContentPane().add(back);
       

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/user.png"));
        Image i2 =  i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,20,200,200);
        getContentPane().add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.jpg"));
        Image i22 =  i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,-27,600,300);
        getContentPane().add(image);

        setSize(600, 300);
        setLocation(500, 250);
        getContentPane().setLayout(null);
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String userName  = textFieldName.getText();
            String password = new String(passwordField.getPassword());

            String query = "select * from login where username = '"+userName+"' and password = '"+password+"'";
            try{
                Conn c= new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new main_class();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username hoặc Password không được để trống");
                }

            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        else if (e.getSource() == register) {
        	new Register();
        }
        
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
