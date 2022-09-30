package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
import com.group3.trividi.control.Booking;
import com.group3.trividi.utils.DateProcessor;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Booking_DAO {
    Connection conn = null; // Connect with SQL Server
    PreparedStatement ps = null; // Throw query statement to SQL Server
    ResultSet rs = null; // Receive the respond result of SQL Server
    Statement st = null;


    public List<Booking> getBook(String UID) {
        List<Booking> list = new ArrayList<>();
        String query = "select * from Booking where [UID] = " + UID + "order by ID_Booking desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            //int id, int id_room_details, String uid, String id_staff, Date dateStart, Date dateEnd, int numOfRoom, int totalCost, boolean confirm
            while (rs.next()) {
                list.add(new Booking(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getBoolean(9)
                ));
            }
            System.out.print(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Booking> getBooks() {
        List<Booking> list = new ArrayList<>();
        String query = "SELECT [ID_booking]\n"
                + "      ,[UID]\n"
                + "      ,[hotelName]\n"
                + "      ,[roomName]\n"
                + "      ,[Staff_id]\n"
                + "      ,[NumberOfRoom]\n"
                + "      ,[Date_Start]\n"
                + "      ,[Date_End]\n"
                + "      ,[Total_cost]\n"
                + "      ,[Confirm]\n"
                + "  FROM [dbo].[YourBooking]\n"
                + "  order by [Confirm]";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Book(rs.getInt(1),
//                        rs.getInt(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getInt(5),
//                        rs.getInt(6),
//                        rs.getDate(7),
//                        rs.getDate(8),
//                        rs.getInt(9),
//                        rs.getBoolean(10)
//                ));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
