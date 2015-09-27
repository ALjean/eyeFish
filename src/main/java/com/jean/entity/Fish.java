package com.jean.entity;

import java.util.HashMap;
import java.util.Map;


public class Fish {

    private int id;

    private String name;

    private String description;

    private Spawning spawning;

    private Map<String, WeatherState> hungry;

    private Map<String, WeatherState> location;

    public Fish() {
        hungry = new HashMap<>();
        location = new HashMap<>();
    }

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

    @Override
    public String toString() {
        return "Fish [id=" + id + ", name=" + name + ", description=" + description + ", spawning=" + spawning + ", hungry=" + hungry + ", location="
                + location + "]";
    }




}
