<%@ page import="com.hospitalManagement.Model.Doctor" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hospitalManagement.Model.WorkDay" %>
<%--
  Created by IntelliJ IDEA.
  User: Aqeel Zeid
  Date: 26/04/2019
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            Doctor doctor = (Doctor) session.getAttribute("SESSION_user");
            ArrayList<WorkDay> workDays = doctor.getWorkingDays();
        %>
        <h1>Doctor Main Menu UI</h1>
        <a href="WorkingDayUIServlet"><h2>Visiting Dates</h2></a>

        <br>
        <div>
            My Working Days
            <%
                for(WorkDay tempday : workDays)
                {
                    System.out.println(tempday.getName());
                    out.println( "<hr>"+"<label> Room </label>" + tempday.getName() + "<br>");
                    out.println("<label> Start </label>" +tempday.getStart() + "<br>");
                    out.println("<label> End </label>" +tempday.getEnd() +"<br>");
                    out.println("<label> Date </label>" +tempday.getDate() + "<hr>"+"<br>");


                }

            %>
        </div>
</body>
</html>
