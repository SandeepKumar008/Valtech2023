<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>HTML Parser Results</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

h1 {
	font-size: 24px;
	color: #333;
	margin-top: 20px;
}

h2 {
	font-size: 20px;
	color: #333;
	margin-top: 20px;
}

ul {
	list-style-type: none;
	margin-top: 20px;
	padding-left: 20px;
}

li {
	font-size: 16px;
	color: #333;
	margin-bottom: 10px;
}

li:last-child {
    display: inline-block;
    padding: 5px;
    border: 1px solid black;
    font-size: 20px;
    font-weight: bold;
    color: blue;
}

</style>

</head>
<body>
	<h1>HTML Parser Results</h1>
	<h2>Tag Count and Locations:</h2>
	<ul>
		<c:forEach items="${tags}" var="tag">
			<li>${tag}</li>
		</c:forEach>
	</ul>
</body>
</html>
