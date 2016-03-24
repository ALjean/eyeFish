package com.jean.entity;

import com.jean.enums.FishTypes;
import com.jean.enums.LiveArea;

import java.util.List;

public class Fish {

    private int id;
    private String name;
    private String description;
    private FishTypes fishType;
    private LiveArea livingArea;
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

    public FishTypes getFishType() {
        return fishType;
    }

    public void setFishType(FishTypes fishType) {
        this.fishType = fishType;
    }

    public LiveArea getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(LiveArea livingArea) {
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
}
