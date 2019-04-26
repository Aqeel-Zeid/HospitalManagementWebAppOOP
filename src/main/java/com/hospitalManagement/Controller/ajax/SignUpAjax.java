package com.hospitalManagement.Controller.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SignUpAjax")
public class SignUpAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            //System.out.println(request.getParameter("ajax"));
            out.println("      <label>Type</label>\n" +
                    "                <br>\n" +
                    "                <input type=\"radio\" name=\"DocType\" value=\"Heart Specialist\"  >\n" +
                    "                <label>Heart Specialist</label>\n" +
                    "                <br>\n" +
                    "                <input type=\"radio\" name=\"DocType\" value=\"Gynaecologist\">\n" +
                    "                <label>Gynaecologist</label>\n" +
                    "                <br>\n" +
                    "                <input type=\"radio\" name=\"DocType\" value=\"Eye Specialist\">\n" +
                    "                <label>Eye Specialist</label>\n" +
                    "                <br>\n" +
                    "                <input type=\"radio\" name=\"DocType\" value=\"Ears Nose And Throat Specialist\">\n" +
                    "                <label>Ears Nose And Throat Specialist</label>\n" +
                    "                <br>\n" +
                    "                <input type=\"radio\" name=\"DocType\" value=\"General\">\n" +
                    "                <label>General</label>\n" +
                    "                <br>");
        } catch (NullPointerException e)
        {
            e.printStackTrace();
        }

    }
}
