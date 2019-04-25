package com.hospitalManagement.Model;

import com.hospitalManagement.util.DB.DatabaseConnector;

import java.util.HashMap;
import java.util.Map;

public class User {
    //        out.println(request.getParameter("Name"));
            String Name;
            String Email;
            String Address;
            String Password1;
            String Password2;
            String Phone;
            String RecoveryEmail;
            String NIC;
            String Type;

            public User(String name, String email, String address, String password1, String password2, String phone, String recoveryEmail, String NIC, String type) {
                Name = name;
                Email = email;
                Address = address;
                Password1 = password1;
                Password2 = password2;
                Phone = phone;
                RecoveryEmail = recoveryEmail;
                this.NIC = NIC;
                Type = type;
            }

            public void addToDB()
            {
                String sql = "INSERT INTO user (firstName, NIC, Address, password , type , email, phone, recoveryEmail ) " +
                             "VALUES ('" +
                             Name + "','" + NIC + "','" + Address + "','" + Password1 + "','" + Type + "','" + Email + "','" + Phone + "','" + RecoveryEmail + "');";
                DatabaseConnector.insertQuery(sql);
                System.out.println("User Added");
            }
            public int validate()
            {
                return 0;
            }




//        out.println(request.getParameter("Email"));
//        out.println(request.getParameter("Address"));
//        out.println(request.getParameter("Password1"));
//        out.println(request.getParameter("Password2"));
//        out.println(request.getParameter("Phone"));
//        out.println(request.getParameter("RecoveryEmail"));
//        out.println(request.getParameter("NIC"));
//        out.println(request.getParameter("Type"));
}
