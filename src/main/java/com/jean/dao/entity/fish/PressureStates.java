package com.jean.dao.entity.fish;

import com.jean.dao.entity.BaseEntityAudit;

import javax.persistence.*;

@Entity
@Table(name = "pressure_states")
public class PressureStates extends BaseEntityAudit {

    @Column(name = "value")
    private float value;

    @Column(name = "pressure_type")
    private String pressureType;

    @ManyToOne
    @JoinColumn(name = "fish_id")
    private Fish fish;

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getPressureType() {
        return pressureType;
    }

    public void setPressureType(String pressureType) {
        this.pressureType = pressureType;
    }
}
