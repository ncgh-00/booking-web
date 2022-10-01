package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.Booking;

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
        String query = "select * from Manage_Booking where [UID] = '" + UID + "' order by ID_Booking desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            System.out.println(query);
//            int idBooking, String uid, String staffID, String hotelName, String roomName, int numOfRoom, Date dateStart, java.util.Date
//            dateEnd, int totalCost, boolean confirm
            while (rs.next()) {
                list.add(new Booking(rs.getInt(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(10),
                        rs.getDate(8),
                        rs.getDate(9),
                        rs.getInt(11),
                        rs.getBoolean(12)

                ));
            }

            System.out.print(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Booking> getMyHotels() {
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
                + "  FROM [dbo].[Manage_Booking]\n"
                + "  order by [Confirm]";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Booking(rs.getInt(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(10),
                        rs.getDate(8),
                        rs.getDate(9),
                        rs.getInt(11),
                        rs.getBoolean(12)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteBook(String id) {
        String query = "DELETE FROM [dbo].[Booking]\n"
                + "      WHERE ID_booking = " + id + " ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Booking_DAO b = new Booking_DAO();
        b.getBook("UCODE00000005");
    }

}
