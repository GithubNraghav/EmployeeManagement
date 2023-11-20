package empPackage1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoEmpManagement
{

	// in this I have to first write a method , to veriy the user, whether it is a employee or it is a admin
// 1. verify user
	public EmployeeBean verifyuser(String userid) throws ClassNotFoundException, SQLException 
	{
		System.out.println(userid);
		String dbuser="nraghav";
		String dbpass="raghav123";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String query="select * from employee where userid="+userid;
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con = DriverManager.getConnection(url,dbuser,dbpass);
		
	// note by default , the primary key to fetch any row,  would be the first column in the table// in any table// we can change the primary key..
		
		// we have two primary key now, using which we can fetch the row
		EmployeeBean empManage= new EmployeeBean();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection(url,dbuser,dbpass);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		
	if(rs.next())
		{
			empManage.setUsername(rs.getString("username"));
			System.out.println(rs.getString("username"));
			empManage.setPassword(rs.getString("password"));
			System.out.println(rs.getString("password"));
			empManage.setType(rs.getString(3));
			empManage.setUserid(rs.getInt(4));
			return empManage;
		}
		
		else 
		{
			return null;
		}
		
		 
	}
	
	// we only need this Dao class to verify user. 
	
	
	
	
}
