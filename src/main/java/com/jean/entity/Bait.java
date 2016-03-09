package com.jean.entity;

import com.jean.analyzers.weather.ConstantsAnalyzer;
import com.jean.enums.BaitType;

import java.util.List;

public class Bait {

	private int id;
	private String name;
	private BaitType type;
	private String description;

	private List<BaitProperties> baitProperties;

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

	public BaitType getType() {
		return type;
	}

	public void setType(BaitType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BaitProperties> getBaitProperties() {
		return baitProperties;
	}

	public void setBaitProperties(List<BaitProperties> baitProperties) {
		this.baitProperties = baitProperties;
	}

	@Override
	public String toString() {
		return "Bait [id=" + id + ", name=" + name + ", baitType=" + type + ", description=" + description
				+ ", baitProperties=" + baitProperties + "]";
	}

}
