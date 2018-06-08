<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject"%>

<%!
	ProductValueObject product;%>

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

	<br>

	<%
		product = (ProductValueObject) request.getAttribute("product");
		if (product != null) {
		
		
	%>
	<p>
		Nombre:
		<%=product.getName()%></p>
	<p>
		Descripcion:
		<%=product.getDescription()%></p>
	<p>
		Marca:
		<%=product.getBrand()%></p>
	<p>
		Precio:
		<%=product.getPrice()%></p>
		
	<p>
		Imagen:
		<%=product.getImage()%></p>	
		<img src="/LaBicla/images/<%= product.getImage() %> " width=15% />	

	<%
		} else {
	%>

	<font color="red">No se encontr&oacute; el producto indicado con id = <%=request.getParameter("id") %></font>

	<%
		}
	%>

	<br>
	<br>
	<a href="/LaBicla">Principal</a>
</body>
</html>
