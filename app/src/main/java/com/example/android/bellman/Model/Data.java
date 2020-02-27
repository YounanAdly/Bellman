
package com.example.android.bellman.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("attractions")
    @Expose
    private List<Attraction> attractions;

    @SerializedName("events")
    @Expose
    private List<Event> events;

    @SerializedName("hot_spots")
    @Expose
    private List<Hotspots> hotSpots;

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Hotspots> getHotSpots() {
        return hotSpots;
    }

    public void setHotSpots(List<Hotspots> hotSpots) {
        this.hotSpots = hotSpots;
    }

}
