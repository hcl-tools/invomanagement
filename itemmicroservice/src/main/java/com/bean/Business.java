package com.bean;

public class Business {

    private int id;
    private String title;
    private String address;

    public Business() {
    }

    public Business(int id, String title, String address) {
        this.id = id;
        this.title = title;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
