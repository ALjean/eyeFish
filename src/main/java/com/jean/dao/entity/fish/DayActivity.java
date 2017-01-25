package com.jean.dao.entity.fish;


import com.jean.dao.entity.BaseEntityAudit;

import javax.persistence.*;

/**
 * Created by jean on 09.05.16.
 */
@Entity
@Table(name = "days_activity")
public class DayActivity extends BaseEntityAudit {


    @ManyToOne
    @JoinColumn(name = "fish_id")
    private Fish fish;

    @Column(name = "activity_name")
    private String activityName;

    public DayActivity(){

    }

    public DayActivity(Long id, Fish fish, String activityName) {
        this.id = id;
        this.fish = fish;
        this.activityName = activityName;
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
