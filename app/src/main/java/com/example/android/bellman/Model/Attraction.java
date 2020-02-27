package com.example.android.bellman.Model;


import java.util.ArrayList;

public class Attraction {

    String name;

    ArrayList<Categories> categories;

    ArrayList<String> photos;

    public Attraction(){}
    public Attraction(String name, ArrayList<Categories> categories, ArrayList<String> photos) {
        this.name = name;
        this.categories = categories;
        this.photos = photos;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }
}
