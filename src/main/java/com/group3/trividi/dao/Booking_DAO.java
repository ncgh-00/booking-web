package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.Booking;
import com.group3.trividi.utils.DateProcessor;

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
//            System.out.println(query);
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
                        rs.getBoolean(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getInt(3)

                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Booking> getBooks(String idHotel) {
        List<Booking> list = new ArrayList<>();
        String query = "select * from Manage_Booking where ID_Hotel = '" + idHotel + "' order by ID_Booking desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
//            System.out.println(query);
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
                        rs.getBoolean(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getInt(3)

                ));
            }

            System.out.print(list.size());
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

    public void insertBook(int id_room, String uid, String dateS, String dateE, int numOfRoom, int total) {
        String query = "INSERT INTO [Booking]([ID_Room_Details], [UID], [Date_Start],[Date_End],[NumberOfRooms],[Total_Costs],[Confirm])\n"
                + "values (?,?,?,?,?,?,0)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, id_room);
            ps.setString(2, uid);
            ps.setString(3, dateS);
            ps.setString(4, dateE);
            ps.setInt(5, numOfRoom);
            ps.setLong(6, total * numOfRoom * DateProcessor.duration(dateS, dateE));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCost(int idRoom) {
        String query = "SELECT [Cost],[Discount] FROM [Room_Details]\n"
                + "where ID_Room_Details = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, idRoom);

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getInt(2));
                return (int) Math.ceil(rs.getInt(1) * (1 - rs.getInt(2) / 100) / 24000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void activate(int id, boolean check, String id_staff) {
        int ac;
        if (check) {
            ac = 0;
        } else {
            ac = 1;
        }
        String query = "update Booking set [Confirm] = " + ac + ", [Staff_Id] =  '" + id_staff + "' where [ID_booking] = " + id + " ";
        try {
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            st = conn.createStatement();

            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Booking_DAO b = new Booking_DAO();
//        b.getBooks("1");
//    }

}
