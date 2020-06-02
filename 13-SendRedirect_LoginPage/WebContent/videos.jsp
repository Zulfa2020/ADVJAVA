<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videos</title>
</head>
<body>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-validate");
 
  if(session.getAttribute("username")==null){
	  response.sendRedirect("login.jsp");
    }

%>
<iframe width="360" height="215" src="https://www.youtube.com/embed/gQLQ0t9B5yk" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
 <br>
      <form action="logout" method="post">
                   <input type="submit" value="Home">
                     </form>
</body>
</html>