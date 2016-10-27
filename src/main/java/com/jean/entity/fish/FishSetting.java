package com.jean.entity.fish;

/**
 * Created by Stas on 15.11.2015.
 */
public class FishSetting {

	private int id;
	private int fishId;
	private String paramName;
	private double minValue;
	private double maxValue;
	private double nibbleLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFishId() {
		return fishId;
	}

	public void setFishId(int fishId) {
		this.fishId = fishId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double getNibbleLevel() {
		return nibbleLevel;
	}

	public void setNibbleLevel(double nibbleLevel) {
		this.nibbleLevel = nibbleLevel;
	}

	public FishSetting() {
		super();
	}

	public FishSetting(int id, int fishId, String paramName, double minValue, double maxValue, double nibbleLevel) {
		super();
		this.id = id;
		this.fishId = fishId;
		this.paramName = paramName;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.nibbleLevel = nibbleLevel;
	}

	@Override
	public String toString() {
		return "FishSetting [id=" + id + ", fishId=" + fishId + ", paramName=" + paramName + ", minValue=" + minValue
				+ ", maxValue=" + maxValue + ", nibbleLevel=" + nibbleLevel + "]";
	}

}
