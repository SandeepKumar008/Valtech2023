<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Fancy Phone Number Ranker Result</title>
</head>
<body>
    <h1>Fancy Phone Number Ranker Result</h1>
    
    <p>Ranked Phone Numbers:</p>
    <ol>
        <c:forEach items="${rankedPhoneNumbers}" var="phoneNumber">
            <li>${phoneNumber}</li>
        </c:forEach>
    </ol>
    
    <p><a href="index.jsp">Go back</a></p>
</body>
</html>
