<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.BlogEntryValueObject"%>
<%@ page import="mx.ipn.upiicsa.segsw.labicla.util.Utility"%>
<%@ page import="java.util.List"%>

<%!
List<BlogEntryValueObject> blogEntryList;
BlogEntryValueObject blogEntry;
BlogEntryValueObject blogEntryToBeUpdated;
String value;
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
	
	<h1>El Blog de La Bicla</h1>

<div>
	<form action="get_blog_info.controller" method="GET">
		<input type="text" name="criteria" placeholder="Tema"> 
		<input type="submit" value="Buscar">
	</form>
</div>

	<br>

	<% 
	
    blogEntryList = (List<BlogEntryValueObject>) request.getAttribute("blogEntryList");
	if(blogEntryList != null && blogEntryList.size() > 0)
	{
    %>

	<table border="1">
		<tr>
			<th width="15%">User</th>
			<th width="60%">Entrada</th>
			<th width="15%">Fecha</th>
			<% 
			
			System.out.println("blog.jsp - User - " + user);
			
			if( user != null) { 
					
					%>
			<th width="5%">&nbsp;</th>
			<th width="5%%">&nbsp;</th>
			<% } %>
		</tr>

		<% 
		for(int i = 0;i < blogEntryList.size(); i++)
		{
			blogEntry = blogEntryList.get(i);
%>
		<tr>
			<td><%= blogEntry.getUserEmail() %></td>
			<td><div><%= blogEntry.getValue() %></div></td>
			<td><%= blogEntry.getRegistrationDate() %></td>
			
			<% if( user != null && (blogEntry.getUserEmail().equals(user.getEmail()) || user.getEmail().equals("admin@novalidserver.net") )) { %>
			
			<td><a href="load_blog_entry_to_be_modified.controller?id=<%= blogEntry.getId() %>">Modify</a></td>
			<td><a href="delete_blog_entry.controller?id=<%= blogEntry.getId() %>">Delete</a></td>
			<% } %>			
		</tr>
		<% 
		}
%>
	</table>
	<% 
	}
	else if(Utility.containsAnEmptyValue(request.getParameter("criteria")) == false)
	{
%>
	<font color="red">No se encontraron info para <%= request.getParameter("criteria") %></font>	
	<%		
	}
%>
	<br>

<%
	if(user != null) 
	{
%>	
	<div>
		<% 
		  blogEntryToBeUpdated = (BlogEntryValueObject) request.getAttribute("blogEntryToBeUpdated");
		
		  value = "";
		  if(blogEntryToBeUpdated != null)
		  {
			  value = blogEntryToBeUpdated.getValue();
		%>
			<H2>Modificar comentario</H2>
			<form action="modify_blog_entry.controller" method="POST">
			<input type="hidden" name="id" value="<%=blogEntryToBeUpdated.getId()%>">
			
		<% } else { %>
			<H2>Agregar comentario</H2>
			<form action="register_blog_entry.controller" method="POST">
		<% } %>
		
			<textarea name="blog-entry-value" rows="5" cols="80" placeholder="Que deseas postear?"><%= value %></textarea>
			<input type="submit" value="enviar">
		</form>
	</div>
<%
	}%>
	
	<br>
	<a href="/LaBicla">Principal</a>
</body>
</html>
