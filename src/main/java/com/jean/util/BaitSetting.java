package com.jean.util;

import java.util.ArrayList;
import java.util.List;

import com.jean.entity.Bait;

public class BaitSetting {

    private int settingId;
    private String settingType;
    private String settingName;
    private String description;

    private List<Qualifier> qualifers;

    public int getSettingId() {
	return settingId;
    }

    public void setSettingId(int settingId) {
	this.settingId = settingId;
    }

    public String getSettingType() {
	return settingType;
    }

    public void setSettingType(String settingType) {
	this.settingType = settingType;
    }

    public String getSettingName() {
	return settingName;
    }

    public void setSettingName(String settingName) {
	this.settingName = settingName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<Qualifier> getQualifers() {
	return qualifers;
    }

    public void setQualifers(List<Qualifier> qualifers) {
	this.qualifers = qualifers;
    }

    public BaitSetting() {
	this.qualifers = new ArrayList<Qualifier>();
    }

    public BaitSetting(int settingId, String settingType, String settingName, String description, List<Qualifier> qualifers) {
	super();
	this.settingId = settingId;
	this.settingType = settingType;
	this.settingName = settingName;
	this.description = description;
	this.qualifers = qualifers;
    }

    @Override
    public String toString() {
	return "BaitSetting [settingId=" + settingId + ", settingType=" + settingType + ", settingName=" + settingName + ", description="
		+ description + ", qualifers=" + qualifers + "]";
    }

    
}
