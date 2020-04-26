<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 19/04/2020
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> Hi <%= request.getSession().getAttribute("user").toString()%>, registration  successful</h3>
<a href="Login.jsp">Login page</a>
<a href="Homepage.jsp">Registration page</a>
</body>
</html>
