<%@page import="departmentEmployee.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department and Employee Details</title>
<style type="text/css">
tr:nth-child(even) {
  background-color: #f2f2f2;
}
tr:nth-child(odd) {
  background-color: #fff;
}
</style>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%
	Department dept = (Department) session.getAttribute("dept");
	%>
	<table class="table table-bordered">
		<tr>
			<td>Department Id:</td>
			<td><%=dept.getDid()%></td>
		</tr>
		<tr>
			<td>Department Name:</td>
			<td><%=dept.getDname()%></td>
		</tr>
		<tr>
			<td>Department Location:</td>
			<td><%=dept.getDlocation()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="dispEmpbyDept" method="post">
					<input type="submit" name="submit" value="First" /> 
					<input type="submit" name="submit" value="Previous" /> 
					<input type="submit" name="submit" value="Next" /> 
					<input type="submit" name="submit" value="Last" />
				</form>
			</td>
		</tr>
	</table>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>EXPERIENCE</th>
				<th>SENIORITY</th>
				<th>SALARY</th>
				<th>DEPTID</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${emps}">
				<tr>
					<td><c:out value="${employee.eid}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.age}" /></td>
					<td><c:out value="${employee.experience}" /></td>
					<td><c:out value="${employee.seniority}" /></td>
					<td><c:out value="${employee.salary}" /></td>
					<td><c:out value="${employee.did}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>
