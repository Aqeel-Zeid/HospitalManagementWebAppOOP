package com.hospitalManagement.util.DB;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {

    static Connection conn = null;
    static PreparedStatement statements = null;

    public static javax.sql.DataSource setUpDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/hospital_management_db");
        ds.setUsername("webstudent");
        ds.setPassword("webstudent");
        return ds;
    }

    public static ResultSet selectQueryDB(String sql) {
        ResultSet rs = null;
        javax.sql.DataSource dataSource = setUpDataSource();
        try {
            conn = dataSource.getConnection();
            statements = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = statements.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }

    public static int insertQuery(String sql)
    {
        int rs = 0;
        javax.sql.DataSource dataSource = setUpDataSource();
        try {
            conn = dataSource.getConnection();
            statements = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = statements.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
