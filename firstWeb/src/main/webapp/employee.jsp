<%@page import="firstWeb.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<% Employee emp=(Employee) session.getAttribute("emp"); %>
<table>
<tr>
	<td>ID</td>
	<td><%=emp.getId() %></td>
</tr>
<tr>
	<td>Name</td>
	<td><%=emp.getName() %></td>
</tr>
<tr>
	<td>Age</td>
	<td><%=emp.getAge() %></td>
</tr>
<tr>
	<td>Experience</td>
	<td><%=emp.getExperiance() %></td>
</tr>
<tr>
	<td>seniority</td>
	<td><%=emp.getSeniority() %></td>
</tr>
<tr>
	<td>Salary</td>
	<td><%=emp.getSalary() %></td>
</tr>
<tr>
	<td colspan="2">
	<form action="empCtlr" method="post">
		<input type = "submit" name="submit" value = "First"/>
		<input type = "submit" name="submit" value = "Previous"/>
		<input type = "submit" name="submit" value = "Next"/>
		<input type = "submit" name="submit" value = "Last"/>
		
		
		
	</form>
	</td>
</tr>
</table>
</body>
</html>