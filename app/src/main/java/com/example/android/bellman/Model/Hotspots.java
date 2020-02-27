package com.example.android.bellman.Model;


import com.example.android.bellman.Model.Categories;

import java.util.ArrayList;

public class Hotspots {

    private String name;

    private ArrayList<Categories> categories ;

    private ArrayList<String> photos;

    public Hotspots(){};

    public Hotspots(String name,ArrayList<Categories> categories,ArrayList<String> photos) {
        this.name = name;
        this.categories = categories;
        this.photos = photos;
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<String> photos) {
        this.photos = photos;
    }

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
