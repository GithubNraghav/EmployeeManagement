package empPackage1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verifyServlet")
public class verifyFilter extends HttpServlet 
{
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		// I do not ahve to just veryfy user  // using static values
		// I need verify user from data base.
		
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		String userid = request.getParameter("userid");
		
		DaoEmpManagement dao=new DaoEmpManagement();
		try 
		{
			
			
		EmployeeBean userfromdb = dao.verifyuser(userid);
		System.out.println(userfromdb);
		
		if(userfromdb!=null)
		{
			
		if(userfromdb.username.equals(uname)&& userfromdb.password.equals(password))
		{
			System.out.println("valid user, login successful");
			System.out.println(userfromdb);
		// redirect to welcome page of admin or employee based on type.
			if(userfromdb.type.equals("admin")) 
			{
				System.out.println("welcome Admin");
				// redirect to admin page
				HttpSession session = request.getSession();
				session.setAttribute("adminName", uname);
				response.sendRedirect("AdminPage.jsp");
				
			}
			else if(userfromdb.type.equals("employee"))
			{
				// redirect to employee page
				System.out.println("welcome employee");
				HttpSession session = request.getSession();
				session.setAttribute("employeeName", uname);
				response.sendRedirect("EmployeePage.jsp");
			}
			
			
		}
		
		else 
		{
			System.out.println("invalid user");
		}
		
		
		}//
		
		else
		{
						System.out.println("invalid user// user did not exist in our database");
			// redirect to login again
		}
		
		
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
	}

}
