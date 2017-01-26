package com.jean.dao.entity.bait;

import com.jean.dao.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bait_settings")
public class BaitSetting extends BaseEntity {


    @Column(name = "setting_name")
    private String name;

    @Column(name = "setting_type")
    private String type;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "bait_id")
    private Bait bait;


    @OneToMany(mappedBy = "baitSetting", cascade = CascadeType.ALL)
    private List<Qualifier> qualifers;


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

    public Bait getBait() {
        return bait;
    }

    public void setBait(Bait bait) {
        this.bait = bait;
    }

    public List<Qualifier> getQualifers() {
        return qualifers;
    }

    public void setQualifers(List<Qualifier> qualifers) {
        this.qualifers = qualifers;
    }

    public BaitSetting() {
    }

    public BaitSetting(Long settingId, String type, String name, String description, List<Qualifier> qualifers) {
        this.id = settingId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.qualifers = qualifers;
    }

    @Override
    public String toString() {
        return "BaitSetting [settingId=" + id + ", type=" + type + ", settingName=" + name + ", description="
                + description + ", qualifers=" + qualifers + "]";
    }


}