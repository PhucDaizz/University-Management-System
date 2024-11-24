package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	private static final String URL = "jdbc:mysql://localhost:3306/universitymanagement"; // Thay your_database bằng tên database
    private static final String USER = "root"; // Thay your_username bằng tên người dùng database
    private static final String PASSWORD = ""; // Thay your_password bằng mật khẩu database
	
	Connection connection;
    Statement statement;
    
    
    public Conn(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagement","root","");
            statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } 
    
}
