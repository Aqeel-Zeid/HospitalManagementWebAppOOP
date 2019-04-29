package com.hospitalManagement.Controller.Doctor;

import com.hospitalManagement.Model.Doctor;
import com.hospitalManagement.Model.WorkDay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/WorkingDayUIServlet")
public class WorkingDayUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String timeSlots[] = new String[24];
        timeSlots = request.getParameterValues("timeSlot");
        HttpSession mySession = request.getSession();
        Doctor doc = (Doctor) mySession.getAttribute("SESSION_user");
        for(String t : timeSlots)
        {
            int id = Integer.parseInt(t);
            WorkDay wd = new WorkDay();
            wd.addWorkDay(id,request.getParameter("date"),doc.getID());
        }

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Doctor/DoctorMainUI.jsp");
        rd.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Doctor/WorkingDayUI.jsp");
        rd.forward(request,response);
    }
}
