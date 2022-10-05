package com.group3.trividi.model;


public class Hotel_Details {
    private int id;
    private String name;
    private String des;
    private String image;
    private String phone;
    private String address;
    private int star;
    private boolean status;
    private String category;
    private String city;
    private int cost;
    private int discount;

    private int priority;
    public Hotel_Details(int id, String name, String des, String image, String phone, String address, int star, boolean status, String category, String city, int cost, int discount,int priority) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.image = image;
        this.phone = phone;
        this.address = address;
        this.star = star;
        this.status = status;
        this.category = category;
        this.city = city;
        this.cost = cost;
        this.discount = discount;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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