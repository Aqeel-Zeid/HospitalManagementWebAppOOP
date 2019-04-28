package com.hospitalManagement.Controller.ajax;

import com.hospitalManagement.Model.Doctor;
import com.hospitalManagement.Model.WorkDay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/WorkingDayAjaxServlet")
public class WorkingDayAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession mySession = request.getSession();
        Doctor myDoc = (Doctor) mySession.getAttribute("SESSION_user");


        if(!request.getParameter("AjaxDate").isEmpty())
        {
            out.println("<h3>Hello From  Servlet</h3>");
            List<WorkDay> list = myDoc.getAvailableRooms(request.getParameter("AjaxDate"));
            for(WorkDay tempDay : list)
            {
                out.println("<section>");
                out.println("<h3>Room</h3>"  + "<h4>" + tempDay.getName()+"</h4>" );
                out.println("<h3>Start</h3>" +  "<h4>" + tempDay.getStart()+"</h4>" );
                out.println("<h3>End</h3>" +  "<h4>" + tempDay.getEnd()+"</h4>" );
                out.println("</section>");
            }
        }

    }
}
