<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile Page</title>
</head>
<body>

<form action="EmployeeServlet" method="post">
Enter userid to edit profile:<input type="text" name="userid"><br>
Edit name:<input type="text" name="editEmpName"><br>
Edit password:<input type="password" name="editpass"><br>
<button type="submit" name="button" value="editprofileform">Submit</button>
</form>
</body>
</html>