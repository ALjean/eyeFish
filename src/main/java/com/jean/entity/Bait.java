package com.jean.entity;

import com.jean.enums.BaitTypes;


public class Bait {

	private int id;
	private String name;
	private BaitTypes type;
	private String description;

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

	public BaitTypes getType() {
		return type;
	}

	public void setType(BaitTypes type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Bait [id=" + id + ", name=" + name + ", baitType=" + type + ", description=" + description + "]";
	}

	public Bait() {
	    super();
	}

	public Bait(int id, String name, BaitTypes type, String description) {
	    super();
	    this.id = id;
	    this.name = name;
	    this.type = type;
	    this.description = description;
	}
	
	

}
