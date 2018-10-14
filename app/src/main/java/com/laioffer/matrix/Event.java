package com.laioffer.matrix;

/**
 * Created by danningzhang on 9/10/18.
 */

public class Event {
    private String title;
    private String address;
    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Constructor
     */
    public Event(String title, String address, String description) {
        this.title = title;

        this.address = address;
        this.description = description;
    }

    /**
     * Getters for private attributes of Event class.
     */
    public String getTitle() { return this.title; }
    public String getAddress() { return this.address; }
    public String getDescription() { return this.description; }
}
