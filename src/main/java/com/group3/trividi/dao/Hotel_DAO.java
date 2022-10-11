package com.group3.trividi.dao;

import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.Hotel_Category;
import com.group3.trividi.model.Hotel_Details;
import com.group3.trividi.model.Location;
import com.group3.trividi.model.Room_Details;

import javax.servlet.http.Part;
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
                        rs.getInt(12),
                        rs.getInt(13)
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
        String query = "select * from Hotel_Details order by Priority asc ";

        return get(query);
    }

    public List<Hotel_Details> getHotelsInHome() {
        String query = "select top 8 * from Hotel_Details where [Status] = 1 order by [Priority] ";

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
        String query = "select * from Room_Details where ID_Hotel = " + id_hotel + " order by [Id_Room_Details] desc";
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
                        rs.getInt(12),
                        rs.getInt(13)
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
        String query = "select * from Hotel_Details\n"+
        "where ID_Hotel = (select top 1 ID_Hotel from (select ID_Hotel, Count(ID_Hotel) numbers from Manage_Booking b\n"+
        "where b.Confirm = 1\n"+
        "group by ID_Hotel ) c\n"+
        "where numbers = (select Max(c.numbers) from\n"+
                "(select ID_Hotel, Count(ID_Hotel) numbers from Manage_Booking b\n"+
                        "where b.Confirm = 1\n"+
                        "group by ID_Hotel ) c) )\n";
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
                        rs.getInt(12),
                        rs.getInt(13)
                );
            }
            System.out.println(hh);
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return hh;
    }

    public List<Hotel_Details> searchHotels(String hotel, String city, String cate) {
        List list = null;
        String query = "select * from Hotel_Details a\n" +
                    "where a.Name like '%" + hotel + "%' and a.Category like '%" + cate + "%' and a.City like '%" + city + "%'";
        System.out.println(query);
        return get(query);
    }

    public void editHotel(String id, String name, String des, String category, String phone, String address, String numOfStar, String city, String fileName) {
//        String img = image;

        String sql = "update [Hotel] set ";

        if (!name.isEmpty()) {
            sql += " [Name] = '" + name + "',";
        }
        if (!des.isEmpty()) {
            sql += " [Description] = '" + des + "',";
        }
        if(!category.isEmpty()){
            sql += "[ID_Category] = '" + category +"',";
        }
        if (!phone.isEmpty()) {
            sql += " [Phone] = '" + phone + "',";
        }
        if (!address.isEmpty()) {
            sql += " [Address] = '" + address + "',";
        }
        if (!numOfStar.isEmpty()) {
            sql += " [NumberOfStars] = " + numOfStar + ",";
        }
        if (!fileName.isEmpty()) {
            sql += " [Image] = 'images/" + fileName + "',";
        }
        if (!city.isEmpty()) {
            sql += " [ID_City] = " + city + ",";
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += " where [ID_Hotel] = '" + id + "'";
        System.out.println(sql);

        try {
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            st = conn.createStatement();

            st.executeUpdate(sql);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editRoom(String id, String name,String des, String cost, String discount, String image) {
        String sql = "update [Room_Details] set ";

        if (!name.isEmpty()) {
            sql += " [Name] = '" + name + "',";
        }
        if (!des.isEmpty()) {
            sql += " [Description] = '" + des + "',";
        }
        if(!cost.isEmpty()){
            sql += "[Cost] = '" + cost +"',";
        }
        if (!discount.isEmpty()) {
            sql += " [Discount] = '" + discount + "',";
        }
        if (!image.isEmpty()) {
            sql += " Image = 'images/" + image + "',";
        }

        sql = sql.substring(0, sql.length() - 1);
        sql += " where [ID_Room_Details] = '" + id + "'";
        System.out.println(sql);

        try {
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            st = conn.createStatement();

            st.executeUpdate(sql);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addRoom(String id_hotel, String name, String image, String description, String cost, String discount) {
        String query = "insert into Room_Details(ID_Hotel,[Name],[Image],[Description],Cost,Discount,Status) \n"
                + "values (?,?,?,?,?,?,'1')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id_hotel);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setString(4, description);
            ps.setString(5, cost);
            ps.setString(6, discount);
            ps.executeUpdate();
            System.out.println("add duoc roi ne");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }


    public void editPriority(String id, String priority) {
        String sql = "update [Hotel_Details] set Priority = "+priority+" where ID_Hotel = "+id;

        System.out.println(sql);

        try {
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            st = conn.createStatement();

            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Location> getMaps(){
        List<Location> list = new ArrayList<>();
        String sql = "select * from Location_map";
        try {
            // Open connection with SQL Server
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            ps = conn.prepareStatement(sql);
            // Get the result of SQL Server ans store in rs
            rs = ps.executeQuery();

            // Add data in rs to ArrayList
            while (rs.next()) {
                //int id, String name, String image, double price, String title, String description
                list.add(new Location(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
            }
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }

        return list;
    }


    public static void main(String[] args) {
        Hotel_DAO dao = new Hotel_DAO();

        for(Location l : dao.getMaps()){
            System.out.println(","+l.getLat());
        }
    }
}

