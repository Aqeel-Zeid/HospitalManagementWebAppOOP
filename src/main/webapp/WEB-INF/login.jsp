<%--
  Created by IntelliJ IDEA.
  User: Aqeel Zeid
  Date: 26/04/2019
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="LoginController">
        <label>Email</label>
        <br>
        <input name="email" type="text">
        <br>
        <label>Password</label>
        <br>
        <input name="passwords" type="text">
        <br>
        <input type="submit" value="Login">
    </form>
    <a>forgot Password?</a>
    <a>SignUP</a>

</body>
</html>
