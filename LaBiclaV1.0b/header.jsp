<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>

<%!UserValueObject user;%>

<%
	user = (UserValueObject) session.getAttribute("user");

	if (user == null) // NO hay usuario firmado
	{
%>
  <div>
	<form action="" method="GET" name="autenticar">
	<div>
		Email <input type="text" name="email" id="user">
        Password <input type="text" name="password" id="password"> 
	</div>		
		<input type="submit" value="Entrar" onclick="validar()">	
		
			
			<a href="get_blog_info.controller">Blog</a>
			<a href="register.jsp">Registrar</a>
			
			
	</form>
	

   </div>
<%
	} 
	else // Hay usuario firmado
	{
%>
<div>
	<%=user.getName()%>
	<a href="get_blog_info.controller">Blog</a>
	<a href="cambiarPass.jsp"> Cambiar Contrase�a</a>
	<a href="logout.controller">Salir</a>
</div>
<%
	}
%>
