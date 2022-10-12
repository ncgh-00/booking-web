package com.group3.trividi.model;

import java.util.Date;

public class Rate {
    private String fullname;
    private String UID;
    private int ID_Hotel;
    private String comment;
    private int stars;
    private Date date;
    private int id_rate;

    public Rate(String fullname, String UID, int ID_Hotel, String comment, int stars, Date date, int id_rate) {
        this.fullname = fullname;
        this.UID = UID;
        this.ID_Hotel = ID_Hotel;
        this.comment = comment;
        this.stars = stars;
        this.date = date;
        this.id_rate = id_rate;
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_rate() {
        return id_rate;
    }

    public void setId_rate(int id_rate) {
        this.id_rate = id_rate;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "fullname='" + fullname + '\'' +
                ", UID='" + UID + '\'' +
                ", ID_Hotel=" + ID_Hotel +
                ", comment='" + comment + '\'' +
                ", stars=" + stars +
                ", date=" + date +
                ", id_rate=" + id_rate +
                '}';
    }
}
