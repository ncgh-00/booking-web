package com.group3.trividi.model;

public class Account {

    private String UID;
    private int idHotel;
    private int roleID;
    private String username;
    private String hashPassword;
    private String fullname;
    private String email;
    private String phone;
    private boolean status = true;

    public Account(String UID, int idHotel, int roleID, String username, String hashPassword, String fullname, String email, String phone, boolean status) {
        this.UID = UID;
        this.idHotel = idHotel;
        this.roleID = roleID;
        this.username = username;
        this.hashPassword = hashPassword;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
