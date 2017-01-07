package com.jean.entity.bait;

import com.jean.entity.BaseEntry;
import com.jean.entity.fish.Fish;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "baits")
public class Bait extends BaseEntry {


    @Column(name = "bait_name")
    private String name;

    @Column(name = "bait_type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "start_period")
    private Date startPeriod;

    @Column(name = "end_period")
    private Date endPeriod;


    @OneToMany(mappedBy = "bait", cascade = CascadeType.ALL)
    private List<BaitSetting> baitSettings;



    @ManyToMany(mappedBy = "baits")
    private List<Fish> fishes;

    @OneToMany(mappedBy = "bait")
    private List<DateHolder> dates;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BaitSetting> getBaitSettings() {
        return baitSettings;
    }

    public void setBaitSettings(List<BaitSetting> baitSettings) {
        this.baitSettings = baitSettings;
    }

    public List<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(List<Fish> fishes) {
        this.fishes = fishes;
    }

    public List<DateHolder> getDates() {
        return dates;
    }

    public void setDates(List<DateHolder> dates) {
        this.dates = dates;
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Bait() {
    }

    public Bait(Long id, String baitName, String baitType, String description, List<BaitSetting> baitSettings, List<Fish> fishes,
                List<DateHolder> dates) {
        this.id = id;
        this.name = baitName;
        this.type = baitType;
        this.description = description;
        this.baitSettings = baitSettings;
        this.fishes = fishes;
        this.dates = dates;
    }


}
