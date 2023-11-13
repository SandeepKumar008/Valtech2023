<%@page import="javax.imageio.plugins.tiff.GeoTIFFTagSet"%>
<%@page import="com.valtech.training.firstspringboot.model.OrderModel"%>
<%@page import="com.valtech.training.firstspringboot.entities.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CDN links -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>List Of Orders</h3>
		<%
		List<OrderModel> orders = (List<OrderModel>) request.getAttribute("orders");
		%>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Item</th>
					<th>ItemCount</th>
					<th>Description</th>
					<th>OrderDate</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			
			<!-- JSTL core
			C: forEach -->
			
				<%
				for (OrderModel o : orders) {
					request.setAttribute("o", o);
				%>
				<tr>
					<td>${o.id }</td> 
					
					<!-- <%=o.getId()%> this is equal to ${o.id} -->
					<td>${ o.item}</td>
					<td>${ o.itemCount}</td>
					<td>${ o.description}</td>
					<td>${OrderDate }</td>
					<td>
					<a href="delete?id=${o.id }" class="btn btn-danger">Delete</a>
					<a href="edit?id=${o.id }" class="btn btn-primary">Edit</a>
					
					</td>
				</tr>
				
				<%
				}
				%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6" align="right">
					<form action="new" method="get"><input type="submit" name="submit" value="New order" class="btn btn-success"/>
					</form>
					</td>
				</tr>
				
			</tfoot>
		</table>
	</div>
</body>
</html>
