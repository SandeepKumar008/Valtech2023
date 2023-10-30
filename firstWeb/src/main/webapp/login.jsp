<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<!-- bootstrap -->

<form action="login" method="post">
   <div class="form-group">
    Name: <input name="name" type="text" class="form-control"/>
    <% 
        if (request.getAttribute("nameError") != null) {
            out.println("<span style='color:red'>" + request.getAttribute("nameError") + "</span><br>");
        }
    %>
    </div>
    <br/>
    Pass: <input name="pass" type="password" class="form-control"/> 
     <div class="form-group">
    <% 
        if (request.getAttribute("passError") != null) {
            out.println("<span style='color:red'>" + request.getAttribute("passError") + "</span><br>");
        }
    %>
     </div>
    <br/>
    <input name="submit" type="submit" value="Login" />
    <% 
        if (request.getAttribute("loginError") != null) {
            out.println("<span style='color:red'>" + request.getAttribute("loginError") + "</span><br>");
        }
    %>
    
</form>

</body>
</html>




