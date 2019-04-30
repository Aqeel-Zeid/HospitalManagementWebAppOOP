package com.hospitalManagement.Controller.receptionist;

import com.hospitalManagement.Model.Pathient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterPatientController")
public class RegisterPatientController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String FirstName = request.getParameter("FirstNameField");
        String FullName = request.getParameter("FullNameField");
        String DOB = request.getParameter("DOBField");
        String Address = request.getParameter("AddressField");
        String Phone = request.getParameter("PhoneNumberField");
        String Sex = request.getParameter("Sex");
        String BloodGroup = request.getParameter("BloodGroup").concat(request.getParameter("BloodGroup2"));
        String[] Allergies = request.getParameterValues("AllergyName");
        String[] AllergieDescriptions = request.getParameterValues("AllergyDescription");

        Pathient newPatient = new Pathient(FirstName,FullName,DOB,Address,Phone,Sex,BloodGroup,Allergies,AllergieDescriptions);
        newPatient.AddPatientToDB();

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/receptionist/ReceptionistMainMenuUI.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/receptionist/RegisterPatient.jsp");
        rd.forward(request,response);

    }
}
