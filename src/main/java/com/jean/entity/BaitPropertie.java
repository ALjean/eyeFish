package com.jean.entity;

public class BaitPropertie {

    private int id;
    private String baitPropName;
    private String description;

    private BaitPropertieType baitPropTypes;
    private ParameterName paramNames;

    private double minRange;
    private double maxRange;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getBaitPropName() {
	return baitPropName;
    }

    public void setBaitPropName(String baitPropName) {
	this.baitPropName = baitPropName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public BaitPropertieType getBaitPropTypes() {
	return baitPropTypes;
    }

    public void setBaitPropTypes(BaitPropertieType baitPropTypes) {
	this.baitPropTypes = baitPropTypes;
    }

    public ParameterName getParamNames() {
	return paramNames;
    }

    public void setParamNames(ParameterName paramNames) {
	this.paramNames = paramNames;
    }

    public double getMinRange() {
	return minRange;
    }

    public void setMinRange(double minRange) {
	this.minRange = minRange;
    }

    public double getMaxRange() {
	return maxRange;
    }

    public void setMaxRange(double maxRange) {
	this.maxRange = maxRange;
    }

    @Override
    public String toString() {
	return "BaitPropertie [id=" + id + ", baitPropName=" + baitPropName + ", description=" + description + ", baitPropTypes=" + baitPropTypes
		+ ", paramNames=" + paramNames + ", minRange=" + minRange + ", maxRange=" + maxRange + "]";
    }

}
