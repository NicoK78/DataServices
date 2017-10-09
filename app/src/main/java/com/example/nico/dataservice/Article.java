package com.example.nico.dataservice;

/**
 * Created by nico on 08/10/2017.
 */

public class Article {

    private int id;
    private String title;
    private String City;
    private String content;

    public Article(int id, String title, String city, String content) {
        this.id = id;
        this.title = title;
        City = city;
        this.content = content;
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

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
