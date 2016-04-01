package com.jean.entity;

import java.util.List;

import com.jean.util.Qualifier;

public class BaitSetting {

    private int settingId;
    private String settingName;
    private String description;
    private List<Qualifier> qualifiers;

    public int getSettingId() {
	return settingId;
    }

    public void setSettingId(int settingId) {
	this.settingId = settingId;
    }

    public String getSettingName() {
	return settingName;
    }

    public void setSettingName(String settingName) {
	this.settingName = settingName;
    }

    public List<Qualifier> getQualifiers() {
	return qualifiers;
    }

    public void setQualifiers(List<Qualifier> qualifiers) {
	this.qualifiers = qualifiers;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return "BaitSetting [settingId=" + settingId + ", settingName=" + settingName + ", description=" + description + ", qualifiers=" + qualifiers
		+ "]";
    }

    public BaitSetting() {
	super();
    }

    public BaitSetting(int settingId, String settingName, String description, List<Qualifier> qualifiers) {
	super();
	this.settingId = settingId;
	this.settingName = settingName;
	this.description = description;
	this.qualifiers = qualifiers;
    }

}
