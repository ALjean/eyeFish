package com.jean.entity;

public class ParameterName {

    private int id;
    private String paramName;
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

    @Override
    public String toString() {
	return "ParameterName [id=" + id + ", paramName=" + paramName + ", priorityLevel=" + priorityLevel + "]";
    }

}
