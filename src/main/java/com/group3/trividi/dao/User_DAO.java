package com.group3.trividi.dao;


import com.group3.trividi.context.DBContext;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.HashPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public void insert(String username, String password, String fullname, String email, String phone) {
        String query = "insert into Account(Role_ID,Username,Hash_password,FullName,Email,Phone,Status) \n"
                + "values ('3',?,?,?,?,?,'1')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, email);
            ps.setString(5, phone);
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
            ps.setString(2,HashPassword.generatePassword(8));
            ps.setString(3, name);
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
    private Account get (String query){
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
            sql += " [FullName] = '" + name + "',";
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


//
//    public static void main(String[] args) {
//        User_DAO u = new User_DAO();
//        Account a = u.getUSer("huyne", HashPassword.getHashedPassword("123456"));
//        if (a != null){
//            System.out.println(a.getFullname());
//        } else System.out.println("cac");
//    }
}
