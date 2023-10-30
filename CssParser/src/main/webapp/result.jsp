<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>CSS Parser Result</title>
</head>
<body>
    <h1>CSS Parser Result</h1>
    
    <c:forEach items="${cssData}" var="entry">
        <h2>${entry.key}</h2>
        <table>
            <c:forEach items="${entry.value}" var="property">
                <tr>
                    <td>${property.key}</td>
                    <td>${property.value}</td>
                </tr>
            </c:forEach>
        </table>
    </c:forEach>
    
    <p><a href="index.jsp">Upload Another CSS File</a></p>
</body>
</html>
