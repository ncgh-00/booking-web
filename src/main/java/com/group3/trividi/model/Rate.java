package com.group3.trividi.model;

import java.util.Date;

public class Rate {
    private String fullname;
    private String UID;
    private int ID_Hotel;
    private String comment;
    private int NumberOfStars;
    private Date date;

    public Rate(String fullname, String UID, int ID_Hotel, String comment, int numberOfStars, Date date) {
        this.fullname = fullname;
        this.UID = UID;
        this.ID_Hotel = ID_Hotel;
        this.comment = comment;
        NumberOfStars = numberOfStars;
        this.date = date;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public int getID_Hotel() {
        return ID_Hotel;
    }

    public void setID_Hotel(int ID_Hotel) {
        this.ID_Hotel = ID_Hotel;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNumberOfStars() {
        return NumberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        NumberOfStars = numberOfStars;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
