package com.jean.util;

public class Qualifier {

    private ParameterName paramName;
    private double min;
    private double max;

    public ParameterName getParameterName() {
	return paramName;
    }

    public void setParameterName(ParameterName parameterName) {
	this.paramName = parameterName;
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

    public ParameterName getParamName() {
	return paramName;
    }

    public void setParamName(ParameterName paramName) {
	this.paramName = paramName;
    }

    public Qualifier() {
	super();
    }

    public Qualifier(ParameterName parameterName, double min, double max) {
	super();
	this.paramName = parameterName;
	this.min = min;
	this.max = max;
    }

}
