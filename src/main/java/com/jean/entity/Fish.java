package com.jean.entity;

import java.util.List;

public abstract class Fish {

    private int id;
    private String name;
    private String description;
    private String fishType;
    private String livingArea;
    private List<FishParameter> fishParams;
    private List<FishNibble> nibbles;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFishType() {
        return fishType;
    }

    public void setFishType(String fishType) {
        this.fishType = fishType;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public List<FishParameter> getFishParams() {
        return fishParams;
    }

    public void setFishParams(List<FishParameter> fishParams) {
        this.fishParams = fishParams;
    }

    public List<FishNibble> getNibbles() {
        return nibbles;
    }

    public void setNibbles(List<FishNibble> nibbles) {
        this.nibbles = nibbles;
    }

    public abstract double hungryAnalyzer();

    public abstract String locationAnalyzer();
}
