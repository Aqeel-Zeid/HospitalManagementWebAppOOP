package com.hospitalManagement.Model;

import com.hospitalManagement.util.DB.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor extends User {
    String Speciality;

    public Doctor(String name, String email, String address, String password1, String password2, String phone, String recoveryEmail, String NIC, String type, String speciality) {
        super(name, email, address, password1, password2, phone, recoveryEmail, NIC, type);
        Speciality = speciality;
    }

    @Override
    public void addToDB() {
        super.addToDB();
        String sql2 = "SELECT * from user WHERE NIC = '" + NIC + " ';" ;
        ResultSet rs = DatabaseConnector.selectQueryDB(sql2);
        try {
                while (rs.next())
                {
                    this.ID = rs.getInt("ID");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql3 = "INSERT INTO doctor (speciality,ID) VALUES ('" + this.Speciality +"','"+ this.ID +"')";
        DatabaseConnector.insertQuery(sql3);


    }
}
