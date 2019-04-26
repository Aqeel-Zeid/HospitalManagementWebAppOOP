<%--
  Created by IntelliJ IDEA.
  User: Aqeel Zeid
  Date: 24/04/2019
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
    <script src="JS/jquery.js" type="text/javascript"></script>
    <script src="JS/test.js" type="text/javascript"></script>
</head>
<body>
    <h1>Register User</h1>
    <form name="signUp" action="SignUpController" method="post">

        <section id = "doctorType">
        <label>Type</label>
         <br>
            <input type="radio" name="Type" value="Receptionist"  id="recField" >
            <label>Receptionist</label>
         <br>
            <input type="radio" name="Type" value="Doctor" id="docField">
            <label>Doctor</label>
         <br>
            <input type="radio" name="Type" value="Pharmacist" id="pharmField">
            <label>Pharmacist</label>
         <br>
            <input type="radio" name="Type" value="LabAssistant" id="labField">
            <label>LabAssistant</label>
        </section>

        <div  id="AjaxResponse" >

        </div>

        <br>
        <label>First Name</label>
        <br>
        <input type="text" name="Name">
        <br>

        <br>
        <label>National Identity Card Number</label>
        <br>
        <input type="text" name="NIC">
        <br>

        <label>email</label>
        <br>
        <input type="text" name="Email">
        <br>

        <label>Phone</label>
        <br>
        <input type="text" name="Phone">
        <br>

        <label>Address</label>
        <br>
        <input type="text" name="Address">
        <br>

        <label>Password</label>
        <br>
        <input type="text" name="Password1">
        <br>

        <label>ReEnter Password </label>
        <br>
        <input type="text" name="Password2">
        <br>

        <label>Recovery Email</label>
        <br>
        <input type="text" name="RecoveryEmail">
        <br>

        <input type="submit" value="submit">
    </form>
</body>
</html>
