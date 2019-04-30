<%@ page import="com.hospitalManagement.Model.Doctor" %><%--
  Created by IntelliJ IDEA.
  User: Aqeel Zeid
  Date: 27/04/2019
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="JS/jquery.js" ></script>>
    <script type="text/javascript" src="JS/WorkingDaysAjax.js" ></script>>

</head>
<body>
        <h1>Working Day UI </h1>
        <section>
            <h3>Working Days</h3>
            <%
                Doctor doctor = (Doctor) session.getAttribute("SESSION_user");
                String type = doctor.getType();
            %>
            <form action="WorkingDayUIServlet" method="post">
                <label>Day</label>
                <br>
                <input type="date" name="date" id="dateField">

                <div id="Availabledays">

                </div>

                <input type="submit" value="confirm">


            </form>
        </section>
</body>
</html>
