package com.hospitalManagement.Model;

import com.hospitalManagement.util.DB.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void getUserFromDB(String email2) {
        super.getUserFromDB(email2);
        String sql = "SELECT * FROM doctor WHERE id = '" + this.ID + "';";
        ResultSet rs = DatabaseConnector.selectQueryDB(sql);
        try {
            while (rs.next())
            {
                this.Speciality = rs.getString("speciality");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<WorkDay> getAvailableRooms(String date)
    {
        String sql = "CALL GetALLFreeTimeSlots('"+ this.Speciality +"','"+ date +"')";
        ResultSet rs = DatabaseConnector.selectQueryDB(sql);
        List<WorkDay> TimeSlots = new ArrayList<>();
        WorkDay temDay;
        try {
            while (rs.next())
            {
                temDay = new WorkDay(rs.getInt("id"),rs.getString("start"),rs.getString("end"),rs.getString("Name"));
                TimeSlots.add(temDay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return TimeSlots;

    }
}
