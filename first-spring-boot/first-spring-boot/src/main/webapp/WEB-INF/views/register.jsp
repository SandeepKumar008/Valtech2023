<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CDN links -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<h5 class="text-danger">${message}</h5>
		<form action="register" method="post">
			<div class="form-group">
				<label for="username">Username</label> <input name="username"
					type="text" class="form-control" id="username" />
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input name="password"
					type="password" class="form-control" id="password" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password</label> <input
					name="confirmPassword" type="password" class="form-control"
					id="confirmPassword" />
			</div>
			<div class="form-group">
				<input name="submit" type="submit" class="btn btn-primary"
					value="Register" />
			</div>
		</form>
	</div>
</body>
</html>
