package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.Hotel_Category;
import com.group3.trividi.model.Hotel_Details;
import com.group3.trividi.model.Room_Details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Hotel_DAO {
    Connection conn = null; // Connect with SQL Server
    PreparedStatement ps = null; // Throw query statement to SQL Server
    ResultSet rs = null; // Receive the respond result of SQL Server
    Statement st = null;

    public Hotel_Details getHotel(String id) {
        Hotel_Details hd = null;
        String query = "select * from Hotel_Details where ID_Hotel = " + id + " ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
//                int id, String name, String des, String image, String phone, String address, int star,boolean status, String category, String city, int cost, int discount
                hd = new Hotel_Details(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getInt(12)
                );
            }
            System.out.println(hd);
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return hd;
    }

    public List<Hotel_Details> getHotels() {
        List<Hotel_Details> list = new ArrayList<>();
        String query = "select * from Hotel_Details where Status = 1 order by Cost asc ";
        try {
            // Open connection with SQL Server
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            ps = conn.prepareStatement(query);
            // Get the result of SQL Server ans store in rs
            rs = ps.executeQuery();

            // Add data in rs to ArrayList
            while (rs.next()) {
                //int id, String name, String image, double price, String title, String description
                list.add(new Hotel_Details(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getInt(12)
                ));
            }
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return list;
    }

    public List<Hotel_Details> getHotelsInHome() {
        String query = "select top 8 * from Hotel_Details where [Status] = 1 order by ID_Hotel ";

        return get(query);
    }

    public List<Room_Details> getRoomDetails(String id_hotel) {
        List<Room_Details> list = new ArrayList<>();
        String query = "select * from Room_Details where [Status] = 1 and ID_Hotel = " + id_hotel + " ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room_Details(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getBoolean(8)));

            }

            System.out.println(list.size() + "rooms");
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }

        return list;
    }

    public List<Room_Details> getAllRoomDetails(String id_hotel) {
        List<Room_Details> list = new ArrayList<>();
        String query = "select * from Room_Details where ID_Hotel = " + id_hotel + " ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room_Details(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getBoolean(8)));

            }
            System.out.println(list.size() + "rooms");
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }

        return list;
    }

    public void activate(int id, boolean check) {
        int ac;
        if (check) {
            ac = 0;
        } else {
            ac = 1;
        }
        String query = "update Hotel set [Status] = " + ac + " where [ID_Hotel] = " + id + " ";
        try {
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            st = conn.createStatement();

            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void activateRoom(int id, boolean check) {
        int active;
        if (check) {
            active = 0;
        } else {
            active = 1;
        }
        String query = "update Room_Details set [Status] = " + active + " where ID_Room_Details = " + id + " ";
        try {
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            st = conn.createStatement();

            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Hotel_Category> getCategory() {
        List<Hotel_Category> list = new ArrayList<>();
        String query = "select * from Hotel_Category ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Hotel_Category(rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }

        return list;
    }

    private List<Hotel_Details> get(String query) {
        List<Hotel_Details> list = new ArrayList<>();
        try {
            // Open connection with SQL Server
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            ps = conn.prepareStatement(query);
            // Get the result of SQL Server ans store in rs
            rs = ps.executeQuery();

            // Add data in rs to ArrayList
            while (rs.next()) {
                //int id, String name, String image, double price, String title, String description
                list.add(new Hotel_Details(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getInt(12)
                ));
            }
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return list;
    }

    public Hotel_Details getHotHotel() {
        Hotel_Details hh = null;
        String query = "select * from Hotel_Details\n" +
                "where ID_Hotel = (select top 1 ID_Hotel from (select ID_Hotel, Count(ID_Hotel) numbers from Manage_Booking b\n" +
                "group by ID_Hotel) c\n" +
                "where numbers = (select Max(c.numbers) from\n" +
                "(select ID_Hotel, Count(ID_Hotel) numbers from Manage_Booking b\n" +
                "group by ID_Hotel) c) )";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
//                int id, String name, String des, String image, String phone, String address, int star,boolean status, String category, String city, int cost, int discount
                hh = new Hotel_Details(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getInt(12)
                );
            }
            System.out.println(hh);
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return hh;
    }

    public List<Hotel_Details> searchHotels(String hotel, String city, String cate, int cost, String greater) {
        List list = null;
        String query = "";
        if (greater.equalsIgnoreCase("great")) query = "select * from Hotel_Details a\n" +
                "where a.Name like '%" + hotel + "%' and a.Category like '%" + cate + "'% and a.City like '%" + city + "%' and a.Cost > " + cost;
        else if (greater.equalsIgnoreCase("low")) query = "select * from Hotel_Details a\n" +
                "where a.Name like '%" + hotel + "%' and a.Category like '%" + cate + "'% and a.City like '%" + city + "%' and a.Cost < " + cost;
        else query = "select * from Hotel_Details a\n" +
                    "where a.Name like '%" + hotel + "%' and a.Category like '%" + cate + "'% and a.City like '%" + city + "%'";
        return get(query);
    }

    public static void main(String[] args) {
        Hotel_DAO d = new Hotel_DAO();
        d.getCategory();
    }

}

