package com.group3.trividi.model;

public class Account_Info extends Account {

    private int id;
    private String roleName;
    private String hotelManage;

    public Account_Info(String UID, int idHotel, int roleID, String username, String hashPassword, String fullname, String email, String phone, boolean status, int id, String roleName, String hotelManage) {
        super(UID, idHotel, roleID, username, hashPassword, fullname, email, phone, status);
        this.id = id;
        this.roleName = roleName;
        this.hotelManage = hotelManage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getHotelManage() {
        return hotelManage;
    }

    public void setHotelManage(String hotelManage) {
        this.hotelManage = hotelManage;
    }

    


}
