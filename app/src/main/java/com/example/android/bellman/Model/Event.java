package com.example.android.bellman.Model;

import java.util.ArrayList;

public class Event {

    private String name;

    private ArrayList<Categories> categories;

    private ArrayList<String> photos;

    public Event() {
    }

    public Event(String name, ArrayList<Categories> categories, ArrayList<String> photos) {
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
