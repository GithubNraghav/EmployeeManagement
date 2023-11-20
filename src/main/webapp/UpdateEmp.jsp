<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminServlet" method="post">

Enter Emp Id:<input type="text" name="userid"><br>

Update employeeName:<input type="text" name="updateName"><br>
Update employeePass:<input type="password" name="updatePass"><br>
Update employeeType:<input type="text" name="updateType"><br>
<button type="submit" value="updateform"name="button">Update</button>

</form>
</body> 
</html>