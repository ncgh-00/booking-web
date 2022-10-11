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
        String query = "INSERT INTO [Rate] ([UID], [ID_Hotel], [Comment], [NumberOfStars], [Date]) values (?,?,?,?,getDate())";


        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, uid);
            ps.setString(2, id_Hotel);
            ps.setString(3, cmt);
            ps.setInt(4, stars);
            ps.executeUpdate();
            System.out.println(query);
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

    public boolean checkUID(String id_hotel, String uid){
        boolean check = false;
        String query = "select * from [Rate_View] where ID_Hotel = " + id_hotel + " and UID = '" + uid + "'";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(query);
//            String fullname, String UID, int ID_Hotel, String comment, int numberOfStars, Date date
            while (rs.next()) {
                    check = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public static void main(String[] args) {
        Rate_DAO rate = new Rate_DAO();
        if (rate.checkUID("2", "UCODE00000007"))
            System.out.println("hello");
    }

}
