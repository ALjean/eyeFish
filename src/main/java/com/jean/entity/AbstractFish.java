package com.jean.entity;

import java.util.List;
import com.jean.analyzers.weather.AnalyzerResultObject;

public abstract class AbstractFish {

    private int id;
    private String name;
    private String description;
    private String fishType;
    private String livingArea;
    private AnalyzerResultObject analyzerObject;
    private List<FishParameters> fishParams;

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

    public AnalyzerResultObject getAnalyzerObject() {
        return analyzerObject;
    }

    public void setAnalyzerObject(AnalyzerResultObject analyzerObject) {
        this.analyzerObject = analyzerObject;
    }

    public List<FishParameters> getFishParams() {
        return fishParams;
    }

    public void setFishParams(List<FishParameters> fishParams) {
        this.fishParams = fishParams;
    }

    public abstract double hungryAnalyzer();

    public abstract String locationAnalyzer();
}
