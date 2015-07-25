package com.jean.entity;

/**
 * Created by Stas Patek and Aleksey Gloliev and Some Guy With Big Head.
 */

public class WeatherState {

	private float min;
	
	private float max;
	
	private String typeDataWeather;

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

	public String getTypeDataWeather() {
		return typeDataWeather;
	}

	public void setTypeDataWeather(String typeDataWeather) {
		this.typeDataWeather = typeDataWeather;
	}

	@Override
	public String toString() {
		return "WeatherState [min=" + min + ", max=" + max
				+ ", typeDataWeather=" + typeDataWeather + "]";
	}

	public WeatherState(float min, float max, String typeDataWeather) {
		super();
		this.min = min;
		this.max = max;
		this.typeDataWeather = typeDataWeather;
	}

	public WeatherState() {
		super();
	}
	
	
}
