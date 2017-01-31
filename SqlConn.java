import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;



public class SqlConn{

public static Connection getConnection() throws Exception
{
	try{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String dbusername = "root";
		String dbpassword = "";
		//String dbpassword = "minas994";
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url,dbusername,dbpassword);
		
		return conn;

	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,e); 
	}
	
	return null;
}

}

