package com.jean.util;

public class Qualifier {

    private int qualId;
    private String paramName;
    private double min;
    private double max;

    public int getQuaId() {
	return qualId;
    }

    public void setQuaId(int qual_id) {
	this.qualId = qual_id;
    }

    public String getParamName() {
	return paramName;
    }

    public void setParamName(String paramName) {
	this.paramName = paramName;
    }

    public double getMin() {
	return min;
    }

    public void setMin(double min) {
	this.min = min;
    }

    public double getMax() {
	return max;
    }

    public void setMax(double max) {
	this.max = max;
    }

    public Qualifier() {
	super();
    }

    public Qualifier(int qual_id, String paramName, double min, double max) {
	super();
	this.qualId = qual_id;
	this.paramName = paramName;
	this.min = min;
	this.max = max;
    }

    @Override
    public String toString() {
	return "Qualifier [qual_id=" + qualId + ", paramName=" + paramName + ", min=" + min + ", max=" + max + "]";
    }

}
