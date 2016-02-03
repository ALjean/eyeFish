package com.jean.entity;

public class Bait {

    private int id;
    private int fishId;
    private String baitType;
    private String name;
    private String description;
    private String color;
    private String taste;
    private String weight;

    public Bait(int id, int fishId, String baitType, String name, String description, String color, String taste, String weight) {
	super();
	this.id = id;
	this.fishId = fishId;
	this.baitType = baitType;
	this.name = name;
	this.description = description;
	this.color = color;
	this.taste = taste;
	this.weight = weight;
    }

    public Bait() {
	super();
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getFishId() {
	return fishId;
    }

    public void setFishId(int fishId) {
	this.fishId = fishId;
    }

    public String getBaitType() {
	return baitType;
    }

    public void setBaitType(String baitType) {
	this.baitType = baitType;
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

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public String getTaste() {
	return taste;
    }

    public void setTaste(String taste) {
	this.taste = taste;
    }

    public String getWeight() {
	return weight;
    }

    public void setWeight(String weight) {
	this.weight = weight;
    }

    @Override
    public String toString() {
	return "Bait [id=" + id + ", fishId=" + fishId + ", baitType=" + baitType + ", name=" + name + ", description=" + description + ", color="
		+ color + ", taste=" + taste + ", weight=" + weight + "]";
    }

}
