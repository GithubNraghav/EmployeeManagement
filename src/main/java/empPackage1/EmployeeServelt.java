package empPackage1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServelt extends HttpServlet

{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String buttonValue=request.getParameter("button");
		EmployeeDao empdao=new EmployeeDao();
		
	if(buttonValue.equals("editprofileform"))
	{
		int userid = Integer.parseInt(request.getParameter("userid"));
		String newName=request.getParameter("editEmpName");
		String newPass=request.getParameter("editpass");
		EmployeeBean editbean= new EmployeeBean();
		editbean.setUsername(newName);
		editbean.setPassword(newPass);
		editbean.setUserid(userid);
		// edit profile page
		
		try
		{
		int editedProfile= empdao.editProfile(editbean);
		request.setAttribute("editedProfileObject", editedProfile);
		RequestDispatcher rd=request.getRequestDispatcher("EditedProfile.jsp");
		rd.forward(request, response);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	else if(buttonValue.equals("viewProfileform"))
	{
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		try 
		{
		AdminDao admindao= new AdminDao();
		EmployeeBean MyProfileobject = admindao.getEmployee(userid);
		request.setAttribute("employeedetails", MyProfileobject);
		RequestDispatcher rd=request.getRequestDispatcher("EmpDetails.jsp");
		rd.forward(request, response);
		
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
	}
	
	else 
	{
		System.out.println("invalid page request");
	}
	
	}
	
}
