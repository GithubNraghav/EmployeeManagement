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

Enter employeeName<input type="text" name="newempName"><br>
Enter employeePass<input type="password" name="newempPass"><br>
Enter employeeType<input type="text" name="newempType"><br>
Enter employeeId<input type="text" name="newempId"><br>

<button type="submit" name="button" value="insert">Submit</button>

</form>
</body>
</html>