package com.jean.entity;

public class ParameterName {

    private int id;
    private String paramName;
    private double allowableMin;
    private double allowableMax;
    private int priorityLevel;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getParamName() {
	return paramName;
    }

    public void setParamName(String paramName) {
	this.paramName = paramName;
    }

    public int getPriorityLevel() {
	return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
	this.priorityLevel = priorityLevel;
    }

    public double getAllowableMin() {
	return allowableMin;
    }

    public void setAllowableMin(double allowableMin) {
	this.allowableMin = allowableMin;
    }

    public double getAllowableMax() {
	return allowableMax;
    }

    public void setAllowableMax(double allowableMax) {
	this.allowableMax = allowableMax;
    }

    @Override
    public String toString() {
	return "ParameterName [id=" + id + ", paramName=" + paramName + ", allowableMin=" + allowableMin + ", allowableMax=" + allowableMax
		+ ", priorityLevel=" + priorityLevel + "]";
    }

    public ParameterName() {
	super();
    }

    public ParameterName(int id, String paramName, double allowableMin, double allowableMax, int priorityLevel) {
	super();
	this.id = id;
	this.paramName = paramName;
	this.allowableMin = allowableMin;
	this.allowableMax = allowableMax;
	this.priorityLevel = priorityLevel;
    }

}
