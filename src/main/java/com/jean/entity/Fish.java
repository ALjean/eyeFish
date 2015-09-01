package com.jean.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jean.util.Constants;

public class Fish {

    private int id;

    private String name;

    private String description;

    private Spawning spawning;

    private Map<String, List<RangeWeatherParameters>> hungry;

    private Map<String, List<RangeWeatherParameters>> location;

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

    public Spawning getSpawning() {
	return spawning;
    }

    public void setSpawning(Spawning spawning) {
	this.spawning = spawning;
    }

    public Map<String, List<RangeWeatherParameters>> getHungry() {
	return hungry;
    }

    public void setHungry(Map<String, List<RangeWeatherParameters>> hungry) {
	this.hungry = hungry;
    }

    public Map<String, List<RangeWeatherParameters>> getLocation() {
	return location;
    }

    public void setLocation(Map<String, List<RangeWeatherParameters>> location) {
	this.location = location;
    }

   
    @Override
    public String toString() {
	return "Fish [id=" + id + ", name=" + name + ", description=" + description + ", spawning=" + spawning + ", hungry=" + hungry + ", location="
		+ location + "]";
    }

    public Fish() {
	hungry = new HashMap<String, List<RangeWeatherParameters>>();
	location = new HashMap<String, List<RangeWeatherParameters>>();
	
	for (Constants.StateMarkHungry stateMark : Constants.StateMarkHungry.values()) {
	    hungry.put(stateMark.toString(), new ArrayList<RangeWeatherParameters>());
	}
	for(Constants.StateMarkLocation stateMark : Constants.StateMarkLocation.values()){
	    location.put(stateMark.toString(), new ArrayList<RangeWeatherParameters>());
	}
    }
    
    public static void main(String[] args){
	Fish fish = new Fish();
	System.out.println(fish.getHungry());
    }

}
