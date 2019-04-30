package com.hospitalManagement.Model;

import com.hospitalManagement.util.DB.DatabaseConnector;

public class Pathient {

    String FirstName ;
    String FullName ;
    String DOB ;
    String Address ;
    String Phone ;
    String Sex ;
    String BloodGroup ;
    String[] Allergies ;
    String[] AllergieDescriptions ;

    public Pathient(String firstName, String fullName, String DOB, String address, String phone, String sex, String bloodGroup, String[] allergies, String[] allergieDescriptions) {
        FirstName = firstName;
        FullName = fullName;
        this.DOB = DOB;
        Address = address;
        Phone = phone;
        Sex = sex;
        BloodGroup = bloodGroup;
        Allergies = allergies;
        AllergieDescriptions = allergieDescriptions;
    }

    public void AddPatientToDB(){
        String sql = "INSERT INTO `hospital_management_db`.`patient` (`Patient_Full_Name`, `First_Name`, `DOB`, `address`, `PhoneNumber`, `Sex`, `BloodGroup`) " +
                "VALUES (" +
                "'"+ this.FullName + "', " +
                "'"+ this.FirstName +"', " +
                "'"+ this.DOB +"', " +
                "'"+ this.Address +"', " +
                "'"+ this.Phone+"', " +
                "'"+ this.Sex+"', " +
                "'"+this.BloodGroup+"'" +
                "); ";
        DatabaseConnector.insertQuery(sql);
    }


}
