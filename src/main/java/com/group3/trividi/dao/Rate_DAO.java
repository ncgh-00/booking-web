package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.Rate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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


    public List<Rate> getRate(String id_hotel, int offset){
        List<Rate> list = new ArrayList<>();
        String query = "select * from [Rate_View]\n"+
        "where ID_Hotel = \n" +id_hotel+
        " order by Date\n"+
        "OFFSET " +offset + " ROWS\n"+
        "FETCH NEXT 3 ROWS ONLY";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(query);
//            String fullname, String UID, int ID_Hotel, String comment, int numberOfStars, Date date
            while (rs.next()) {
                list.add(new Rate(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6)

                ));
            }

            System.out.print(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        Rate_DAO rate = new Rate_DAO();
        List<Rate> list = rate.getRate("1",0);


    }

}
