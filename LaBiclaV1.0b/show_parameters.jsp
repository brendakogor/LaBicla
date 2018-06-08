<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Enumeration" %>

<%! 
Enumeration<String> params;
Enumeration<String> headers; 
String name;
String value;
%>

<html>
<head>
<link rel="stylesheet" href="/LaBicla/css/bootstrap.css">
<link rel="stylesheet" href="/LaBicla/css/bootstrap-theme.css">
<script src="/LaBicla/js/bootstrap.min.js"></script>
<script src="/LaBicla/js/validar.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La Bicla</title>
</head>
<body>

<p>Parameters </p>
<%

params = request.getParameterNames();
while(params.hasMoreElements())
{
	name = params.nextElement();
	value = request.getParameter(name);
%>
<p>{<%= name %>, <%= value %>}
<%} %>

<p>Headers </p>

<%

headers = request.getHeaderNames();

while(headers.hasMoreElements())
{
	name = headers.nextElement();
	value = request.getHeader(name);
%>
<p>{<%= name %>, <%= value %>}
<%} %>

</body>
</html>