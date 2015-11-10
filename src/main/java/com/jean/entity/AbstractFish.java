package com.jean.entity;

import java.util.Map;

import com.jean.analyzers.AnalyzerResultObject;
import com.jean.analyzers.RangeTempParam;



public abstract class AbstractFish {

	private int id;
	private String name;
	private String description;

	private Map<Double, RangeTempParam> temperatureRange;
	private Map<String, WeatherState> hungry; //todo?
	private Map<String, WeatherState> location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<Double, RangeTempParam> getTemperatureRange() {
		return temperatureRange;
	}

	public Map<String, WeatherState> getHungry() {
		return hungry;
	}

	public void setHungry(Map<String, WeatherState> hungry) {
		this.hungry = hungry;
	}

	public Map<String, WeatherState> getLocation() {
		return location;
	}

	public void setLocation(Map<String, WeatherState> location) {
		this.location = location;
	}

	public void setTemperatureRange(Map<Double, RangeTempParam> temperatureRange) {
		this.temperatureRange = temperatureRange;
	}

	public abstract double hungryAnalyzer(AnalyzerResultObject resultObject);

	public abstract String locationAnalyzer(AnalyzerResultObject resultObject);
}
