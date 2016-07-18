package com.jean.util;

public class Qualifier {

    private int qualId;
    private String paramName;
    private float min;
    private float max;

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

    public float getMin() {
	return min;
    }

    public void setMin(float min) {
	this.min = min;
    }

    public float getMax() {
	return max;
    }

    public void setMax(float max) {
	this.max = max;
    }

    public Qualifier() {
	super();
    }

    public Qualifier(int qual_id, String paramName, float min, float max) {
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
