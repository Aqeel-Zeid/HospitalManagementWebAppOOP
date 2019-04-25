package com.hospitalManagement.Controller.admin;

import com.hospitalManagement.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        out.println(request.getParameter("Name"));

//        out.println(request.getParameter("Email"));
//        out.println(request.getParameter("Address"));
//        out.println(request.getParameter("Password1"));
//        out.println(request.getParameter("Password2"));
//        out.println(request.getParameter("Phone"));
//        out.println(request.getParameter("RecoveryEmail"));
//        out.println(request.getParameter("NIC"));
//        out.println(request.getParameter("Type"));
        if(!request.getParameter("Type").equals("Doctor"))
        {
            User NewUser = new User(
                    request.getParameter("Name"),
                    request.getParameter("Email"),
                    request.getParameter("Address"),
                    request.getParameter("Password1"),
                    request.getParameter("Password2"),
                    request.getParameter("Phone"),
                    request.getParameter("RecoveryEmail"),
                    request.getParameter("NIC"),
                    request.getParameter("Type")
            );
            NewUser.validate();
            NewUser.addToDB();


        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/SignUpView.jsp");
        rd.forward(request,response);


    }
}
