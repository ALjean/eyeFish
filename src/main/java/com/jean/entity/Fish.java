package com.jean.entity;

import java.util.Map;

/**
 * Created by Stas Patek and Aleksey Gloliev and Some Guy With Big Head on 30.05.15.
 */
public class Fish {

	private long id;
	
	private Map<String, WeatherState> hungry;
	
	private Map<String, WeatherState> location;
	
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Fish [id=" + id + ", hungry=" + hungry + ", location="
				+ location + ", description=" + description + "]";
	}

	public Fish(long id, Map<String, WeatherState> hungry,
			Map<String, WeatherState> location, String description) {
		super();
		this.id = id;
		this.hungry = hungry;
		this.location = location;
		this.description = description;
	}

	public Fish() {
		super();
	}
	
	
 
}
