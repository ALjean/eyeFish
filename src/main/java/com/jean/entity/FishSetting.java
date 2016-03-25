package com.jean.entity;

/**
 * Created by Stas on 15.11.2015.
 */
public class FishSetting {

    private int id;
    private int fishId;
    private ParameterName paramName;
    private double minValue;
    private double maxValue;
    private float nibbleLevel;

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

    public ParameterName getParamName() {
	return paramName;
    }

    public void setParamName(ParameterName paramName) {
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

    public float getNibbleLevel() {
	return nibbleLevel;
    }

    public void setNibbleLevel(float nibbleLevel) {
	this.nibbleLevel = nibbleLevel;
    }

    @Override
    public String toString() {
	return "FishSetting [id=" + id + ", fishId=" + fishId + ", paramName=" + paramName + ", minValue=" + minValue + ", maxValue=" + maxValue
		+ ", nibbleLevel=" + nibbleLevel + "]";
    }

}
