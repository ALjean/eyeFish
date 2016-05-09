package com.jean.entity;

import java.util.ArrayList;
import java.util.List;

public class Fish {

	private int id;
	private String name;
	private String description;
	private String fishType;
	private List<LivingArea> livingArea;
	private List<DayActivity> daysActivity;
	private List<FishSetting> fishSetting;
	private List<NibblePeriod> nibblePeriods;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<LivingArea> getLivingArea() {
		return livingArea;
	}

	public void setLivingArea(List<LivingArea> livingArea) {
		this.livingArea = livingArea;
	}

	public List<DayActivity> getDaysActivity() {
		return daysActivity;
	}

	public void setDaysActivity(List<DayActivity> daysActivity) {
		this.daysActivity = daysActivity;
	}

	public List<FishSetting> getFishSetting() {
		return fishSetting;
	}

	public void setFishSetting(List<FishSetting> fishSetting) {
		this.fishSetting = fishSetting;
	}

	public List<NibblePeriod> getNibbles() {
		return nibblePeriods;
	}

	public void setNibbles(List<NibblePeriod> nibbles) {
		this.nibblePeriods = nibbles;
	}

	public Fish() {
		this.daysActivity = new ArrayList<DayActivity>();
		this.livingArea = new ArrayList<LivingArea>();
		this.fishSetting = new ArrayList<FishSetting>();
		this.nibblePeriods = new ArrayList<NibblePeriod>();
	}

	public Fish(int id, String name, String description, String fishType, List<LivingArea> livingArea,
			List<DayActivity> daysActivity, List<FishSetting> fishSetting, List<NibblePeriod> nibbles) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.fishType = fishType;
		this.livingArea = livingArea;
		this.daysActivity = daysActivity;
		this.fishSetting = fishSetting;
		this.nibblePeriods = nibbles;
	}

	@Override
	public String toString() {
		return "Fish [id=" + id + ", name=" + name + ", description=" + description + ", fishType=" + fishType
				+ ", livingArea=" + livingArea + ", daysActivity=" + daysActivity + ", fishSetting=" + fishSetting
				+ ", nibblePeriods=" + nibblePeriods + "]";
	}

}
