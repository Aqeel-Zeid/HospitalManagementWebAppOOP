package com.hospitalManagement.Model;

import com.hospitalManagement.util.DB.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pathient {

    String FirstName ;
    String FullName ;
    String DOB ;
    String Address ;
    String Phone ;
    String Sex ;
    String BloodGroup ;

    public Pathient(String fullName, String phone) {
        FullName = fullName;
        Phone = phone;
    }

    String[] Allergies ;
    String[] AllergieDescriptions ;
    int ID;

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
        this.getPatientFromDB();

    }

    public void AddAllergyToDB()
    {
        for(int i = 0 ; i < this.Allergies.length ; i++)
        {
            String sql = "INSERT INTO ALLERGY (Allergy,Patient,Description) VALUES (' " +this.Allergies[i]+ "','" + this.ID + "',' "+this.AllergieDescriptions[i]+" ')";
            DatabaseConnector.insertQuery(sql);
        }

    }

    public void getPatientFromDB()
    {
        String sql2 = "SELECT * FROM Patient WHERE patient_Full_Name = '"+ this.FullName + "' AND PhoneNumber = '"+this.Phone+"'";
        ResultSet rs = DatabaseConnector.selectQueryDB(sql2);
        try {
            while (rs.next())
            {
                this.ID = rs.getInt("PatientID");
                this.FirstName = rs.getString("First_Name");
                this.DOB = rs.getString("DOB");
                this.Address = rs.getString("Address");
                this.Sex = rs.getString("Sex");
                this.BloodGroup = rs.getString("BloodGroup");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
