<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.util.Utility"%>

<%!
String message;
%>

<%
	message = (String) request.getAttribute("message");

	if (Utility.containsAnEmptyValue(message) == false) // Hay mensaje por mostrar
	{
%>
    <br>
	<div>
		<ul>
			<li><font color="blue"><%= message %></font></li>
		</ul>
	</div>
<%
	} 
%>
