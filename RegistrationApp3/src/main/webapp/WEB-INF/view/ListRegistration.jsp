<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
 <%@include file="menu3.jsp"%> 
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registration list</title>
</head>
<body>
<table border='1'>
<tr>
<th>name</th>
<th>city</th>
<th>email</th>
<th>mobile</th>
<th>Delete</th>
<th>Update</th>
</tr>
<% 
ResultSet result=(ResultSet)request.getAttribute("result"); 


while(result.next())
    {
	%>
	 <tr>
	 <td><%=result.getString(1)%></td>
	 <td><%=result.getString(2)%></td>
	 <td><%=result.getString(3)%></td>
	 <td><%=result.getString(4)%></td>
      <td><a href="delete?email=<%=result.getString(3)%>">delete</a>
	  <td><a href="update?email=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">update</a>
	 </tr>
	<%}%>
</table>
<%
    out.println(request.getAttribute("update"));
%>

</body>
</html>