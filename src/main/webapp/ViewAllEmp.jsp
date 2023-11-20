<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="empPackage1.*, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Details</title>
</head>
<body>
<div style="text-align:center;border:2px solid black">

<%
List<EmployeeBean>listOfemployee =(List<EmployeeBean>)request.getAttribute("listofemployee");

for(EmployeeBean singleEmp:listOfemployee)
{

	//out.println(singleEmp); // I wana print the values of object , not the whole object (singleobject)
	%>	
	
	
	<tr>
	<td>Username:</td> <%=singleEmp.getUsername() %>
	</tr><br>
	
	<tr>
	<td>Password:</td> <%=singleEmp.getPassword() %>
	</tr>
	<br>
	<tr>
	<td>Type:</td> <%=singleEmp.getType() %>
	</tr>
	<br>
	
	<tr>
	<td>UserId:</td> <%=singleEmp.getUserid() %>
	</tr>
	<br>
	
	<br>
<% 
}
%>

</div>

</body>
</html>