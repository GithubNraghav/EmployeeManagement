package empPackage1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

//
		
		// this iswhere I will get all the request for admin operations//
		
		// but the catch here is we are getting so many request's from multiple form to this servelt
		
		// everytime the request object will have data coming for different form
		
		// and this servelt has to manage different types of request's
		
//		how to do that is the mani catch here
		AdminDao adminDao=new AdminDao();
		String buttonValue = request.getParameter("button");
		
		
		if(buttonValue.equals("insert"))  
	// admin Servelt will handle insert form based on the button value coming
			// (we know, from which form the request is coming, and based on thtat we are writing code.)

		{
			System.out.println("inside Insert block");
		String newEmpname = request.getParameter("newempName");
		String newEmppass = request.getParameter("newempPass");
		String newEmpType= request.getParameter("newempType");
		int  newEmpId = Integer.parseInt(request.getParameter("newempId"));
		
		EmployeeBean empbean=new EmployeeBean();
		empbean.setUsername(newEmpname);
		empbean.setPassword(newEmppass);
		empbean.setType(newEmpType);
		empbean.setUserid(newEmpId);
		
		try 
		{
			int insertedEmployee = adminDao.insertEmployee(empbean );
		
	
		System.out.println(insertedEmployee);
		request.setAttribute("Numberempinserted", insertedEmployee);
		RequestDispatcher rd = request.getRequestDispatcher("InsertedResultPage.jsp");
		
		rd.forward(request, response);
		
		
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		}
		
		//////delete
		
		else if(buttonValue.equals("delete"))
		{
		
		System.out.println("inside delete block");
		int emptoDelete = Integer.parseInt(request.getParameter("emptodelete"));
		
		try {
			
		int numberEmpdeleted=adminDao.deleteEmp(emptoDelete);
		request.setAttribute("numberofdeleted", numberEmpdeleted);
		RequestDispatcher rd1 = request.getRequestDispatcher("EmployeeDeletedPage.jsp");  
		rd1.forward(request, response);
		
		}
		
		catch(Exception e) 
		{
			
			System.out.println(e);
		}
		
		
		
		}
		
		///Update
		
		else if(buttonValue.equals("updateform"))  
		{
			System.out.println("insideUpdate block");
			int userid=Integer.parseInt(request.getParameter("userid"));
			String updateName=request.getParameter("updateName");
			String updatePass=request.getParameter("updatePass");
			String updateType=request.getParameter("updateType");
			
			
			EmployeeBean updateEmpbean=new EmployeeBean();
			updateEmpbean.setUsername(updateName);
			updateEmpbean.setPassword(updatePass);
			updateEmpbean.setType(updateType);
			updateEmpbean.setUserid(userid);
			try 
			{
				int updatedEmployee = adminDao.updateEmployee(updateEmpbean);
				request.setAttribute("numberOfempUpdated", updatedEmployee);
				RequestDispatcher rd=request.getRequestDispatcher("UpdatedEmployeePage.jsp");
				rd.forward(request, response);
				
				
				
			} 
			
			catch (Exception e) 
			{
					System.out.println(e);

			} 

			
			
		}
		
		
		
		//fetch employee
		else if(buttonValue.equals("getEmpform")) 
		{
			int userid=Integer.parseInt(request.getParameter("GetEmpdetails"));
			try 
			{
				EmployeeBean employeeDetails=adminDao.getEmployee(userid);
				request.setAttribute("employeedetails",employeeDetails);
				RequestDispatcher rd= request.getRequestDispatcher("EmpDetails.jsp");
				rd.forward(request, response);
				
				
			} 
			
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
		
		
		}
		
		
		//fetch all employee
		
		else if(buttonValue.equals("getAllEmployee")) 
		{
			
			try 
			{
				List<EmployeeBean> allEmployee = adminDao.getAllEmployee();
				// I have to traverse here// no, I need to traverse the list on jsp page// as I am going to diplay it there.
				request.setAttribute("listofemployee", allEmployee);
				RequestDispatcher rd=request.getRequestDispatcher("ViewAllEmp.jsp");
				rd.forward(request, response);
			} 
			
			catch (Exception e) 
			{
				
				e.printStackTrace();
			} 
			
			
			
		}
		
		
		
		
		
		
	}//doPost

}// class
