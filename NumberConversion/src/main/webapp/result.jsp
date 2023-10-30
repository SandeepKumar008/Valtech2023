<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conversion Result</title>
<style type="text/css">
* {
  margin: 0;
  padding: 0;
}
body {
  background-color: #f2f2f2;
  font-family: Arial, sans-serif;
}
.container.result-container {
  text-align: center;
  margin: 10% auto;
  width: 50%;
  background-color: #fff;
  border-radius: 10px;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  max-width: 600px;
}
.title {
  font-size: 24px;
  color: #333;
  margin-bottom: 20px;
}
.result-text {
  font-size: 18px;
  color: #555;
  margin-bottom: 20px;
}
.btn.btn-secondary {
  display: inline-block;
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  text-decoration: none;
  border-radius: 5px;
}
.btn.btn-secondary:hover {
  background-color: #0056b3;
}
</style>
</head>
<body>
<div class="container result-container">
        <h1 class="title">Result</h1>
        <p class="result-text">The result is: <%= request.getAttribute("result") %></p>
        <a href="convert.jsp" class="btn btn-secondary">Go Back</a>
    </div>
</body>
</html>