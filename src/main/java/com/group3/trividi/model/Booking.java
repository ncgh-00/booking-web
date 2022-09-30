package com.group3.trividi.model;

import java.util.Date;

public class Booking {
    private int id;
    private int id_room_details;
    private String uid;
    private String id_staff;
    private Date dateStart;
    private Date dateEnd;
    private int numOfRoom;
    private int totalCost;
    private boolean confirm;

    public Booking(int id, int id_room_details, String uid, String id_staff, Date dateStart, Date dateEnd, int numOfRoom,int totalCost, boolean confirm) {
        this.id = id;
        this.id_room_details = id_room_details;
        this.uid = uid;
        this.id_staff = id_staff;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.numOfRoom = numOfRoom;
        this.totalCost = totalCost;
        this.confirm = confirm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_room_details() {
        return id_room_details;
    }

    public void setId_room_details(int id_room_details) {
        this.id_room_details = id_room_details;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId_staff() {
        return id_staff;
    }

    public void setId_staff(String id_staff) {
        this.id_staff = id_staff;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }
}
