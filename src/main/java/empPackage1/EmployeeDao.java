package empPackage1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao 
{

	//1. View my  profile
//	public EmployeeBean viewMyProfile() throws ClassNotFoundException, SQLException 
//	{
//		String query="update employee set username=?,password=? where userid=?";
//		EmployeeBean beanobj=new EmployeeBean();
//		
//		DBconnection connection =new DBconnection(); 
//		Connection con = connection.getConnection();
//		PreparedStatement pst = con.prepareStatement(query);
//		
//		return beanobj;
//	}
//	
	//2.Edit my profile
	
	public int editProfile(EmployeeBean editbean) throws ClassNotFoundException, SQLException 
	{
		String query="update employee set username=?,password=? where userid=?";
		EmployeeBean beanobj=new EmployeeBean();
		
		DBconnection connection =new DBconnection(); 
		Connection con = connection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, editbean.getUsername());
		pst.setString(2, editbean.getPassword());
		pst.setInt(3, editbean.getUserid());
		int editedprofile=pst.executeUpdate();
		
		System.out.println(editedprofile);// should be 1
		return editedprofile;
	}
}
