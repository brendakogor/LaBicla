<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-theme.css">
	<script src="js/bootstrap.min.js"></script>
	<script src="js/validar.js"></script>

	<title>La Bicla</title>
</head>
<body>
	<div class="container">
	<%@ include file = "header.jsp" %>
	<%@ include file = "messages_panel.jsp" %>
	
		

		<form action="cambiarcontrasena.controller" name ="cambiar" method="POST">
			<div class="form-group">
	    		<label>Password actual:</label>
	    		<input type="text" name="oldpassword" id="passActual" class="form-control">
			</div>
			<div class="form-group">
	    		<label>Nuevo password:</label>
	    		<input type="text" name="pass" id="newpassword" class="form-control">
			</div>
			<div>
	    		<label>Confirmar nuevo password:</label>
	    		<input type="password" name="confirmPass" id ="confirmPass" class="form-control">
			</div>
			<div>
				<label></label>
		    	<input type="submit" class="btn btn-success" value="Cambiar" onclick="passIguales()">
			</div>
		</form>
		
	</div>
</body>
</html>