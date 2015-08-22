package com.jean.entity;

import java.util.Map;

/**
 * Created by Stas Patek and Aleksey Gloliev and Some Guy With Big Head on 30.05.15.
 */
public class Fish {

	private long id;

	private String name;
	
	private Map<String, WeatherState> hungry;
	
	private Map<String, WeatherState> location;

	private Spawning spawning;
	
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Spawning getSpawning() {
		return spawning;
	}

	public void setSpawning(Spawning spawning) {
		this.spawning = spawning;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fish [id=" + id + ", hungry=" + hungry + ", location="
				+ location + ", description=" + description + "]";
	}

}
