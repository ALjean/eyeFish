package com.jean.dao.entity.fish;

import com.jean.dao.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jean on 09.05.16.
 */

@Entity
@Table(name = "living_area")
public class LivingArea extends BaseEntity implements Serializable {


    @ManyToOne
    @JoinColumn(name = "fish_id")
    private Fish fish;

    @Column(name = "area_name")
    private String areaName;

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public LivingArea() {
    }

    public LivingArea(long id, Fish fish, String areaName) {
        this.id = id;
        this.fish = fish;
        this.areaName = areaName;
    }


}
