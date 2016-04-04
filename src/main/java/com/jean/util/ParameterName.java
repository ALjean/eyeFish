package com.jean.util;

public class ParameterName {

	private String paramName;
	private double allowMin;
	private double allowMax;

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public double getAllowMin() {
		return allowMin;
	}

	public void setAllowMin(double allowMin) {
		this.allowMin = allowMin;
	}

	public double getAllowMax() {
		return allowMax;
	}

	public void setAllowMax(double allowMax) {
		this.allowMax = allowMax;
	}

	public ParameterName() {
		super();
	}

	public ParameterName(String paramName, double allowMin, double allowMax) {
		super();
		this.paramName = paramName;
		this.allowMin = allowMin;
		this.allowMax = allowMax;
	}

}
