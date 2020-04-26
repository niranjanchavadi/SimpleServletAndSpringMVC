<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 19/04/2020
  Time: 02:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> Hi <%= request.getAttribute("username")%>, login successful</h3>
<a href="Login.jsp">Logout</a>
</body>
</html>
