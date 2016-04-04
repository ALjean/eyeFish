package com.jean.entity;

import java.util.List;

import com.jean.util.BaitSetting;

public class Bait {

	private int baitId;
	private String baitName;
	private String description;

	private List<BaitSetting> baitSetting;

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

}
