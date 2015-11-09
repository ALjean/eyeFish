package com.jean.analyzers;

public class RangeTempParam {

	private int minValue;
	private int maxValue;
	
	public RangeTempParam() {
		super();
	}
	public RangeTempParam(int minValue, int maxValue) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	public int getMinValue() {
		return minValue;
	}
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	@Override
	public String toString() {
		return "RangeParam [minValue=" + minValue + ", maxValue=" + maxValue
				+ "]";
	}
	
	
}
