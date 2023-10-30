<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
<style type="text/css">
  body {
    background-color: #f2f2f2;
    font-family: Arial, sans-serif;
  }
  center {
    margin: 10% auto;
    width: 50%;
    text-align: center;
    background-color: #fff;
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  }
  h1 {
    color: #e74c3c;
  }
  h2 {
    color: #333;
  }
</style>
</head>
<body>
	<center>
		<h1>Error</h1>
		<h2><%=exception.getMessage() %><br/> </h2>
	</center>	
</body>
</html>