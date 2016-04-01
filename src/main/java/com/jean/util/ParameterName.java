package com.jean.util;

public class ParameterName {

    private String paramName;
    private int priorityLevel;

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

    public ParameterName() {
	super();
    }

    public ParameterName(String paramName, int priorityLevel) {
	super();
	this.paramName = paramName;
	this.priorityLevel = priorityLevel;
    }

}
