package com.jean.servlet.model;

/**
 * Created by Stas Patek and Aleksey Gloliev and Some Guy 26.08.15.
 */

public class RangeWeatherParametersDto {

	private int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WeatherState [min=" + min + ", max=" + max
				+ ", typeDataWeather=" + typeDataWeather + "]";
	}
}
