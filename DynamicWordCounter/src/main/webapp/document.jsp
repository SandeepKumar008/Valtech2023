<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Processing</title>
</head>
<body>
    <h1>Text Processing</h1>
    <form action="DocumentServlet" method="post">
        <label for="paragraph">Enter a paragraph:</label><br>
        <textarea id="paragraph" name="paragraph" rows="10" cols="50"></textarea><br>
        <input type="submit" value="Process Text">
    </form>
</body>
</html>
