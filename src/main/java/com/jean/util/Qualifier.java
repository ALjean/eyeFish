package com.jean.util;

public class Qualifier {

    private ParameterName parameterName;
    private double min;
    private double max;

    public ParameterName getParameterName() {
	return parameterName;
    }

    public void setParameterName(ParameterName parameterName) {
	this.parameterName = parameterName;
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

    public Qualifier(ParameterName parameterName, double min, double max) {
	super();
	this.parameterName = parameterName;
	this.min = min;
	this.max = max;
    }

}
