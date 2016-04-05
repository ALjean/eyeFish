package com.jean.entity;

import java.util.List;

import com.jean.util.BaitSetting;

public class Bait {

    private int baitId;
    private String baitName;
    private String description;

    private List<BaitSetting> baitSetting;
    private List<Integer> fishId;
    private List<DateHolder> dates;

    public int getBaitId() {
	return baitId;
    }

    public void setBaitId(int baitId) {
	this.baitId = baitId;
    }

    public String getBaitName() {
	return baitName;
    }

    public void setBaitName(String baitName) {
	this.baitName = baitName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<BaitSetting> getBaitSetting() {
	return baitSetting;
    }

    public void setBaitSetting(List<BaitSetting> baitSetting) {
	this.baitSetting = baitSetting;
    }

    public List<Integer> getFishId() {
	return fishId;
    }

    public void setFishId(List<Integer> fishId) {
	this.fishId = fishId;
    }

    public List<DateHolder> getDates() {
	return dates;
    }

    public void setDates(List<DateHolder> dates) {
	this.dates = dates;
    }

    public Bait() {
	super();
    }

    public Bait(int baitId, String baitName, String description, List<BaitSetting> baitSetting, List<Integer> fishId, List<DateHolder> dates) {
	super();
	this.baitId = baitId;
	this.baitName = baitName;
	this.description = description;
	this.baitSetting = baitSetting;
	this.fishId = fishId;
	this.dates = dates;
    }

   

}
