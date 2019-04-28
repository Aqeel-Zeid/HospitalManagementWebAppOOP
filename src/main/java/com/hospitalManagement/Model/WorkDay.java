package com.hospitalManagement.Model;

import java.sql.Time;
import java.util.Date;

public class WorkDay {
    int Id;
    String Start;
    String End;
    String Name;

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
}
