package com.jean.entity;

import java.util.List;

public class Bait {

	private int id;
	private String name;
	private String baitType;
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

	public String getBaitType() {
		return baitType;
	}

	public void setBaitType(String baitType) {
		this.baitType = baitType;
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
		return "Bait [id=" + id + ", name=" + name + ", baitType=" + baitType + ", description=" + description
				+ ", baitProperties=" + baitProperties + "]";
	}

}
