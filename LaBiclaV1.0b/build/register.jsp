<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject"%>

<html>
<head>
<link rel="stylesheet" href="/LaBicla/css/bootstrap.css">
<link rel="stylesheet" href="/LaBicla/css/bootstrap-theme.css">
<script src="/LaBicla/js/bootstrap.min.js"></script>
<script src="/LaBicla/js/validar.js"></script>
<title>La Bicla</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="messages_panel.jsp" />

	<br>

	<p>Por favor capture la siguiente informacion</p>	
	<table>
	
	<form action="registrar_usuario.controller" method="GET">
	    <tr>
	    	<td>Email</td>
	    	<td><input type="email" name="email"></td>
		</tr>
	    <tr>
	    	<td>Nombre</td>
	    	<td><input type="text" name="firstname"></td>
		</tr>
	    <tr>
	    	<td>Apellidos</td>
	    	<td><input type="text" name="lastname"></td>
		</tr>
	    <tr>
	    	<td>Password</td>
	    	<td><input type="text" name="password"></td>  <!-- required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}" -->
	    															 
		</tr>
		<tr>
	    	<td>Password (Confirmacion)</td>
	    	<td><input type="text" name="password-confirmation" ></td> <!-- required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}" -->
		</tr>
	 	<tr>
	    	<td>&nbsp;</td>
	    	<td><input type="submit" value="Registar"></td>
		</tr>
	</form>
	
	</table>

	<br>
	<a href="/LaBicla">Principal</a>
</body>
</html>
