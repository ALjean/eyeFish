package com.jean.entity.bait;

import java.util.ArrayList;
import java.util.List;

public class Bait {

	private int baitId;
	private String baitName;
	private String baitType;
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

	public String getBaitType() {
		return baitType;
	}

	public void setBaitType(String baitType) {
		this.baitType = baitType;
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
		this.baitSetting = new ArrayList<BaitSetting>();
		this.fishId = new ArrayList<Integer>();
		this.dates = new ArrayList<DateHolder>();
	}

	public Bait(int baitId, String baitName, String baitType, String description, List<BaitSetting> baitSetting, List<Integer> fishId,
			List<DateHolder> dates) {
		super();
		this.baitId = baitId;
		this.baitName = baitName;
		this.baitType = baitType;
		this.description = description;
		this.baitSetting = baitSetting;
		this.fishId = fishId;
		this.dates = dates;
	}

	@Override
	public String toString() {
		return "Bait [baitId=" + baitId + ", baitName=" + baitName + ", description=" + description + ", baitSetting="
				+ baitSetting + ", fishId=" + fishId + ", dates=" + dates + "]";
	}

}
