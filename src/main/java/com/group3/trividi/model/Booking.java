package com.group3.trividi.model;

import java.util.Date;

public class Booking {
    private int idBooking;
    private String uid;
    private String staffID;
    private String hotelName;
    private String roomName;
    private int numOfRoom;
    private Date dateStart;
    private Date dateEnd;
    private int totalCost;
    private boolean confirm;

    public Booking(int idBooking, String uid, String staffID, String hotelName, String roomName, int numOfRoom, Date dateStart, Date dateEnd, int totalCost, boolean confirm) {
        this.idBooking = idBooking;
        this.uid = uid;
        this.staffID = staffID;
        this.hotelName = hotelName;
        this.roomName = roomName;
        this.numOfRoom = numOfRoom;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.totalCost = totalCost;
        this.confirm = confirm;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
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
