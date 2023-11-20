package empPackage1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao 
{

	//1 in this servlet I have to write a method, which insert a new employee in db
	
		//2 delete a new employee already exist in database
			//3 update a existing employe record
			//4. fetch employee record.
			
			public int insertEmployee(EmployeeBean employeebean) throws ClassNotFoundException, SQLException
			{
				
			

				String query = "insert into employee values(?,?,?,?)";
				DBconnection connection=new DBconnection();		// this willl use that dreiver and pass user,pass and // url to connet to database, and get the connection
				Connection con = connection.getConnection();
			
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, employeebean.getUsername());
				pst.setString(2, employeebean.getPassword()); 
				pst.setString(3, employeebean.getType());
				pst.setInt(4, employeebean.getUserid());
				int updated_row = pst.executeUpdate();
				pst.close();
				con.close();
				return updated_row; // I have to write actual dao code which will insert a new employee in the
									// database
			
			}
	
			
			// 2 delete a employee
			
			public int deleteEmp(int useridToDelete) throws SQLException, ClassNotFoundException 
			{
				

				String query = "delete from employee where userid=?";
				DBconnection connection=new DBconnection();		// this willl use that dreiver and pass user,pass and // url to connet to database, and get the connection
				Connection con = connection.getConnection();
				PreparedStatement pst=con.prepareStatement(query);
				pst.setInt(1, useridToDelete);
				int row_deleted =pst.executeUpdate();
				pst.close();
				con.close();
			
				return row_deleted;
				
			}
	
			//3 update employee details
			
			 public int updateEmployee(EmployeeBean updateEmpbean) throws ClassNotFoundException, SQLException
			 {
					
					String query = "update employee set username=?,password=?,type=? where userid=?";
					
					DBconnection connection=new DBconnection();		// this willl use that dreiver and pass user,pass and // url to connet to database, and get the connection
					Connection con = connection.getConnection();
					
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1,updateEmpbean.getUsername() );
					pst.setString(2,updateEmpbean.getPassword() );
					pst.setString(3,updateEmpbean.getType());
					pst.setInt(4,updateEmpbean.getUserid());
					int row_updated=pst.executeUpdate();
				     pst.close();
				     con.close();
				 return row_updated;
			 }
			 
			 
			 
			 
			// 4// get employee details
			 public EmployeeBean getEmployee(int userid) throws ClassNotFoundException, SQLException 
			 {
				 EmployeeBean empdetails=new EmployeeBean();
				 
				
					String query = "select * from employee where userid=?";

					DBconnection connection = new DBconnection(); // this willl use that dreiver and pass user,pass and
																	// // url to connet to database, and get the
																	// connection
					Connection con = connection.getConnection();
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, userid);
					ResultSet rs = pst.executeQuery();
				    rs.next();
				    
				    empdetails.setUsername(rs.getString(1));
				    empdetails.setPassword(rs.getString(2));
				    empdetails.setType(rs.getString(3));
				    empdetails.setUserid(rs.getInt(4));
				    
				 return empdetails;
			 }
			 
		//	5 all employee records
	
			 public List<EmployeeBean> getAllEmployee() throws ClassNotFoundException, SQLException
			 {
			
				 List<EmployeeBean>listofEmp=new ArrayList();
				 
				 String query="select * from employee"; // as I need all the rows from the table.
				 DBconnection connection= new DBconnection();
				 Connection con = connection.getConnection();
				 PreparedStatement pst=con.prepareStatement(query); 
				 ResultSet rs=pst.executeQuery();
				
				 // I need to fetch all the rows and I need to  add each object in  the array, or a list
				while( rs.next()) 
				{
				EmployeeBean empBean= new EmployeeBean();
				empBean.setUsername(rs.getString(1));
				empBean.setPassword(rs.getString(2)); 
				empBean.setType(rs.getString(3));
				empBean.setUserid(rs.getInt(4));
				
				listofEmp.add(empBean);
				
				}
				
				return listofEmp;
			
				
				
			 }
			 
			 
			
}
