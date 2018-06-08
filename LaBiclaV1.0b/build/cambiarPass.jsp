<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<link rel="stylesheet" href="/LaBicla/css/bootstrap.css">
	<link rel="stylesheet" href="/LaBicla/css/bootstrap-theme.css">
	<script src="/LaBicla/js/bootstrap.min.js"></script>
	<script src="/LaBicla/js/validarn.js"></script>

	<title>La Bicla</title>
</head>
<body>
	<div class="container">
	<%@ include file = "header.jsp" %>
	<%@ include file = "messages_panel.jsp" %>
	
		

		<form action="" name ="cambiar" method="GET">
			<div class="form-group">
	    		<label>Password actual:</label>
	    		<input type="text" name="passActual" id="passActual" class="form-control">
			</div>
			<div class="form-group">
	    		<label>Nuevo password:</label>
	    		<input type="text" name="pass" id="pass" class="form-control">
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