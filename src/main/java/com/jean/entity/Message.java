package com.jean.entity;

public class Message {

    private int id;
    
    private String locationMessage;
    
    private String hungryMessage;
    
    private String spawingMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationMessage() {
        return locationMessage;
    }

    public void setLocationMessage(String locationMessage) {
        this.locationMessage = locationMessage;
    }

    public String getHungryMessage() {
        return hungryMessage;
    }

    public void setHungryMessage(String hungryMessage) {
        this.hungryMessage = hungryMessage;
    }

    public String getSpawingMessage() {
        return spawingMessage;
    }

    public void setSpawingMessage(String spawingMessage) {
        this.spawingMessage = spawingMessage;
    }
}
