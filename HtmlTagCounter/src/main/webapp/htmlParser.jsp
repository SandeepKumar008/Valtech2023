<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>HTML Parser</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
	text-align: center;
}
h1 {
	font-size: 24px;
	color: #333;
	margin-top: 20px;
}
form {
	margin-top: 20px;
}
label {
	font-size: 16px;
	color: #333;
	display: block;
	margin-bottom: 10px;
}
input[type="file"] {
	width: 40%;
	padding: 10px;
	font-size: 14px;
	border: 1px solid #ccc;
	border-radius: 5px;
}
input[type="submit"] {
	background-color: #007BFF;
	color: #fff;
	margin: auto;
	margin-top: 10px;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	transition: background-color 0.3s;
	cursor: pointer;
}
input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1>HTML Parser</h1>
	<form action="HtmlParserServlet" method="post"
		enctype="multipart/form-data">
		<label for="htmlFile">Upload HTML File:</label> <input type="file"
			name="htmlFile" id="htmlFile" accept=".html"> <br> <input
			type="submit" value="Parse HTML">
	</form>
</body>
</html>
