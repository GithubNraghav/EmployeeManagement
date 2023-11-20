<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View My Profile</title>
</head>
<body>

Please Enter your userid to view profileDetails!!

<form action="EmployeeServlet" method="post">

Enter Userid:<input type="text" name="userid"><br>

<button type="submit" name="button" value="viewProfileform">Submit</button>
</form>
</body>
</html>