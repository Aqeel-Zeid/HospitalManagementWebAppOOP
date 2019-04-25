package com.hospitalManagement.Model;

public class Doctor extends User {
    String Speciality;

    public Doctor(String name, String email, String address, String password1, String password2, String phone, String recoveryEmail, String NIC, String type, String speciality) {
        super(name, email, address, password1, password2, phone, recoveryEmail, NIC, type);
        Speciality = speciality;
    }
}
