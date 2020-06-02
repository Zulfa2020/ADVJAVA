<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-validate");

  if(session.getAttribute("username")==null)
    {
	  response.sendRedirect("login.jsp");
    }

%>
                   Welcome ${username}
                   <br>
                   <a href='videos.jsp'>Videos Here</a>
                   <br>
           <form action="logout" method="post">
                   <input type="submit" value="Logout">
            
            </form>
</body>
</html>