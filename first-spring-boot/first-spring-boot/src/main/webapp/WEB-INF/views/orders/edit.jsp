<%@page import="com.valtech.training.firstspringboot.model.OrderModel"%>
<%@page import="com.valtech.training.firstspringboot.entities.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CDN links -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
<%OrderModel order= (OrderModel) request.getAttribute("order"); %>
<form  method="post" action="save?id=<%= order.getId()%>">
<div class="row">
<div class="col-md-6 offset-md-3">
<table class="table table-bordered">
<tr>
<td>Id</td>
<td><input type="text" name="id" disabled="disabled" value = "<%=order.getId() %>" class="form-control"/></td>
</tr>
<tr>
<td>Item</td>
<td><input type="text" name="item" value = "<%=order.getItem() %>" class="form-control"/></td>
</tr>

<tr>
<td>ItemCount</td>
<td><input type="text" name="itemCount"  value = "<%=order.getItemCount() %>" class="form-control" /></td>
</tr>

<tr>
<td>Description</td>
<td><input type="text" name="description" value = "<%=order.getDescription()  %>" class="form-control"/></td>
</tr>

<tr>
<td>OrderDate</td>
<td><input type="text" name="orderDate"  value = "<%=order.getOrderDate()  %>" class="form-control"/></td>
</tr>

<tr>
<td colspan="2" class="text-center">
<input type="submit"  name="submit" value="Create" class="btn btn-primary"/>
<input type="submit"  name="cancel" value="Cancel" class="btn btn-secondary"/>
</td> 
</tr>
</table>
</div>
</div>
</form>
</div>
</body>
</html>
