<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor="lightblue" >

<form action="verifylogin" method="post">
username<input type="text" name="email"/>
password<input type="password" name="password"/>
<input type="submit" value="login">
<div>
<%
   if(request.getAttribute("error")!=null)
   {
	   out.println(request.getAttribute("error"));
   }
  out.println("html page");
%>
</div>
</form>
</body>
</html>