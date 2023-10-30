<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<p class="navbar-brand"> Employee Management Application </p>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<form action="update" method="post">
					
				<table class="form-group">
					<tr>
					<td><label>Employee ID</label></td>
					<td><input type="number" 
						value="<c:out value='${Employee.eid}' />" class="form-control"  
						name="eid" required="required" readonly/></td>
					</tr>

					<tr>
					<td><label>Employee Name</label></td> 
					<td><input type="text"
						value="<c:out value='${Employee.name}' />" class="form-control"
						name="name" required="required" readonly/></td>
					</tr>

				<tr>
					<td><label>Age</label></td> 
					<td><input type="number"
						value="<c:out value='${Employee.age}' />" class="form-control"
						name="age" readonly/></td>
				</tr>

				<tr>
					<td><label>Experience</label></td>
					<td><input type="number"
						value="<c:out value='${Employee.experience}' />" class="form-control" 
						name="experience" readonly/></td>
				</tr>

				<tr>
					<td><label>Seniority</label></td>
					<td><input type="number"
						value="<c:out value='${Employee.seniority}' />" class="form-control" 
						name="seniority" readonly/></td>
				</tr>

				<tr>
					<td><label>Salary</label></td> 
					<td><input type="number"
						value="<c:out value='${Employee.salary}' />" class="form-control"
						name="salary" readonly/><td>
				</tr>

				<tr>
					<td><label>Department ID</label></td> 
					<td><input type="number"
						value="<c:out value='${Employee.did}' />" class="form-control"
						name="did" readonly/></td>
				</tr>

				<tr>
					<td><button type="submit" class="btn btn-success">Save</button></td>
				</tr>
				
				</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>