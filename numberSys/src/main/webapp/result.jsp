<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conversion Result</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container result-container">
        <h1 class="title">Result</h1>
        <p class="result-text">The result is: <%= request.getAttribute("result") %></p>
        <a href="convert.jsp" class="btn btn-secondary">Go Back</a>
    </div>
</body>
</html>