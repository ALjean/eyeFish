package com.jean.entity;

/**
 * Created by jean on 09.05.16.
 */
public class DayActivity {

    private int id;
    private int fishId;
    private String activityName;

    public DayActivity(){

    }

    public DayActivity(int id, int fishId, String activityName) {
        this.id = id;
        this.fishId = fishId;
        this.activityName = activityName;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
