package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Rate_DAO {
    Connection conn = null; // Connect with SQL Server
    PreparedStatement ps = null; // Throw query statement to SQL Server
    ResultSet rs = null; // Receive the respond result of SQL Server
    Statement st = null;

    public void addRate(String uid, String id_Hotel, String cmt, int stars){
        String query = "INSERT INTO [Rate] ([UID], [ID_Hotel], [Comment], [NumberOfStars], [Date]) value(?,?,?,?,'getDate()')";


        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, uid);
            ps.setString(2, id_Hotel);
            ps.setString(3, cmt);
            ps.setInt(4, stars);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
