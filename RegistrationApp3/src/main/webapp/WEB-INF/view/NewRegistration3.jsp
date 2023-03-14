<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include  file="menu3.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
<pre>
<h2>New Registration</h2>
<h2>
<%

if(request.getAttribute("msg")!=null)
{out.println(request.getAttribute("msg")); }
if(request.getAttribute("save")!=null)
{out.println(request.getAttribute("save"));}
%>
</h2>
<form action="savereg" method="post">
 name<input type="text" name="name"/>
 city<input type="text" name="city"/>
 email<input type="text" name="email"/>
 mobile<input type="text" name="mobile"/>
<input type="submit" value="save"/>

</form >
</pre>
</body>
</html>