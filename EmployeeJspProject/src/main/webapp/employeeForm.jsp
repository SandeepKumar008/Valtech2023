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
				<c:if test="${Employee != null}">
				
					<form action="update" method="post">
					
					<h2>Edit Employee</h2>
					
					<fieldset class="form-group">
					<label>Employee ID</label> <input type="number" 
						value="<c:out value='${Employee.eid}' />" class="form-control"  
						name="eid" required="required" readonly/>
				</fieldset>
				
				</c:if>
				
				<c:if test="${Employee == null}">
				
					<form action="insert" method="post">
					
					<h2> Add New Employee</h2>
					
					<fieldset class="form-group">
					<label>Employee ID</label> <input type="number" 
						value="<c:out value='${Employee.eid}' />" class="form-control"  
						name="eid" required="required"/>
				</fieldset>
				
				</c:if>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${Employee.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Age</label> <input type="number"
						value="<c:out value='${Employee.age}' />" class="form-control"
						name="age">
				</fieldset>

				<fieldset class="form-group">
					<label>Experience</label> <input type="number"
						value="<c:out value='${Employee.experience}' />" class="form-control" 
						name="experience">
				</fieldset>

				<fieldset class="form-group">
					<label>Seniority</label> <input type="number"
						value="<c:out value='${Employee.seniority}' />" class="form-control" 
						name="seniority">
				</fieldset>

				<fieldset class="form-group">
					<label>Salary</label> <input type="number"
						value="<c:out value='${Employee.salary}' />" class="form-control"
						name="salary">
				</fieldset>

				<fieldset class="form-group">
					<label>Department ID</label> <input type="number"
						value="<c:out value='${Employee.did}' />" class="form-control"
						name="did">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>