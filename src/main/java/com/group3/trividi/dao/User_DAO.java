package com.group3.trividi.dao;


import com.group3.trividi.context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User_DAO {
    Connection conn = null; // Connect with SQL Server
    PreparedStatement ps = null; // Throw query statement to SQL Server
    ResultSet rs = null; // Receive the respond result of SQL Server
    Statement st = null;

    public boolean checkAccount(String username, String mail) {
        boolean check = false;
        String query = "select * from Account\n"
                + "where username = '" + username + "' or Email = '" + mail + "'";
        //System.out.println(query);
        try {
            // Open connection with SQL Server
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            ps = conn.prepareStatement(query);
            // Get the result of SQL Server ans store in rs
            rs = ps.executeQuery();

            // Add data in rs to ArrayList
            while (rs.next()) {
                check = true;
            }

        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }

        return check;
    }

    public void insert(String username, String password, String fullname, String email, String phone) {
        String query = "insert into Account \n"
                + "values ('3',?,?,?,?,?,'1');";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ok");
    }

}
