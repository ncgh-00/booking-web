//package com.group3.trividi.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class Booking_DAO {
//    Connection conn = null; // Connect with SQL Server
//    PreparedStatement ps = null; // Throw query statement to SQL Server
//    ResultSet rs = null; // Receive the respond result of SQL Server
//    Statement st = null;
//
//    public void insertBook(int uid, int id_room, int number, String dateS, String dateE, int total) {
//        String query = "INSERT INTO [dbo].[Booking]([UID],[ID_Room_Details],[NumberOfRoom],[Date_Start],[Date_End],[Total_cost],[Confirm])\n"
//                + "values (?,?,?,?,?,?,0)";
//
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//
//            ps.setInt(1, uid);
//            ps.setInt(2, id_room);
//            ps.setInt(3, number);
//            ps.setString(4, dateS);
//            ps.setString(5, dateE);
//            System.out.println(DateProcessor.duration(dateS, dateE));
//            ps.setLong(6, total * number * DateProcessor.duration(dateS, dateE));
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
