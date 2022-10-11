package com.group3.trividi.model;

public class Location {
    String name;
    String link;
    String lng;
    String lat;

    int id_hotel;

    public Location(String name, String link, String lng, String lat, int id_hotel) {
        this.name = name;
        this.link = link;
        this.lng = lng;
        this.lat = lat;
        this.id_hotel = id_hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", id_hotel=" + id_hotel +
                '}';
    }
}
