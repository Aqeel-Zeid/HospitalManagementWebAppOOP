package com.hospitalManagement.Model;

import com.hospitalManagement.util.DB.DatabaseConnector;

import java.sql.Time;
import java.util.Date;

public class WorkDay {

    public WorkDay() {
    }

    int Id;
    String Start;
    String End;
    String Name;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    String date;


    public int getId() {
        return Id;
    }

    public String getStart() {
        return Start;
    }

    public String getEnd() {
        return End;
    }

    public String getName() {
        return Name;
    }

    public WorkDay(int id, String start, String end, String name) {
        Id = id;
        Start = start;
        End = end;
        Name = name;
    }

    public void  addWorkDay(int timeSlotid,String date ,int docID)
    {
        String sql = "INSERT INTO work(doctor,date,timeSlot) VALUES ('"+docID+"','"+date+"','"+timeSlotid+"')";
        DatabaseConnector.insertQuery(sql);

    }

}
