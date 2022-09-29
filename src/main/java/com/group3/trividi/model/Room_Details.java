package com.group3.trividi.model;

public class Room_Details {
    private int id;
    private int id_hotel;
    private String name;
    private String images;
    private String des;
    private int cost;
    private int discount;

    public Room_Details(int id, int id_hotel, String name, String images, String des, int cost, int discount) {
        this.id = id;
        this.id_hotel = id_hotel;
        this.name = name;
        this.images = images;
        this.des = des;
        this.cost = cost;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
