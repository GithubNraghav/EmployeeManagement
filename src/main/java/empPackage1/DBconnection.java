package empPackage1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection 
{

	public Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		
		String dbuser="nraghav";
		String dbpass="raghav123";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");// will give the driver
		Connection con = DriverManager.getConnection(url,dbuser,dbpass);
		
		return con;
		
	}
	
	
}
