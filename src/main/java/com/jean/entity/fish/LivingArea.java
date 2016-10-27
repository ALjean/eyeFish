package com.jean.entity.fish;

/**
 * Created by jean on 09.05.16.
 */
public class LivingArea {

        private int id;
        private int fishId;
        private String areaName;

    public LivingArea(){}

    public LivingArea(int id, int fishId, String areaName) {
        this.id = id;
        this.fishId = fishId;
        this.areaName = areaName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
