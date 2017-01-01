package com.jean.entity.bait;

import com.jean.entity.BaseEntry;

import javax.persistence.Column;
import javax.persistence.Table;


@Table(name = "qualifiers")
public class Qualifier extends BaseEntry {


    @Column(name = "param_name")
    private String paramName;

    private BaitSetting baitSetting;

    @Column(name = "min_level")
    private float min;

    @Column(name = "max_level")
    private float max;


    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public BaitSetting getBaitSetting() {
        return baitSetting;
    }

    public void setBaitSetting(BaitSetting baitSetting) {
        this.baitSetting = baitSetting;
    }

    public Qualifier() {
    }

    public Qualifier(int id, String paramName, float min, float max) {
        this.id = id;
        this.paramName = paramName;
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "Qualifier [qual_id=" + id + ", paramName=" + paramName + ", min=" + min + ", max=" + max + "]";
    }

}
