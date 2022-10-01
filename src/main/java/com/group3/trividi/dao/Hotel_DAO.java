package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
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
        String query = "select * from Hotel_Details where ID_Hotel = "+ id + " ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
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
        int i = 0;
        List<Hotel_Details> list = new ArrayList<>();
        String query = "select * from Hotel_Details order by ID_Hotel";
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
                i++;
                if (i == 8) {
                    break;
                }
            }
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return list;
    }

    public List<Room_Details> getRoomDetails(String id_hotel) {
        List<Room_Details> list = new ArrayList<>();
        String query = "select * from Room_Details where ID_Hotel = "+ id_hotel +" ";
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
                        rs.getInt(7)));

            }
            System.out.println(list.size() + "rooms");
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }

        return list;
    }



    }

