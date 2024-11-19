package university.management.system;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends JFrame implements ActionListener {
	private JTextField usernameField; 
	private JPasswordField passwordField; 
	private JPasswordField confirmPasswordField; 
	private JButton registerButton;
	private JButton back;
	
	
	public Register(){
		setTitle("Register"); 
		setSize(600, 316); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null); 
		getContentPane().setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:"); 
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		usernameLabel.setBounds(50, 50, 100, 25);
		getContentPane().add(usernameLabel);
		
		usernameField = new JTextField(); 
		usernameField.setBounds(200, 52, 150, 25); 
		getContentPane().add(usernameField); 
		
		JLabel passwordLabel = new JLabel("Password:"); 
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		passwordLabel.setBounds(50, 90, 100, 25); 
		getContentPane().add(passwordLabel); 
		
		passwordField = new JPasswordField(); 
		passwordField.setBounds(200, 86, 150, 25); 
		getContentPane().add(passwordField); 
		
		JLabel confirmPasswordLabel = new JLabel("Confirm Password:"); 
		confirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		confirmPasswordLabel.setBounds(50, 130, 150, 25); 
		getContentPane().add(confirmPasswordLabel); 
		
		confirmPasswordField = new JPasswordField(); 
		confirmPasswordField.setBounds(200, 130, 150, 25); 
		getContentPane().add(confirmPasswordField); 
		
		registerButton = new JButton("Register"); 
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 15)); 
		registerButton.setBounds(200, 173, 121, 37); 
		registerButton.addActionListener(this); 
		getContentPane().add(registerButton);
		
		back = new JButton("Trở về");
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(333, 173, 93, 37);
		getContentPane().add(back);
		back.addActionListener(this);
		setVisible(true);
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.jpg"));
        Image i22 =  i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,-27,600,300);
        getContentPane().add(image);
		
	}
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(Register::new);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == registerButton) { 
			String username = usernameField.getText(); 
			String password = new String(passwordField.getPassword()); 
			String confirmPassword = new String(confirmPasswordField.getPassword());
			
			if (password.equals(confirmPassword)) { 
				if(checkUserExists(username)) {
					JOptionPane.showMessageDialog(this, "Tài khoản này đã tồn tại!");
				}
				else {
					String queryInsert = "insert into login values ('"+username+"', '"+password+"')";
					try {
						Conn c = new Conn();
		                c.statement.executeUpdate(queryInsert);
		                JOptionPane.showMessageDialog(this, "Đăng ký thành công!"); // Tiến hành lưu thông tin người dùng hoặc thực hiện các hành động khác 
		                this.setVisible(false); 
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			else { 
				JOptionPane.showMessageDialog(this, "Mật khẩu không khớp vui lòng nhập lại!"); 
			}
		}
		else {
			this.setVisible(false); 
		}
	}
	
	private boolean checkUserExists(String username) { 
		String queryCheck = "SELECT username FROM login WHERE username = ?"; 
		try { 
			Conn c = new Conn(); 
			PreparedStatement pstmt = c.connection.prepareStatement(queryCheck); 
			pstmt.setString(1, username); 
			ResultSet resultSet = pstmt.executeQuery(); 
			if (resultSet.next()) { 
				 
				return true; 
			} 
			else { 
				return false; 
				} 
			} 
		catch (Exception ex) { 
			ex.printStackTrace(); 
			return false; 
		} 
	}
}
