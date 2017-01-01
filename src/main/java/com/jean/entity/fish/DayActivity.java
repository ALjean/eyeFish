package com.jean.entity.fish;

import com.jean.entity.BaseEntry;

import javax.persistence.*;

/**
 * Created by jean on 09.05.16.
 */
@Entity
@Table(name = "days_activity")
public class DayActivity extends BaseEntry {


    @ManyToOne
    @JoinColumn(name = "fish_id")
    private Fish fish;

    @Column(name = "activity_name")
    private String activityName;

    public DayActivity(){

    }

    public DayActivity(int id, Fish fish, String activityName) {
        this.id = id;
        this.fish = fish;
        this.activityName = activityName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
