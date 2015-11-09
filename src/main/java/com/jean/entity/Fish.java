package com.jean.entity;

import java.util.Map;

import com.jean.analyzers.AnalizationResultObject;
import com.jean.analyzers.RangeTempParam;



public abstract class Fish {

	private int id;
	private String name;
	private String description;

	private Map<Double, RangeTempParam> tmperatureRange;

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

	public Map<Double, RangeTempParam> getTmperatureRange() {
		return tmperatureRange;
	}

	public void setTmperatureRange(Map<Double, RangeTempParam> tmperatureRange) {
		this.tmperatureRange = tmperatureRange;
	}

	public abstract double hungryAnalyzator(AnalizationResultObject resultObject);

	public abstract String locationAnalyzator(AnalizationResultObject resultObject);
}
