<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>CSS Parser</title>
</head>
<body>
    <h1>CSS Parser</h1>
    <form action="cssParser" method="post">
        <label for="cssFile">Upload a CSS file:</label>
        <input type="file" name="cssFile" id="cssFile" accept=".css" required>
        <br>
        <input type="submit" value="Parse CSS">
    </form>
</body>
</html>
