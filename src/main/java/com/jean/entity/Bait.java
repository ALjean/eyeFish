package com.jean.entity;

import java.util.List;

public class Bait {

    private int baitId;
    private String baitName;
    private List<BaitSetting> settings;

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

    public List<BaitSetting> getSettings() {
	return settings;
    }

    public void setSettings(List<BaitSetting> settings) {
	this.settings = settings;
    }

    @Override
    public String toString() {
	return "Bait [baitId=" + baitId + ", baitName=" + baitName + ", settings=" + settings + "]";
    }

    public Bait() {
	super();
    }

    public Bait(int baitId, String baitName, List<BaitSetting> settings) {
	super();
	this.baitId = baitId;
	this.baitName = baitName;
	this.settings = settings;
    }

}
