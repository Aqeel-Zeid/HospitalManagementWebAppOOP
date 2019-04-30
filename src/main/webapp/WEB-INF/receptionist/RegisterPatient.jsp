<%--
  Created by IntelliJ IDEA.
  User: Aqeel Zeid
  Date: 29/04/2019
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Patient</title>
    <script type="text/javascript" src="JS/jquery.js" ></script>>
    <script type="text/javascript" src="JS/RegisterPatientAjax.js" ></script>>
</head>
<body>
    <h1>Register Patient</h1>
    <form method="post" action="RegisterPatientController">
        <br><label>First Name</label><input type="text" name="FirstNameField"><br>
        <br><label>Full Name</label><br><input type="text" name="FullNameField"><br>
        <br><label>Date Of Birth</label><br><input type="date" name="DOBField"><br>
        <br><label>Address</label><br><input type="text" name="AddressField"><br>
        <br><label>Phone Number</label><br><input type="text" name="PhoneNumberField"><br>
        <br><label>Sex</label><br>
        <label>Male</label><input type="radio" name="Sex" value="Male">
        <label>Female</label><input type="radio" name="Sex" value="Female">
        <br>
        <section>
            <br>
            <label>Blood Group</label><br>
            <input type="radio" name="BloodGroup" value="A"><label>A</label>
            <input type="radio" name="BloodGroup" value="B"><label>B</label>
            <input type="radio" name="BloodGroup" value="AB"><label>AB</label>
            <input type="radio" name="BloodGroup" value="O"><label>O</label>
            <br>
            <label>Rhesus Factor</label><br>
            <input type="radio" name="BloodGroup2" value="+"><label>+</label>
            <input type="radio" name="BloodGroup2" value="-"><label>-</label>
            <br>
        </section>
        <section>
            <br><label>Allergies</label>
            <input type="button" id = "addAllergy"  value="+"><br>
            <div id = "AjaxResponse">

            </div>
        </section>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
