<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject"%>
<%@ page import="java.util.List"%>

<%!
List<ProductValueObject> productList;
ProductValueObject product;
%>

<html>
<head>
<link rel="stylesheet" href="/LaBicla/css/bootstrap.css">
<link rel="stylesheet" href="/LaBicla/css/bootstrap-theme.css">
<script src="/LaBicla/js/bootstrap.min.js"></script>
<script src="/LaBicla/js/validar.js"></script>
<title>La Bicla</title>
</head>
<body>

	<%@ include file = "header.jsp" %>
	<%@ include file = "messages_panel.jsp" %>

	<br>

	<%@ include file = "search_panel.jsp" %>

	<br>

	<% 
	productList = (List<ProductValueObject>) request.getAttribute("productList");
	if(productList != null && productList.size() > 0)
	{
    %>

	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Marca</th>
			<th>Precio</th>
			<th>Imagen</th>
			<th>&nbsp;</th>
		</tr>

		<% 
		for(int i = 0;i < productList.size(); i++)
		{
			product = productList.get(i);
%>
		<tr>
			<td><%= product.getName() %></td>
			<td><%= product.getDescription() %></td>
			<td><%= product.getBrand() %></td>
			<td><%= product.getPrice() %></td>
			<td><%= product.getImage() %></td>
			<td><a
				href="get_product_detail.controller?id=<%= product.getId() %>">Ver
					Detalle</a></td>
		</tr>
		<% 
		}
%>
	</table>
	<% 
	}
	else
	{
%>

	<font color="red">No se encontraron productos para <%= request.getParameter("criteria") %></font>
	<%
		
	}
%>
	<br>
	<br>
	<a href="/LaBicla">Principal</a>
</body>
</html>
