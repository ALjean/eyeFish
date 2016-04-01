package com.jean.util;

public class BaitSetting {

    private String settingName;
    private String description;

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

    public BaitSetting() {
	super();
    }

    public BaitSetting(String settingName, String description) {
	super();
	this.settingName = settingName;
	this.description = description;
    }

}
