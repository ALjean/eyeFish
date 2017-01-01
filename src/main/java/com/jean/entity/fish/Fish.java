package com.jean.entity.fish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jean.entity.BaseEntry;
import com.jean.enums.PressureStates;

public class Fish extends BaseEntry {


	private String name;
	private String description;
	private String fishType;
	private Map<String, Double> pressureStates;
	private List<LivingArea> livingAreas;
	private List<DayActivity> daysActivity;
	private List<FishSetting> fishSettings;
	private List<NibblePeriod> nibblePeriods;


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

	public Map<String, Double> getPressureStates() {
		return pressureStates;
	}

	public void setPressureStates(Map<String, Double> pressureStates) {
		this.pressureStates = pressureStates;
	}

	public List<NibblePeriod> getNibblePeriods() {
		return nibblePeriods;
	}

	public void setNibblePeriods(List<NibblePeriod> nibblePeriods) {
		this.nibblePeriods = nibblePeriods;
	}

	public List<LivingArea> getLivingArea() {
		return livingAreas;
	}

	public void setLivingArea(List<LivingArea> livingAreas) {
		this.livingAreas = livingAreas;
	}

	public List<DayActivity> getDaysActivity() {
		return daysActivity;
	}

	public void setDaysActivity(List<DayActivity> daysActivity) {
		this.daysActivity = daysActivity;
	}

	public List<FishSetting> getFishSetting() {
		return fishSettings;
	}

	public void setFishSetting(List<FishSetting> fishSettings) {
		this.fishSettings = fishSettings;
	}

	public List<NibblePeriod> getNibbles() {
		return nibblePeriods;
	}

	public void setNibbles(List<NibblePeriod> nibbles) {
		this.nibblePeriods = nibbles;
	}

	public Fish() {
		this.daysActivity = new ArrayList<>();
		this.livingAreas = new ArrayList<>();
		this.fishSettings = new ArrayList<>();
		this.nibblePeriods = new ArrayList<>();
		this.pressureStates = new HashMap<>();

		pressureStates.put(PressureStates.IS_STABILITY.name(), null);
		pressureStates.put(PressureStates.IS_STABILITY_LOW.name(), null);
		pressureStates.put(PressureStates.IS_STABILITY_HIGH.name(), null);
		pressureStates.put(PressureStates.IS_DOWN.name(), null);
		pressureStates.put(PressureStates.IS_RISE.name(), null);
	}

	public Fish(int id, String name, String description, String fishType, List<LivingArea> livingAreas,
			List<DayActivity> daysActivity, List<FishSetting> fishSetting, List<NibblePeriod> nibbles) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.fishType = fishType;
		this.livingAreas = livingAreas;
		this.daysActivity = daysActivity;
		this.fishSettings = fishSetting;
		this.nibblePeriods = nibbles;
	}

	@Override
	public String toString() {
		return "Fish [id=" + id + ", name=" + name + ", description=" + description + ", fishType=" + fishType
				+ ", pressureStates=" + pressureStates + ", livingArea=" + livingAreas + ", daysActivity=" + daysActivity
				+ ", fishSetting=" + fishSettings + ", nibblePeriods=" + nibblePeriods + "]";
	}

}
