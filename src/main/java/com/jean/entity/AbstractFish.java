package com.jean.entity;

import java.util.List;
import java.util.Map;

import com.jean.analyzers.AnalyzerResultObject;
import com.jean.analyzers.RangeTempParam;



public abstract class AbstractFish {

	private int id;
	private String name;
	private String description;
	private List<Temperature> temperatures;
	private Map<Double, RangeTempParam> temperatureRange;

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

	public List<Temperature> getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(List<Temperature> temperatures) {
		this.temperatures = temperatures;
	}

	public void setTemperatureRange(Map<Double, RangeTempParam> temperatureRange) {
		this.temperatureRange = temperatureRange;
	}

	public abstract double hungryAnalyzer(AnalyzerResultObject resultObject);

	public abstract String locationAnalyzer(AnalyzerResultObject resultObject);
}
