<%@ page import="com.mysql.cj.Session" %>
<%@ page import="com.hospitalManagement.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Aqeel Zeid
  Date: 26/04/2019
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1>Receptionist UI</h1>
        <h2>
            <%
               User LoggedInUSer =  (User) request.getSession().getAttribute("SESSION_user");

            %>
        </h2>
</body>
</html>
