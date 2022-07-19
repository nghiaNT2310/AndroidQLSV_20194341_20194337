package com.example.androidqlsv_20194341_20194337;

public class ItemModel {
    private String name;
    private String id;
    private String email;
    private String date;

    public ItemModel(String name, String id, String email, String date) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
