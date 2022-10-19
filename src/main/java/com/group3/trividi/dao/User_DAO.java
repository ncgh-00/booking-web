package com.group3.trividi.dao;


import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.Account;
import com.group3.trividi.model.Account_Info;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.NameGenerator;
import com.sun.corba.se.spi.activation.InitialNameServicePackage.NameAlreadyBound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {
    Connection conn = null; // Connect with SQL Server
    PreparedStatement ps = null; // Throw query statement to SQL Server
    ResultSet rs = null; // Receive the respond result of SQL Server
    Statement st = null;

    public boolean checkUsername(String username) {
        boolean check = false;
        String query = "select * from Account\n"
                + "where Username = '" + username + "'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
            }

        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }

        return check;
    }

    public boolean checkEmail(String mail) {
        boolean check = false;
        String query = "select * from Account\n"
                + "where Email = '" + mail + "'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
            }

        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return check;
    }

    public boolean checkPhone(String phone) {
        boolean check = false;
        String query = "select * from Account\n"
                + "where Phone = '" + phone + "'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                check = true;
            }

        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }

        return check;
    }

    public void insert(int roleid, String username, String password, String fullname, String email, String phone) {
        String query = "insert into Account(Role_ID,Username,Hash_password,FullName,Email,Phone,Status) \n"
                + "values (?,?,?,?,?,?,'1')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,roleid);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4,"N'"+ fullname +"'");
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.executeUpdate();
            System.out.println("dang ky duoc roi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insert(String email,String name){
        String query = "insert into Account(Role_ID,Username,Hash_password,Fullname,Email,Status) \n"
                + "values ('3',?,?,?,?,'1')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2,HashPassword.getHashedPassword(HashPassword.generatePassword(8)));
            ps.setString(3,"N'"+ name+"'");
            ps.setString(4, email);
            ps.executeUpdate();
            System.out.println("dang ky duoc roi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account getUSer(String username, String pass) {
        Account acc;
        String query = "select a.UID, a.ID_Hotel, a.Role_ID, a.Username, a.Hash_password, a.FullName, a.Email, a.Phone, a.Status \n" +
                "from Account as a\n" +
                "where a.Username = '" + username + "' and a.Hash_password = '" + pass + "'";
        return get(query);
    }

    public Account getUSer(String UID) {
        Account acc;
        String query = "select a.UID, a.ID_Hotel, a.Role_ID, a.Username, a.Hash_password, a.FullName, a.Email, a.Phone, a.Status \n" +
                "from Account as a\n" +
                "where a.UID = '" + UID + "'";
        return get(query);
    }
    public Account getUserByEmail(String email){
        Account acc;
        String query = "select a.UID, a.ID_Hotel, a.Role_ID, a.Username, a.Hash_password, a.FullName, a.Email, a.Phone, a.Status \n" +
                "from Account as a\n" +
                "where a.Email = '" + email + "'";
        return get(query);
    }

    public void resetPassword(String password, String email) {
        String sql = "update [Account] set [Hash_password] = '" + HashPassword.getHashedPassword(password) + "' where Email = '" + email + "'";
        try {
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            st = conn.createStatement();

            st.executeUpdate(sql);
            System.out.println("reset success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Account get(String query){
        Account acc;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return acc = new Account(rs.getString(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getBoolean(9));
            }
//            System.out.println(query);
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return null;
    }

    public void editUser(String id, String password, String name, String phone, String email) {
        String sql = "update [Account] set ";

        if (!password.isEmpty()) {
            sql += " [Hash_password] = '" + HashPassword.getHashedPassword(password) + "',";
        }
        if (!name.isEmpty()) {
            sql += " [FullName] = N'" + name + "',";
        }
        if (!email.isEmpty()) {
            sql += " [Email] = '" + email + "',";
        }
        if (!phone.isEmpty()) {
            sql += " [Phone] = '" + phone + "',";
        }

        sql = sql.substring(0, sql.length() - 1);
        sql += " where [UID] = '" + id + "'";
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

    public void addHotelforStaff(String staffid, String idhotel) {
        String sql = "update [Account] set [ID_Hotel] = "+idhotel+" where [UID] = '" + staffid + "'";
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

    public List<Account_Info> getUsersInfo() {
        String query = "select * from Account_Info order by Status, [UID] desc";
        return getAccInfo(query);
    }

    public List<Account_Info> getStaff() {
        String query = "select * from Account_Info where [Role_Id] = 2 order by [UID] desc";
        return getAccInfo(query);
    }

    public  List<Account_Info> searchUser(String username) {
        String query = "select * from Account_Info \n" +
                "where [Username] like '%"+ username +"%'";
        System.out.println(query);
        return getAccInfo(query);
    }

    private List<Account_Info> getAccInfo(String query) {
        List<Account_Info> list = new ArrayList<>();

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
                list.add(new Account_Info(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getBoolean(10),rs.getInt(1), rs.getString(11), rs.getString(12)
                ));
            }
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return list;
    }

    public void activate(String uid, boolean check) {
        int status;
        if (check) {
            status = 0;
        } else {
            status = 1;
        }
        String query = "update [Account_Info] set [Status] = " + status + " where [UID] = '" + uid + "' ";
        try {
            conn = new DBContext().getConnection();
            // Throw the query statement to SQL Server
            st = conn.createStatement();

            st.executeUpdate(query);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void editRole(String id, String role_id) {
        String sql = "update [Account] set Role_ID = "+role_id+" where UID = '"+id+"'";

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

    public String getIDUser() {
        String id = "";
        String query = "select Top 1 UID from Account_Info order by [UID] desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Fail, please contact to admin!!");
        }
        return id;
    }





    public static void main(String[] args) {
        User_DAO u = new User_DAO();


    }


}
