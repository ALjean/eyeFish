package com.jean.entity.fish;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jean.entity.BaseEntity;
import com.jean.entity.BaseEntityAudit;
import com.jean.entity.bait.Bait;

import javax.persistence.*;

@Entity
@Table(name = "fishes")
public class Fish extends BaseEntityAudit {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "fish_type")
    private String fishType;


//    private Map<String, Double> pressureS

    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<LivingArea> livingAreas;


    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<DayActivity> daysActivity;

    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FishSetting> fishSettings;

    @OneToMany(mappedBy = "fish", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<NibblePeriod> nibblePeriods;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "baits_to_fishes",
            joinColumns = @JoinColumn(name = "fish_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bait_id", referencedColumnName = "id"))
    private List<Bait> baits;


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

    /*public Map<String, Double> getPressureStates() {
        return pressureStates;
    }

    public void setPressureStates(Map<String, Double> pressureStates) {
        this.pressureStates = pressureStates;
    }*/

    public Set<LivingArea> getLivingAreas() {
        return livingAreas;
    }

    public void setLivingAreas(Set<LivingArea> livingAreas) {
        this.livingAreas = livingAreas;
    }

    public Set<DayActivity> getDaysActivity() {
        return daysActivity;
    }

    public void setDaysActivity(Set<DayActivity> daysActivity) {
        this.daysActivity = daysActivity;
    }

    public Set<FishSetting> getFishSettings() {
        return fishSettings;
    }

    public void setFishSettings(Set<FishSetting> fishSettings) {
        this.fishSettings = fishSettings;
    }

    public Set<NibblePeriod> getNibblePeriods() {
        return nibblePeriods;
    }

    public void setNibblePeriods(Set<NibblePeriod> nibblePeriods) {
        this.nibblePeriods = nibblePeriods;
    }

    public Fish() {
        this.daysActivity = new HashSet<>();
        this.livingAreas = new HashSet<>();
        this.fishSettings = new HashSet<>();
        this.nibblePeriods = new HashSet<>();
/*        this.pressureStates = new HashMap<>();

        pressureStates.put(PressureStates.IS_STABILITY.name(), null);
        pressureStates.put(PressureStates.IS_STABILITY_LOW.name(), null);
        pressureStates.put(PressureStates.IS_STABILITY_HIGH.name(), null);
        pressureStates.put(PressureStates.IS_DOWN.name(), null);
        pressureStates.put(PressureStates.IS_RISE.name(), null);*/
    }

    public Fish(Long id, String name, String description, String fishType, Set<LivingArea> livingAreas,
                Set<DayActivity> daysActivity, Set<FishSetting> fishSetting, Set<NibblePeriod> nibbles) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fishType = fishType;
        this.livingAreas = livingAreas;
        this.daysActivity = daysActivity;
        this.fishSettings = fishSetting;
        this.nibblePeriods = nibbles;
    }


}
