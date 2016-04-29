package com.jean.entity;

import com.jean.enums.DaysActivity;
import com.jean.enums.FishTypes;
import com.jean.enums.LiveArea;

import java.util.List;

public class Fish {

	private int id;
	private String name;
	private String description;
	private FishTypes fishType;
	private LiveArea livingArea;
	private DaysActivity daysActivity;
	private List<FishSetting> fishSetting;
	private List<NibblePeriod> nibbles;

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

	public FishTypes getFishType() {
		return fishType;
	}

	public void setFishType(FishTypes fishType) {
		this.fishType = fishType;
	}

	public LiveArea getLivingArea() {
		return livingArea;
	}

	public void setLivingArea(LiveArea livingArea) {
		this.livingArea = livingArea;
	}

	public List<FishSetting> getFishSetting() {
		return fishSetting;
	}

	public void setFishSetting(List<FishSetting> fishSetting) {
		this.fishSetting = fishSetting;
	}

	public List<NibblePeriod> getNibbles() {
		return nibbles;
	}

	public void setNibbles(List<NibblePeriod> nibbles) {
		this.nibbles = nibbles;
	}

	public DaysActivity getDaysActivity() {
		return daysActivity;
	}

	public void setDaysActivity(DaysActivity daysActivity) {
		this.daysActivity = daysActivity;
	}

	@Override
	public String toString() {
		return "Fish [id=" + id + ", name=" + name + ", description=" + description + ", fishType=" + fishType
				+ ", livingArea=" + livingArea + ", daysActivity=" + daysActivity + ", fishSetting=" + fishSetting
				+ ", nibbles=" + nibbles + "]";
	}

}
