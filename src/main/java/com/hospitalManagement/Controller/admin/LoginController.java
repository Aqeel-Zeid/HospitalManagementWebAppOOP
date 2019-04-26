package com.hospitalManagement.Controller.admin;

import com.hospitalManagement.Model.Doctor;
import com.hospitalManagement.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println("Ran The doPost in  Login Controller");
        String passwordFromField = request.getParameter("passwords");
        //System.out.println("password from The  text field " + passwordFromField);
        String emailFromField  = request.getParameter("email");
        //System.out.println("email from The  text field " + emailFromField);
        User newUser = new User(emailFromField);
        //System.out.println( " newUser.login(passwordFromField); : " + newUser.login(passwordFromField));
        boolean isLogin = newUser.login(passwordFromField);

        if (isLogin) {

            HttpSession mySession = request.getSession();

            String type = newUser.getType();
            switch (type) {
                case "Receptionist":
                    mySession.setAttribute("SESSION_user", newUser);
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/receptionist/ReceptionistMainMenuUI.jsp");
                    rd.forward(request, response);
                    break;
                case "Pharmacist":
                    mySession.setAttribute("SESSION_user", newUser);
                    RequestDispatcher rd2 = request.getRequestDispatcher("WEB-INF/Pharmacist/PharmacistMainUI.jsp");
                    rd2.forward(request, response);
                    break;
                case "LabAssistant":
                    mySession.setAttribute("SESSION_user", newUser);
                    RequestDispatcher rd3 = request.getRequestDispatcher("WEB-INF/LabAssistant/LabAssistantMainUI.jsp");
                    rd3.forward(request, response);
                    break;
                case "Doctor":
                    Doctor newDoc ;
                    newDoc = (Doctor) newUser;
                    newUser.getUserFromDB(newUser.getEmail());
                    mySession.setAttribute("SESSION_user", newUser);

                    RequestDispatcher rd4 = request.getRequestDispatcher("WEB-INF/Doctor/DoctorMainUI.jsp");
                    rd4.forward(request, response);
                    break;
            }
        } else {

        }
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
        rd.forward(request,response);

    }
}
