<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<style type="text/css">
tr:nth-child(even) {
  background-color: #f2f2f2;
}
tr:nth-child(odd) {
  background-color: #fff;
}

.button3 {
  background-color: white;
  padding:10;
  border-radius:10px;
  color: black; 
  border: 2px solid #4CAF50;
}

.button3:hover {
  background-color: #4CAF50;
  color: white;
}
.button2 {
  background-color: white;
  padding:10;
  border-radius:10px;
  color: black; 
  border: 2px solid RED;
}

.button2:hover {
  background-color: RED;
  color: white;
}
.button1 {
  background-color: white;
  padding:10;
  border-radius:10px;
  color: black; 
  border: 2px solid Blue;
}

.button1:hover {
  background-color: BLUE;
  color: white;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: RED">
			<div>
				<p class="navbar-brand"> Employee Management Application </p>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">EMPLOYEES IN DATABASE</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Emp_ID</th>
						<th>Emp_Name</th>
						<th>Age</th>
						<th>Experience</th>
						<th>Seniority</th>
						<th>Salary</th>
						<th>Dept_ID</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="Employee" items="${getAllEmployees}">

						<tr>
							<td><c:out value="${Employee.eid}" /></td>
							<td><c:out value="${Employee.name}" /></td>
							<td><c:out value="${Employee.age}" /></td>
							<td><c:out value="${Employee.experience}" /></td>
							<td><c:out value="${Employee.seniority}" /></td>
							<td><c:out value="${Employee.salary}" /></td>
							<td><c:out value="${Employee.did}" /></td>
							<td><a class="button1" href="edit?eid=<c:out value='${Employee.eid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a class="button2" href="delete?eid=<c:out value='${Employee.eid}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a class="button3" href="show?eid=<c:out value='${Employee.eid}' />">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>