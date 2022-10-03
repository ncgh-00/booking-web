package com.group3.trividi.model;

public class City {
    private int id;
    private String name;
    private String link_images;

    public City(int id, String name, String link_images) {
        this.id = id;
        this.name = name;
        this.link_images = link_images;
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

    public String getLink_images() {
        return link_images;
    }

    public void setLink_images(String link_images) {
        this.link_images = link_images;
    }


}