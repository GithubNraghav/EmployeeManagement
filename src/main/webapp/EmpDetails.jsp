<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="empPackage1.EmployeeBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

The employee Details are as below.
<%

EmployeeBean empDetails= (EmployeeBean)request.getAttribute("employeedetails");

out.println(empDetails.getUsername());
out.println(empDetails.getType());

out.println(empDetails.getUserid());

%>


</body>
</html>