package com.jean.entity;

import java.util.List;
import com.jean.analyzers.weather.AnalyzerResultObject;



public abstract class AbstractFish {

	private int id;
	private String name;
	private String description;
	private List<NibbleStateParam> nibbleStateParams;

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

	public List<NibbleStateParam> getNibbleStateParams() {
		return nibbleStateParams;
	}

	public void setNibbleStateParams(List<NibbleStateParam> nibbleStateParams) {
		this.nibbleStateParams = nibbleStateParams;
	}

	public abstract double hungryAnalyzer(AnalyzerResultObject resultObject);

	public abstract String locationAnalyzer(AnalyzerResultObject resultObject);
}